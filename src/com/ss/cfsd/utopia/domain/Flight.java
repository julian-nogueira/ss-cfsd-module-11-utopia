package com.ss.cfsd.utopia.domain;

import java.sql.Timestamp;
import java.util.List;

public class Flight {

	private Integer id = null;
	private Integer routeId = null;
	private Integer airplaneId = null;
	private Timestamp departureTime = null;
	private Integer reservedSeats = null;
	private Float seatPrice = null;
	private Route route = null;
	private List<FlightBookings> flightBookings = null;
	
	public Integer getId() {
		return id;
	}
	
	public Integer getRouteId() {
		return routeId;
	}
	
	public Integer getAirplaneId() {
		return airplaneId;
	}
	
	public Timestamp getDepartureTime() {
		return departureTime;
	}
	
	public Integer getReservedSeats() {
		return reservedSeats;
	}
	
	public Float getSeatPrice() {
		return seatPrice;
	}
	
	public Route getRoute() {
		return route;
	}
	
	public List<FlightBookings> getFlightBookings() {
		return flightBookings;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}
	
	public void setRouteId(Route route) {
		routeId = route.getId();
	}
	
	public void setAirplaneId(Integer airplaneId) {
		this.airplaneId = airplaneId;
	}
	
	public void setAirplaneId(Airplane airplane) {
		airplaneId = airplane.getId();
	}

	public void setDepartureTime(Timestamp departureTime) {
		this.departureTime = departureTime;
	}

	public void setReservedSeats(Integer reservedSeats) {
		this.reservedSeats = reservedSeats;
	}

	public void setSeatPrice(Float seatPrice) {
		this.seatPrice = seatPrice;
	}
	
	public void setRoute(Route route) {
		this.route = route;
	}
	
	public void setFlightBookings(List<FlightBookings> flightBookings) {
		this.flightBookings= flightBookings;
	}
}
