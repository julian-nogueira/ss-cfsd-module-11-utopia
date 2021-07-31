package com.ss.cfsd.utopia.dao;

import com.ss.cfsd.utopia.domain.BookingGuest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingGuestDAO extends BaseDAO<BookingGuest> {
	
	public BookingGuestDAO(Connection conn) throws ClassNotFoundException, SQLException {
		super(conn);
	}
	
	// Create.
	public void createBookingGuest(BookingGuest bookingGuest) throws SQLException, ClassNotFoundException {
		save("INSERT INTO booking_guest(booking_id, contact_email, contact_phone) VALUES(?, ?, ?);",
				new Object[] {bookingGuest.getBookingId(), bookingGuest.getContactEmail(), bookingGuest.getContactPhone()});
	}

	// Read.
	public List<BookingGuest> readBookingGuest() throws SQLException, ClassNotFoundException {
		return read("SELECT * FROM booking_guest;", new Object[] {});
	}
	
	// Update.
	public void updateBookingGuest(BookingGuest bookingGuest) throws SQLException, ClassNotFoundException {
		save("UPDATE booking_guest SET contact_email = ?, contact_phone = ? WHERE booking_id = ?;",
				new Object[] {bookingGuest.getContactEmail(), bookingGuest.getContactPhone(), bookingGuest.getBookingId()});
	}
	
	// Delete.
	public void deleteBookingGuest(BookingGuest bookingGuest) throws SQLException, ClassNotFoundException {
		save("DELETE FROM booking_guest WHERE booking_id = ?;",
				new Object[] {bookingGuest.getBookingId()});
	}

	@Override
	public List<BookingGuest> extractData(ResultSet rs) throws SQLException {
		List<BookingGuest> bookingGuestList = new ArrayList<BookingGuest>();
		while(rs.next()) {
			BookingGuest bookingGuest = new BookingGuest();
			bookingGuest.setBookingId(rs.getInt("booking_id"));
			bookingGuest.setContactEmail(rs.getString("contact_email"));
			bookingGuest.setContactPhone(rs.getString("contact_phone"));
			bookingGuestList.add(bookingGuest);
		}
		return bookingGuestList;
	}
}
