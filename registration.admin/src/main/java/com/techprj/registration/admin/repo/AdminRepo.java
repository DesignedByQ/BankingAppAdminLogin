package com.techprj.registration.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techprj.registration.admin.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long>{

	Admin findByEmail(String email);

}
