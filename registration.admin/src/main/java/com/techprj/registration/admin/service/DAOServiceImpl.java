package com.techprj.registration.admin.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.techprj.registration.admin.dto.AddressDTO;
import com.techprj.registration.admin.dto.AdminDTO;
import com.techprj.registration.admin.dto.AuthUserDTO;
import com.techprj.registration.admin.entity.Address;
import com.techprj.registration.admin.entity.Admin;
import com.techprj.registration.admin.entity.AuthUser;
import com.techprj.registration.admin.repo.AdminRepo;

@Service
public class DAOServiceImpl implements DAOService {
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	AdminRepo adminRepo;

	@Override
	public AdminDTO addAdmin(AdminDTO adminDTO) {

		adminDTO.setStaffSince(LocalDate.now());
		
		Admin a = adminRepo.save(modelMapper.map(adminDTO, Admin.class));
		
		AuthUserDTO audto = modelMapper.map(a.getAuthUser(), AuthUserDTO.class);
		AddressDTO adddto = modelMapper.map(a.getAddress(), AddressDTO.class);
		
		AdminDTO adto = modelMapper.map(a, AdminDTO.class);
		
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
	


}
