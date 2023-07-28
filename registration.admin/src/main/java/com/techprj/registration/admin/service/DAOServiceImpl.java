package com.techprj.registration.admin.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.techprj.registration.admin.entity.LoginLog;

import com.techprj.registration.admin.dto.AddressDTO;
import com.techprj.registration.admin.dto.AdminDTO;
import com.techprj.registration.admin.dto.AuthUserDTO;
import com.techprj.registration.admin.dto.LoginLogDTO;
import com.techprj.registration.admin.entity.Address;
import com.techprj.registration.admin.entity.Admin;
import com.techprj.registration.admin.entity.AuthUser;
import com.techprj.registration.admin.repo.AddressRepo;
import com.techprj.registration.admin.repo.AdminRepo;
import com.techprj.registration.admin.repo.LoginLogRepo;

@Service
public class DAOServiceImpl implements DAOService {
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	AdminRepo adminRepo;
	
	@Autowired
	LoginLogRepo loginLogRepo;
	
	@Autowired
	AddressRepo addressRepo;

	@Override
	public AdminDTO addAdmin(AdminDTO adminDTO) {

		adminDTO.setStaffSince(LocalDate.now());
		
		Admin a = modelMapper.map(adminDTO, Admin.class);
		a.setAddress(modelMapper.map(adminDTO.getAddressDTO(), Address.class));
		a.setAuthUser(modelMapper.map(adminDTO.getAuthUserDTO(), AuthUser.class));
		
		Admin a1 = adminRepo.save(a);
				
		AuthUserDTO audto = modelMapper.map(a1.getAuthUser(), AuthUserDTO.class);
		AddressDTO adddto = modelMapper.map(a1.getAddress(), AddressDTO.class);
		
		AdminDTO adto = modelMapper.map(a1, AdminDTO.class);
		
		adto.setAuthUserDTO(audto);
		adto.setAddressDTO(adddto);
		
		return adto;
	}

	@Override
	public AdminDTO getAdmin(String email) {
		
		Admin a = adminRepo.findByEmail(email);
		
		AuthUserDTO audto = modelMapper.map(a.getAuthUser(), AuthUserDTO.class);
		AddressDTO adddto = modelMapper.map(a.getAddress(), AddressDTO.class);
		
		AdminDTO adto = modelMapper.map(a, AdminDTO.class);
		
		adto.setAuthUserDTO(audto);
		adto.setAddressDTO(adddto);
		
		return adto;
	}

	@Override
	public LoginLogDTO createLog(String emailid) {

		AdminDTO updto = getAdmin(emailid);
		
		//set user profile
		LoginLogDTO lldto = new LoginLogDTO();
		lldto.setAdminDTO(updto);
		
		//set IP address
		try {
			InetAddress localhost = InetAddress.getLocalHost();
			lldto.setiP(localhost.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		//set location
		try {
            URL url = new URL("https://ipapi.co/json/");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            System.out.println("*************************************************************************");
            System.out.println(response);
            reader.close();
            
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response.toString());
            System.out.println(jsonNode);
            String city = jsonNode.get("city").asText();
            System.out.println(city);
            lldto.setLocation(city);
            //System.out.println(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		//set date and time
		lldto.setEventTime(LocalDateTime.now());
		
		System.out.println(".............................");

		//System.out.println(lldto.getUserProfileDTO());
		
		LoginLog lolo = loginLogRepo.saveAndFlush(modelMapper.map(lldto, LoginLog.class));
		
		//System.out.println(lolo.getUserProfile());
				
		LoginLogDTO lolodto = modelMapper.map(lolo, LoginLogDTO.class);
		
		lolodto.setAdminDTO(updto);
		
		System.out.println(lolodto);
		
		return lolodto;
	}
	
	@Override
	public List<LoginLogDTO> getLog(String emailid) {
		
		Admin ad = adminRepo.findByEmail(emailid);
		
		Long id = ad.getIdAdmin();
		
		List<LoginLog> lolol = loginLogRepo.findAll();
		//System.out.println(lolol.size());
		List<LoginLogDTO> llldto = new ArrayList();
		
		for(LoginLog a: lolol) {
			
			if(a.getAdmin().getIdAdmin() == id) {
				
				LoginLogDTO newA = modelMapper.map(a, LoginLogDTO.class);
				
				AuthUserDTO audto = modelMapper.map(ad.getAuthUser(), AuthUserDTO.class);
				AddressDTO adddto = modelMapper.map(ad.getAddress(), AddressDTO.class);
				
				AdminDTO updto = modelMapper.map(ad, AdminDTO.class);
				
				updto.setAuthUserDTO(audto);
				updto.setAddressDTO(adddto);
				
				newA.setAdminDTO(updto);
				
				llldto.add(newA);
				
			}
			
		}
		
		return llldto;
		
	}

}
