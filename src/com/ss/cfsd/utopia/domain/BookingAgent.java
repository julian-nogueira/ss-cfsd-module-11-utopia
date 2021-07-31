package com.ss.cfsd.utopia.domain;

public class BookingAgent {

	private Integer bookingId = null;
	private Integer agentId = null;
	
	public Integer getBookingId() {
		return bookingId;
	}
	
	public Integer getAgentId() {
		return agentId;
	}
	
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	
	public void setBookingId(Booking booking) {
		bookingId = booking.getId();
	}
	
	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}
	
	public void setAgentId(User user) {
		agentId = user.getId();
	}
}
