package com.ss.cfsd.utopia.domain;

public class BookingPayment {

	private Integer bookingId = null;
	private String stripeId = null;
	private Byte refunded = null;
	
	public Integer getBookingId() {
		return bookingId;
	}
	
	public String getStripeId() {
		return stripeId;
	}
	
	public Byte getRefunded() {
		return refunded;
	}
	
	public void setBookingId(Booking booking) {
		bookingId = booking.getId();
	}
	
	public void setStripeId(String stripeId) {
		this.stripeId = stripeId;
	}
	
	public void setRefunded(Byte refunded) {
		this.refunded = refunded;
	}
}
