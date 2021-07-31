package com.ss.cfsd.utopia.domain;

public class Booking {

	private Integer id = null;
	private Boolean isActive = null;
	private String confirmationCode = null;
	
	public Integer getId() {
		return id;
	}
	
	public Boolean getIsActive() {
		return isActive;
	}
	
	public String getConfirmationCode() {
		return confirmationCode;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
	}
}
