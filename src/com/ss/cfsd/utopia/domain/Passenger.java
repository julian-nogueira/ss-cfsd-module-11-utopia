package com.ss.cfsd.utopia.domain;

import java.sql.Date;

public class Passenger {

	private Integer id = null;
	private Integer bookingId = null;
	private String givenName = null;
	private String familyName = null;
	private Date dob = null;
	private String gender = null;
	private String address = null;
	
	public Integer getId() {
		return id;
	}
	
	public Integer getBookingId() {
		return bookingId;
	}
	
	public String getGivenName() {
		return givenName;
	}
	
	public String getFamilyName() {
		return familyName;
	}
	
	public Date getDob() {
		return dob;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setBookingId(Booking booking) {
		bookingId = booking.getId();
	}
	
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
}
