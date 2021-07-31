package com.ss.cfsd.utopia.dao;

import com.ss.cfsd.utopia.domain.Airport;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirportDAO extends BaseDAO<Airport> {

	public AirportDAO(Connection conn) throws ClassNotFoundException, SQLException {
		super(conn);
	}
	
	// Create.
	public void createAirport(Airport airport) throws SQLException, ClassNotFoundException {
		save("INSERT INTO airport(iata_id, city) VALUES(?, ?);",
				new Object[] {airport.getIataId(), airport.getCity()});
	}

	// Read.
	public List<Airport> readAirport() throws SQLException, ClassNotFoundException {
		return read("SELECT * FROM airport;", new Object[] {});
	}
	
	// Update.
	public void updateAirport(Airport airport) throws SQLException, ClassNotFoundException {
		save("UPDATE airport SET city = ? WHERE iata_id = ?;",
				new Object[] {airport.getCity(), airport.getIataId()});
	}
	
	// Delete.
	public void deleteAirport(Airport airport) throws SQLException, ClassNotFoundException {
		save("DELETE FROM airport WHERE iata_id = ?;",
				new Object[] {airport.getIataId()});
	}

	@Override
	public List<Airport> extractData(ResultSet rs) throws SQLException {
		List<Airport> airportList = new ArrayList<Airport>();
		while(rs.next()) {
			Airport airport = new Airport();
			airport.setIataId(rs.getString("iata_id"));
			airport.setCity(rs.getString("city"));
			airportList.add(airport);
		}
		return airportList;
	}
}
