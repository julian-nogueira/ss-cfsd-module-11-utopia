package com.ss.cfsd.utopia.domain;

public class FlightBookings {

	private Integer flightId = null;
	private Integer bookingId = null;
	
	public Integer getFlightId() {
		return flightId;
	}
	
	public Integer getBookingId() {
		return bookingId;
	}
	
	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}
	
	public void setFlightId(Flight flight) {
		flightId = flight.getId();
	}
	
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	
	public void setBookingId(Booking booking) {
		bookingId = booking.getId();
	}
}
