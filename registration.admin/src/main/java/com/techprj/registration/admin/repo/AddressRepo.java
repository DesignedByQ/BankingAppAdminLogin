package com.techprj.registration.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techprj.registration.admin.entity.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long>{

}
