package com.ss.cfsd.utopia.domain;

import java.util.List;

public class Booking {

	private Integer id = null;
	private Boolean isActive = null;
	private String confirmationCode = null;
	private List<FlightBookings> flightBookings = null;

	public Integer getId() {
		return id;
	}
	
	public Boolean getIsActive() {
		return isActive;
	}
	
	public String getConfirmationCode() {
		return confirmationCode;
	}
	
	public List<FlightBookings> getFlightBookings() {
		return flightBookings;
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
	
	public void setFlightBookings(List<FlightBookings> flightBookings) {
		this.flightBookings = flightBookings;
	}
}
