package com.techprj.registration.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techprj.registration.admin.entity.LoginLog;

@Repository
public interface LoginLogRepo extends JpaRepository<LoginLog, Long>{

}
