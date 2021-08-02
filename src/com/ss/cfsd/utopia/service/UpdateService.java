package com.ss.cfsd.utopia.service;

import com.ss.cfsd.utopia.dao.AirportDAO;
import com.ss.cfsd.utopia.dao.FlightDAO;
import com.ss.cfsd.utopia.dao.PassengerDAO;
import com.ss.cfsd.utopia.dao.RouteDAO;
import com.ss.cfsd.utopia.dao.UserDAO;
import com.ss.cfsd.utopia.domain.Airport;
import com.ss.cfsd.utopia.domain.Flight;
import com.ss.cfsd.utopia.domain.Passenger;
import com.ss.cfsd.utopia.domain.Route;
import com.ss.cfsd.utopia.domain.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UpdateService {
	
	Util util = null;
	
	public UpdateService() {
		util = new Util();
	}

	public void updateFlight(Flight flight) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			FlightDAO flightDAO = new FlightDAO(conn);
			flightDAO.updateFlight(flight);
			conn.commit();
			return;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	public void updateFlight(Flight flight, String originAirportIataId, String destinationAirportIataId) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			FlightDAO flightDAO = new FlightDAO(conn);
			RouteDAO routeDAO = new RouteDAO(conn);
			Route route = null;
			Integer routePrimaryKey = null;
			List<Route> routeList = null;
			
			routeList = routeDAO.readRouteByOriginIdAndDestinationId(originAirportIataId, destinationAirportIataId);
			
			if(routeList.size() == 0) {
				// Create route.
				route = new Route();
				route.setOriginId(originAirportIataId);
				route.setDestinationId(destinationAirportIataId);
				routePrimaryKey = routeDAO.createRouteReturnPrimaryKey(route);
				route.setId(routePrimaryKey);
				flight.setRouteId(routePrimaryKey);
				flight.setRoute(route);
			} else {
				// Use route.
				route = routeList.get(0);
				flight.setRouteId(route);
				flight.setRoute(route);
			}
			
			flightDAO.updateFlight(flight);
			conn.commit();
		} catch(Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	public void updatePassenger(Passenger passenger) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			PassengerDAO passengerDAO = new PassengerDAO(conn);
			passengerDAO.updatePassenger(passenger);
			conn.commit();
			return;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	public void updateAirport(Airport airport) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			AirportDAO airportDAO = new AirportDAO(conn);
			airportDAO.updateAirport(airport);
			conn.commit();
			return;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	public void updateUser(User user) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			UserDAO userDAO = new UserDAO(conn);
			userDAO.updateUser(user);
			conn.commit();
			return;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
}
