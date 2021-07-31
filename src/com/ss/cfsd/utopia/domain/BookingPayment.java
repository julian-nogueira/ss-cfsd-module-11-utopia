package com.ss.cfsd.utopia.domain;

public class BookingPayment {

	private Integer bookingId = null;
	private String stripeId = null;
	private Boolean refunded = null;
	
	public Integer getBookingId() {
		return bookingId;
	}
	
	public String getStripeId() {
		return stripeId;
	}
	
	public Boolean getRefunded() {
		return refunded;
	}
	
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	
	public void setBookingId(Booking booking) {
		bookingId = booking.getId();
	}
	
	public void setStripeId(String stripeId) {
		this.stripeId = stripeId;
	}
	
	public void setRefunded(Boolean refunded) {
		this.refunded = refunded;
	}
}
