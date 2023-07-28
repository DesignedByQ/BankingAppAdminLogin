package com.techprj.registration.admin.dto;

import java.time.LocalDateTime;

public class LoginLogDTO {
	
	private Long idLoginLog;
	private String iP;
	private String location;
	private LocalDateTime eventTime;
	private AdminDTO adminDTO;
	
	public LoginLogDTO() {
		super();
	}

	public LoginLogDTO(Long idLoginLog, String iP, String location, LocalDateTime eventTime, AdminDTO adminDTO) {
		super();
		this.idLoginLog = idLoginLog;
		this.iP = iP;
		this.location = location;
		this.eventTime = eventTime;
		this.adminDTO = adminDTO;
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

	public AdminDTO getAdminDTO() {
		return adminDTO;
	}

	public void setAdminDTO(AdminDTO adminDTO) {
		this.adminDTO = adminDTO;
	}

	@Override
	public String toString() {
		return "LoginLogDTO [idLoginLog=" + idLoginLog + ", iP=" + iP + ", location=" + location + ", eventTime="
				+ eventTime + ", adminDTO=" + adminDTO + "]";
	}

}
