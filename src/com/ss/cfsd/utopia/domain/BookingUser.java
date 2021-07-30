package com.ss.cfsd.utopia.domain;

public class BookingUser {

	private Integer bookingId = null;
	private Integer userId = null;
	
	public Integer getBookingId() {
		return bookingId;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setBookingId(Booking booking) {
		bookingId = booking.getId();
	}
	
	public void setUserId(User user) {
		userId = user.getId();
	}
}
