package com.techprj.registration.admin.dto;

import java.time.LocalDate;

public class AdminDTO {
	
	private Long idAdmin;
	private AuthUserDTO authUserDTO;
	private String firstName;
	private String middleName;
	private String lastName;
	private Long mobile;
	private String email;
	private AddressDTO addressDTO;
	private LocalDate staffSince;
	
	public AdminDTO() {
		super();
	}

	public AdminDTO(Long idAdmin, AuthUserDTO authUserDTO, String firstName, String middleName, String lastName,
			Long mobile, String email, AddressDTO addressDTO, LocalDate staffSince) {
		super();
		this.idAdmin = idAdmin;
		this.authUserDTO = authUserDTO;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.email = email;
		this.addressDTO = addressDTO;
		this.staffSince = staffSince;
	}

	public Long getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}

	public AuthUserDTO getAuthUserDTO() {
		return authUserDTO;
	}

	public void setAuthUserDTO(AuthUserDTO authUserDTO) {
		this.authUserDTO = authUserDTO;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AddressDTO getAddressDTO() {
		return addressDTO;
	}

	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}

	public LocalDate getStaffSince() {
		return staffSince;
	}

	public void setStaffSince(LocalDate staffSince) {
		this.staffSince = staffSince;
	}

	@Override
	public String toString() {
		return "AdminDTO [idAdmin=" + idAdmin + ", authUserDTO=" + authUserDTO + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", mobile=" + mobile + ", email=" + email
				+ ", addressDTO=" + addressDTO + ", staffSince=" + staffSince + "]";
	}
	
}
