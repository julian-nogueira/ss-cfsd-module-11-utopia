package com.ss.cfsd.utopia.dao;

import com.ss.cfsd.utopia.domain.Airplane;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirplaneDAO extends BaseDAO<Airplane> {

	public AirplaneDAO(Connection conn) throws ClassNotFoundException, SQLException {
		super(conn);
	}
	
	// Create.
	public void createAirplane(Airplane airplane) throws SQLException, ClassNotFoundException {
		save("INSERT INTO airplane(type_id) VALUES(?);",
				new Object[] {airplane.getTypeId()});
	}

	// Read.
	public List<Airplane> readAirplane() throws SQLException, ClassNotFoundException {
		return read("SELECT * FROM airplane;", new Object[] {});
	}
	
	// Update.
	public void updateAirplane(Airplane airplane) throws SQLException, ClassNotFoundException {
		save("UPDATE airplane SET type_id = ? WHERE id = ?;",
				new Object[] {airplane.getTypeId(), airplane.getId()});
	}
	
	// Delete.
	public void deleteAirplane(Airplane airplane) throws SQLException, ClassNotFoundException {
		save("DELETE FROM airplane WHERE id = ?;",
				new Object[] {airplane.getId()});
	}

	@Override
	public List<Airplane> extractData(ResultSet rs) throws SQLException {
		List<Airplane> airplaneList = new ArrayList<Airplane>();
		while(rs.next()) {
			Airplane airplane = new Airplane();
			airplane.setId(rs.getInt("id"));
			airplane.setTypeId(rs.getInt("type_id"));
			airplaneList.add(airplane);
		}
		return airplaneList;
	}
}
