package com.ss.cfsd.utopia.dao;

import com.ss.cfsd.utopia.domain.Passenger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassengerDAO extends BaseDAO<Passenger> {

	public PassengerDAO(Connection conn) throws ClassNotFoundException, SQLException {
		super(conn);
	}
	
	// Create.
	public void createPassenger(Passenger passenger) throws SQLException, ClassNotFoundException {
		save("INSERT INTO passenger(booking_id, given_name, family_name, dob, gender, address) VALUES(?, ?, ?, ?, ?, ?);",
				new Object[] {passenger.getBookingId(), passenger.getGivenName(), passenger.getFamilyName(),
						passenger.getDob(), passenger.getGender(), passenger.getAddress()});
	}

	// Read.
	public List<Passenger> readPassenger() throws SQLException, ClassNotFoundException {
		return read("SELECT * FROM passenger;", new Object[] {});
	}
	
	// Update.
	public void updatePassenger(Passenger passenger) throws SQLException, ClassNotFoundException {
		save("UPDATE passenger SET booking_id = ?, given_name = ?, family_name = ?, dob = ?, gender = ?, address = ? WHERE id = ?",
				new Object[] {passenger.getBookingId(), passenger.getGivenName(), passenger.getFamilyName(),
						passenger.getDob(), passenger.getGender(), passenger.getAddress(), passenger.getId()});
	}
	
	// Delete.
	public void deletePassenger(Passenger passenger) throws SQLException, ClassNotFoundException {
		save("DELETE FROM passenger WHERE id = ?;",
				new Object[] {passenger.getId()});
	}

	@Override
	public List<Passenger> extractData(ResultSet rs) throws SQLException {
		List<Passenger> passengerList = new ArrayList<Passenger>();
		while(rs.next()) {
			Passenger passenger = new Passenger();
			passenger.setId(rs.getInt("id"));
			passenger.setBookingId(rs.getInt("booking_id"));
			passenger.setGivenName(rs.getString("given_name"));
			passenger.setFamilyName(rs.getString("family_name"));
			passenger.setDob(rs.getDate("dob"));
			passenger.setGender(rs.getString("gender"));
			passenger.setAddress(rs.getString("address"));
			passengerList.add(passenger);
		}
		return passengerList;
	}
}
