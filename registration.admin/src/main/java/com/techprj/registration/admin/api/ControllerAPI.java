package com.techprj.registration.admin.api;

import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techprj.registration.admin.dto.AdminDTO;
import com.techprj.registration.admin.dto.LoginLogDTO;
import com.techprj.registration.admin.service.DAOServiceImpl;
import com.techprj.registration.admin.service.EmailService;
import com.techprj.registration.admin.service.TwoFACodeService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
@Validated
public class ControllerAPI {
	
	@Autowired
	DAOServiceImpl daoServiceImpl;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	TwoFACodeService twoFACodeService;
	
	@PostMapping(value="/addadmin", consumes = {MediaType.ALL_VALUE})
	public ResponseEntity<AdminDTO> addAdmin(@RequestBody AdminDTO adminDTO) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(daoServiceImpl.addAdmin(adminDTO));
		
	}
	
	@GetMapping(value="/getadmin/{email}", consumes = {MediaType.ALL_VALUE}, produces = {"application/json", "application/xml"})
	public ResponseEntity<AdminDTO> getAdmin(@PathVariable("email") String email) {
		
		return ResponseEntity.status(HttpStatus.OK).body(daoServiceImpl.getAdmin(email));
		
	}
	
	@PutMapping(value="/emails/{emailid}/password/{password}/2fa", consumes={MediaType.ALL_VALUE})
	public ResponseEntity<Object> send2faCodeinEmail(@PathVariable("emailid") String emailid, @PathVariable("password") String password) throws AddressException, MessagingException {
		
		//validate the account exists
		//amend this to return a integer 0 = dont exist 1 = cust 2 = staff
		boolean accExists = twoFACodeService.checkCredentials(emailid, password);
		
		//System.out.println(accExists);
		
		if(accExists) {
			String twoFaCode = String.valueOf(new Random().nextInt(9999)+1000);
			emailService.sendEmail(emailid, twoFaCode);
			twoFACodeService.update2FAProperties(emailid, twoFaCode);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		
	}
	
	@PutMapping(value="/emails/{emailid}/codes/{twofacode}", consumes={MediaType.ALL_VALUE})
	public ResponseEntity<Object> verify(@PathVariable("emailid") String emailid, @PathVariable("twofacode") String code){
		
		boolean isValid = twoFACodeService.checkCode(emailid, code);
		
		if(isValid) {
			//create function that makes entry into log table
			daoServiceImpl.createLog(emailid);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);	
		
	}
	
	@GetMapping(value="/getlog/{email}", consumes = {MediaType.ALL_VALUE}, produces = {"application/json", "application/xml"})
	public ResponseEntity<List<LoginLogDTO>> getLog(@PathVariable("email") String email) {
		return ResponseEntity.status(HttpStatus.OK).body(daoServiceImpl.getLog(email));
	}

}
