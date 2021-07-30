package com.ss.cfsd.utopia.domain;

import java.sql.Timestamp;

public class Flight {

	private Integer id = null;
	private Integer routeId = null;
	private Integer airplaneId = null;
	private Timestamp departureTime = null;
	private Integer reservedSeats = null;
	private Float seatPrice = null;
	
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

	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setRouteId(Route route) {
		routeId = route.getId();
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
}
