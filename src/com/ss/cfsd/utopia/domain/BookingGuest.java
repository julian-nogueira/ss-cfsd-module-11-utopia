package com.ss.cfsd.utopia.domain;

public class BookingGuest {

	private Integer bookingId = null;
	private String contactEmail = null;
	private String contactPhone = null;
	
	public Integer getBookingId() {
		return bookingId;
	}
	
	public String getContactEmail() {
		return contactEmail;
	}
	
	public String getContactPhone() {
		return contactPhone;
	}
	
	public void setBookingId(Booking booking) {
		bookingId = booking.getId();
	}
	
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
}
