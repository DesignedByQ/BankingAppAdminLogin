package com.techprj.registration.admin.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAdmin;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Auth_User")
	private AuthUser authUser;
	private String firstName;
	private String middleName;
	private String lastName;
	@Column(unique = true)
	private Long mobile;
	@Column(unique = true)
	private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_ID")
	private Address address;
	private LocalDate staffSince;
	
	public Admin() {
		super();
	}

	public Admin(Long idAdmin, AuthUser authUser, String firstName, String middleName, String lastName, Long mobile,
			String email, Address address, LocalDate staffSince) {
		super();
		this.idAdmin = idAdmin;
		this.authUser = authUser;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.staffSince = staffSince;
	}

	public Long getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}

	public AuthUser getAuthUser() {
		return authUser;
	}

	public void setAuthUser(AuthUser authUser) {
		this.authUser = authUser;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public LocalDate getStaffSince() {
		return staffSince;
	}

	public void setStaffSince(LocalDate staffSince) {
		this.staffSince = staffSince;
	}

	@Override
	public String toString() {
		return "Admin [idAdmin=" + idAdmin + ", authUser=" + authUser + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", mobile=" + mobile + ", email=" + email + ", address="
				+ address + ", staffSince=" + staffSince + "]";
	}

}
