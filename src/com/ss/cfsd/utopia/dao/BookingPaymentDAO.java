package com.ss.cfsd.utopia.dao;

import com.ss.cfsd.utopia.domain.BookingPayment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingPaymentDAO extends BaseDAO<BookingPayment> {

	public BookingPaymentDAO(Connection conn) throws ClassNotFoundException, SQLException {
		super(conn);
	}
	
	// Create.
	public void createBookingPayment(BookingPayment bookingPayment) throws SQLException, ClassNotFoundException {
		save("INSERT INTO booking_payment(booking_id, stripe_id, refunded) VALUES(?, ?, ?);",
				new Object[] {bookingPayment.getBookingId(), bookingPayment.getStripeId(), bookingPayment.getRefunded()});
	}

	// Read.
	public List<BookingPayment> readBookingPayment() throws SQLException, ClassNotFoundException {
		return read("SELECT * FROM booking_payment;", new Object[] {});
	}
	
	// Update.
	public void updateBookingPayment(BookingPayment bookingPayment) throws SQLException, ClassNotFoundException {
		save("UPDATE booking_payment SET stripe_id = ?, refunded = ? WHERE booking_id = ?;",
				new Object[] {bookingPayment.getStripeId(), bookingPayment.getRefunded(), bookingPayment.getBookingId()});
	}
	
	// Delete.
	public void deleteBookingPayment(BookingPayment bookingPayment) throws SQLException, ClassNotFoundException {
		save("DELETE FROM booking_payment WHERE booking_id = ?;",
				new Object[] {bookingPayment.getBookingId()});
	}

	@Override
	public List<BookingPayment> extractData(ResultSet rs) throws SQLException {
		List<BookingPayment> bookingPaymentList = new ArrayList<BookingPayment>();
		while(rs.next()) {
			BookingPayment bookingPayment = new BookingPayment();
			bookingPayment.setBookingId(rs.getInt("booking_id"));
			bookingPayment.setStripeId(rs.getString("stripe_id"));
			bookingPayment.setRefunded(rs.getBoolean("refunded"));
			bookingPaymentList.add(bookingPayment);
		}
		return bookingPaymentList;
	}
}
