package com.ss.cfsd.utopia.dao;

import com.ss.cfsd.utopia.domain.Booking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO extends BaseDAO<Booking> {

	public BookingDAO(Connection conn) throws ClassNotFoundException, SQLException {
		super(conn);
	}
	
	// Create.
	public void createBooking(Booking booking) throws SQLException, ClassNotFoundException {
		save("INSERT INTO booking(is_active, confirmation_code) VALUES(?, ?);",
				new Object[] {booking.getIsActive(), booking.getConfirmationCode()});
	}

	// Read.
	public List<Booking> readBooking() throws SQLException, ClassNotFoundException {
		return read("SELECT * FROM booking;", new Object[] {});
	}
	
	// Update.
	public void updateBooking(Booking booking) throws SQLException, ClassNotFoundException {
		save("UPDATE booking SET is_active = ?, confirmation_code = ? WHERE id = ?;",
				new Object[] {booking.getIsActive(), booking.getConfirmationCode(), booking.getId()});
	}
	
	// Delete.
	public void deleteBooking(Booking booking) throws SQLException, ClassNotFoundException {
		save("DELETE FROM booking WHERE id = ?;",
				new Object[] {booking.getId()});
	}

	@Override
	public List<Booking> extractData(ResultSet rs) throws SQLException {
		List<Booking> bookingList = new ArrayList<Booking>();
		while(rs.next()) {
			Booking booking = new Booking();
			booking.setId(rs.getInt("id"));
			booking.setIsActive(rs.getBoolean("is_active"));
			booking.setConfirmationCode(rs.getString("confirmation_code"));
			bookingList.add(booking);
		}
		return bookingList;
	}
}