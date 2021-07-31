package com.ss.cfsd.utopia.dao;

import com.ss.cfsd.utopia.domain.BookingUser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingUserDAO extends BaseDAO<BookingUser> {

	public BookingUserDAO(Connection conn) throws ClassNotFoundException, SQLException {
		super(conn);
	}
	
	// Create.
	public void createBookingUser(BookingUser bookingUser) throws SQLException, ClassNotFoundException {
		save("INSERT INTO booking_user(booking_id, user_id) VALUES(?, ?);",
				new Object[] {bookingUser.getBookingId(), bookingUser.getUserId()});
	}

	// Read.
	public List<BookingUser> readBookingUser() throws SQLException, ClassNotFoundException {
		return read("SELECT * FROM booking_user;", new Object[] {});
	}
	
	// Update.
	public void updateBookingUser(BookingUser bookingUser) throws SQLException, ClassNotFoundException {
		save("UPDATE booking_user SET user_id = ? WHERE booking_id = ?;",
				new Object[] {bookingUser.getUserId(), bookingUser.getBookingId()});
	}
	
	// Delete.
	public void deleteBookingUser(BookingUser bookingUser) throws SQLException, ClassNotFoundException {
		save("DELETE FROM booking_user WHERE booking_id = ?;",
				new Object[] {bookingUser.getBookingId()});
	}

	@Override
	public List<BookingUser> extractData(ResultSet rs) throws SQLException {
		List<BookingUser> bookingUserList = new ArrayList<BookingUser>();
		while(rs.next()) {
			BookingUser bookingUser = new BookingUser();
			bookingUser.setBookingId(rs.getInt("booking_id"));
			bookingUser.setUserId(rs.getInt("user_id"));
			bookingUserList.add(bookingUser);
		}
		return bookingUserList;
	}
}
