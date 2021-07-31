package com.ss.cfsd.utopia.dao;

import com.ss.cfsd.utopia.domain.BookingAgent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingAgentDAO extends BaseDAO<BookingAgent> {

	public BookingAgentDAO(Connection conn) throws ClassNotFoundException, SQLException {
		super(conn);
	}
	
	// Create.
	public void createBookingAgent(BookingAgent bookingAgent) throws SQLException, ClassNotFoundException {
		save("INSERT INTO booking_agent(booking_id, agent_id) VALUES(?, ?);",
				new Object[] {bookingAgent.getBookingId(), bookingAgent.getAgentId()});
	}

	// Read.
	public List<BookingAgent> readBookingAgent() throws SQLException, ClassNotFoundException {
		return read("SELECT * FROM booking_agent;", new Object[] {});
	}
	
	// Update.
	public void updateBookingAgent(BookingAgent bookingAgent) throws SQLException, ClassNotFoundException {
		save("UPDATE booking_agent SET agent_id = ? WHERE booking_id = ?;",
				new Object[] {bookingAgent.getAgentId(), bookingAgent.getBookingId()});
	}
	
	// Delete.
	public void deleteBookingAgent(BookingAgent bookingAgent) throws SQLException, ClassNotFoundException {
		save("DELETE FROM booking_agent WHERE booking_id = ?;",
				new Object[] {bookingAgent.getBookingId()});
	}

	@Override
	public List<BookingAgent> extractData(ResultSet rs) throws SQLException {
		List<BookingAgent> bookingAgentList = new ArrayList<BookingAgent>();
		while(rs.next()) {
			BookingAgent bookingAgent = new BookingAgent();
			bookingAgent.setBookingId(rs.getInt("booking_id"));
			bookingAgent.setAgentId(rs.getInt("agent_id"));
			bookingAgentList.add(bookingAgent);
		}
		return bookingAgentList;
	}
}
