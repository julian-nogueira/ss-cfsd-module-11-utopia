package com.ss.cfsd.utopia.dao;

import com.ss.cfsd.utopia.domain.FlightBookings;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightBookingsDAO extends BaseDAO<FlightBookings> {

	public FlightBookingsDAO(Connection conn) throws ClassNotFoundException, SQLException {
		super(conn);
	}
	
	// Create.
	public void createFlightBookings(FlightBookings flightBookings) throws SQLException, ClassNotFoundException {
		save("INSERT INTO flight_bookings(flight_id, booking_id) VALUES(?, ?);",
				new Object[] {flightBookings.getFlightId(), flightBookings.getBookingId()});
	}

	// Read.
	public List<FlightBookings> readFlightBookings() throws SQLException, ClassNotFoundException {
		return read("SELECT * FROM flight_bookings;", new Object[] {});
	}
	
	// Update.
	public void updateFlightBookings(FlightBookings flightBookings) throws SQLException, ClassNotFoundException {
		save("UPDATE flight_bookings SET flight_id = ? WHERE booking_id = ?;",
				new Object[] {flightBookings.getFlightId(), flightBookings.getBookingId()});
	}
	
	// Delete.
	public void deleteFlightBookings(FlightBookings flightBookings) throws SQLException, ClassNotFoundException {
		save("DELETE FROM flight_bookings WHERE flight_id = ? AND booking_id = ?;",
				new Object[] {flightBookings.getFlightId(), flightBookings.getBookingId()});
	}

	@Override
	public List<FlightBookings> extractData(ResultSet rs) throws SQLException {
		List<FlightBookings> flightBookingsList = new ArrayList<FlightBookings>();
		while(rs.next()) {
			FlightBookings flightBookings = new FlightBookings();
			flightBookings.setFlightId(rs.getInt("flight_id"));
			flightBookings.setBookingId(rs.getInt("booking_id"));
			flightBookingsList.add(flightBookings);
		}
		return flightBookingsList;
	}
}
