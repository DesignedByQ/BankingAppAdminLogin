package com.techprj.registration.admin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="authentication")
public class AuthUser {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_Auth_User")
	private Integer idAuthUser;
	private String username;
	private String password;
	private Boolean isSuperuser;
	private Boolean isStaff;
	private Long twoFACode;
	@Column(name = "twoFACodeexpirytime")
	private Long twoFACodeExpiryTime;	
	@OneToOne(mappedBy = "authUser")
	private Admin admin;
	
	public AuthUser() {
		super();
	}

	public AuthUser(Integer idAuthUser, String username, String password, Boolean isSuperuser, Boolean isStaff,
			Long twoFACode, Long twoFACodeExpiryTime, Admin admin) {
		super();
		this.idAuthUser = idAuthUser;
		this.username = username;
		this.password = password;
		this.isSuperuser = isSuperuser;
		this.isStaff = isStaff;
		this.twoFACode = twoFACode;
		this.twoFACodeExpiryTime = twoFACodeExpiryTime;
		this.admin = admin;
	}

	public Integer getIdAuthUser() {
		return idAuthUser;
	}

	public void setIdAuthUser(Integer idAuthUser) {
		this.idAuthUser = idAuthUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsSuperuser() {
		return isSuperuser;
	}

	public void setIsSuperuser(Boolean isSuperuser) {
		this.isSuperuser = isSuperuser;
	}

	public Boolean getIsStaff() {
		return isStaff;
	}

	public void setIsStaff(Boolean isStaff) {
		this.isStaff = isStaff;
	}

	public Long getTwoFACode() {
		return twoFACode;
	}

	public void setTwoFACode(Long twoFACode) {
		this.twoFACode = twoFACode;
	}

	public Long getTwoFACodeExpiryTime() {
		return twoFACodeExpiryTime;
	}

	public void setTwoFACodeExpiryTime(Long twoFACodeExpiryTime) {
		this.twoFACodeExpiryTime = twoFACodeExpiryTime;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "AuthUser [idAuthUser=" + idAuthUser + ", username=" + username + ", password=" + password
				+ ", isSuperuser=" + isSuperuser + ", isStaff=" + isStaff + ", twoFACode=" + twoFACode
				+ ", twoFACodeExpiryTime=" + twoFACodeExpiryTime + ", admin=" + admin + "]";
	}

}