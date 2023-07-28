package com.techprj.registration.admin.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import jakarta.persistence.JoinColumn;

@Entity
@Table(name="log")
public class LoginLog {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idLoginLog;
	private String iP;
	@Column(length = 1000)
	private String location;
	@Column(name="event_time")
	private LocalDateTime eventTime;
	@ManyToOne
	@JoinColumn(name="idAdmin")
	private Admin admin;
	
	public LoginLog() {
		super();
	}

	public LoginLog(Long idLoginLog, String iP, String location, LocalDateTime eventTime, Admin admin) {
		super();
		this.idLoginLog = idLoginLog;
		this.iP = iP;
		this.location = location;
		this.eventTime = eventTime;
		this.admin = admin;
	}

	public Long getIdLoginLog() {
		return idLoginLog;
	}

	public void setIdLoginLog(Long idLoginLog) {
		this.idLoginLog = idLoginLog;
	}

	public String getiP() {
		return iP;
	}

	public void setiP(String iP) {
		this.iP = iP;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDateTime getEventTime() {
		return eventTime;
	}

	public void setEventTime(LocalDateTime eventTime) {
		this.eventTime = eventTime;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "LoginLog [idLoginLog=" + idLoginLog + ", iP=" + iP + ", location=" + location + ", eventTime="
				+ eventTime + ", admin=" + admin + "]";
	}
	
}
