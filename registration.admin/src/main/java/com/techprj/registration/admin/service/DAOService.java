package com.techprj.registration.admin.service;

import com.techprj.registration.admin.dto.AdminDTO;

public interface DAOService {
	
	AdminDTO addAdmin(AdminDTO adminDTO);
	
	AdminDTO getAdmin(String email);


}
