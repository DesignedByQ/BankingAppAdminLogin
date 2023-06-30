package com.techprj.registration.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TwoFACodeService {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void update2FAProperties(String emailid, String twofacode) {
		
		jdbcTemplate.update("update authentication set twofacode=?, twofacodeexpirytime=? " + "where id_auth_user in (select id_admin from admin where email=?)", new Object[] {
				
				twofacode, (System.currentTimeMillis()/1000) + 12000L, emailid
				
		});
		
	}

	@SuppressWarnings("deprecation")
	public boolean checkCode(String emailid, String code) {

		return jdbcTemplate.queryForObject("select count(*) from authentication where twofacode=? and twofacodeexpirytime >=? and id_auth_user in (select id_admin from admin where email=?)", new Object[] {
				code, System.currentTimeMillis()/1000, emailid
		}, Integer.class) >0;
		
	}
	
	public Boolean checkCredentials(String emailid, String password) {

			return jdbcTemplate.queryForObject("select count(*) from admin where email=? and id_admin in " + "(select id_auth_user from authentication where password=?)", new Object[] {
					emailid, password
			}, Integer.class) >0;
			
	}

}
