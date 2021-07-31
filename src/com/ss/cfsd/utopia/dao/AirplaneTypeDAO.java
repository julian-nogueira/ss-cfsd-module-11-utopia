package com.ss.cfsd.utopia.dao;

import com.ss.cfsd.utopia.domain.AirplaneType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirplaneTypeDAO extends BaseDAO<AirplaneType> {

	public AirplaneTypeDAO(Connection conn) throws ClassNotFoundException, SQLException {
		super(conn);
	}
	
	// Create.
	public void createAirplaneType(AirplaneType airplaneType) throws SQLException, ClassNotFoundException {
		save("INSERT INTO airplane_type(max_capacity) VALUES(?);",
				new Object[] {airplaneType.getMaxCapacity()});
	}

	// Read.
	public List<AirplaneType> readAirplaneType() throws SQLException, ClassNotFoundException {
		return read("SELECT * FROM airplane_type;", new Object[] {});
	}
	
	// Update.
	public void updateAirplaneType(AirplaneType airplaneType) throws SQLException, ClassNotFoundException {
		save("UPDATE airplane_type SET max_capacity = ? WHERE id = ?;",
				new Object[] {airplaneType.getMaxCapacity(), airplaneType.getId()});
	}
	
	// Delete.
	public void deleteAirplaneType(AirplaneType airplaneType) throws SQLException, ClassNotFoundException {
		save("DELETE FROM airplane_type WHERE id = ?;",
				new Object[] {airplaneType.getId()});
	}

	@Override
	public List<AirplaneType> extractData(ResultSet rs) throws SQLException {
		List<AirplaneType> airplaneTypeList = new ArrayList<AirplaneType>();
		while(rs.next()) {
			AirplaneType airplaneType = new AirplaneType();
			airplaneType.setId(rs.getInt("id"));
			airplaneType.setMaxCapacity(rs.getInt("max_capacity"));
			airplaneTypeList.add(airplaneType);
		}
		return airplaneTypeList;
	}
}
