package com.techprj.registration.admin.service;

import java.util.List;

import com.techprj.registration.admin.dto.AdminDTO;
import com.techprj.registration.admin.dto.LoginLogDTO;

public interface DAOService {
	
	AdminDTO addAdmin(AdminDTO adminDTO);
	
	AdminDTO getAdmin(String email);
	
	LoginLogDTO createLog(String emailid);

	List<LoginLogDTO> getLog(String emailid);


}
