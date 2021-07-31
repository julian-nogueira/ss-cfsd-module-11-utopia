package com.ss.cfsd.utopia.dao;

import com.ss.cfsd.utopia.domain.Flight;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO extends BaseDAO<Flight> {

	public FlightDAO(Connection conn) throws ClassNotFoundException, SQLException {
		super(conn);
	}
	
	// Create.
	public void createFlight(Flight flight) throws SQLException, ClassNotFoundException {
		save("INSERT INTO flight(route_id, airplane_id, departure_time, reserved_seats, seat_price) VALUES(?, ?, ?, ?, ?);",
				new Object[] {flight.getRouteId(), flight.getAirplaneId(), flight.getDepartureTime(), flight.getReservedSeats(), flight.getSeatPrice()});
	}

	// Read.
	public List<Flight> readFlight() throws SQLException, ClassNotFoundException {
		return read("SELECT * FROM flight;", new Object[] {});
	}
	
	// Update.
	public void updateFlight(Flight flight) throws SQLException, ClassNotFoundException {
		save("UPDATE flight SET route_id = ?, airplane_id = ?, departure_time = ?, reserved_seats = ?, seat_price = ? WHERE id = ?;",
				new Object[] {flight.getRouteId(), flight.getAirplaneId(), flight.getDepartureTime(),
						flight.getReservedSeats(), flight.getSeatPrice(), flight.getId()});
	}
	
	// Delete.
	public void deleteFlight(Flight flight) throws SQLException, ClassNotFoundException {
		save("DELETE FROM flight WHERE id = ?;",
				new Object[] {flight.getId()});
	}

	@Override
	public List<Flight> extractData(ResultSet rs) throws SQLException {
		List<Flight> flightList = new ArrayList<Flight>();
		while(rs.next()) {
			Flight flight = new Flight();
			flight.setId(rs.getInt("id"));
			flight.setRouteId(rs.getInt("route_id"));
			flight.setAirplaneId(rs.getInt("airplane_id"));
			flight.setDepartureTime(rs.getTimestamp("departure_time"));
			flight.setReservedSeats(rs.getInt("reserved_seats"));
			flight.setSeatPrice(rs.getFloat("seat_price"));
			flightList.add(flight);
		}
		return flightList;
	}
}
