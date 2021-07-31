package com.ss.cfsd.utopia.dao;

import com.ss.cfsd.utopia.domain.Route;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteDAO extends BaseDAO<Route> {

	public RouteDAO(Connection conn) throws ClassNotFoundException, SQLException {
		super(conn);
	}
	
	// Create.
	public void createRoute(Route route) throws SQLException, ClassNotFoundException {
		save("INSERT INTO route(origin_id, destination_id) VALUES(?, ?);",
				new Object[] {route.getOriginId(), route.getDestinationId()});
	}

	// Read.
	public List<Route> readRoute() throws SQLException, ClassNotFoundException {
		return read("SELECT * FROM route;", new Object[] {});
	}
	
	public List<Route> readRouteById(Integer id) throws SQLException, ClassNotFoundException {
		return read("SELECT * FROM route WHERE id = ?;", new Object[] {id});
	}
	
	// Update.
	public void updateRoute(Route route) throws SQLException, ClassNotFoundException {
		save("UPDATE route SET origin_id = ?, destination_id = ? WHERE id = ?;",
				new Object[] {route.getOriginId(), route.getDestinationId(), route.getId()});
	}
	
	// Delete.
	public void deleteRoute(Route route) throws SQLException, ClassNotFoundException {
		save("DELETE FROM route WHERE id = ?;",
				new Object[] {route.getId()});
	}

	@Override
	public List<Route> extractData(ResultSet rs) throws SQLException {
		List<Route> routeList = new ArrayList<Route>();
		while(rs.next()) {
			Route route = new Route();
			route.setId(rs.getInt("id"));
			route.setOriginId(rs.getString("origin_id"));
			route.setDestinationId(rs.getString("destination_id"));
			routeList.add(route);
		}
		return routeList;
	}
}
