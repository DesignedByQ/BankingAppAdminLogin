package com.techprj.registration.admin.dto;

public class AuthUserDTO {
	
	private Long idAuthUser;
	private String jobRole;
	private String password;
	private Boolean isSuperuser;
	private Boolean isStaff;
	private Long twoFACode;
	private Long twoFACodeExpiryTime;
	
	public AuthUserDTO() {
		super();
	}

	public AuthUserDTO(Long idAuthUser, String jobRole, String password, Boolean isSuperuser, Boolean isStaff,
			Long twoFACode, Long twoFACodeExpiryTime) {
		super();
		this.idAuthUser = idAuthUser;
		this.jobRole = jobRole;
		this.password = password;
		this.isSuperuser = isSuperuser;
		this.isStaff = isStaff;
		this.twoFACode = twoFACode;
		this.twoFACodeExpiryTime = twoFACodeExpiryTime;
	}

	public Long getIdAuthUser() {
		return idAuthUser;
	}

	public void setIdAuthUser(Long idAuthUser) {
		this.idAuthUser = idAuthUser;
	}

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
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

	@Override
	public String toString() {
		return "AuthUserDTO [idAuthUser=" + idAuthUser + ", jobRole=" + jobRole + ", password=" + password
				+ ", isSuperuser=" + isSuperuser + ", isStaff=" + isStaff + ", twoFACode=" + twoFACode
				+ ", twoFACodeExpiryTime=" + twoFACodeExpiryTime + "]";
	}


}
