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
import java.sql.Timestamp;
import java.util.List;

public class AdminCreateService {

	Util util = null;
	
	public AdminCreateService() {
		util = new Util();
	}

	public void createFlight(Airport originAirport, Airport destinationAirport, Timestamp departureTimestamp) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			FlightDAO flightDAO = new FlightDAO(conn);
			RouteDAO routeDAO = new RouteDAO(conn);
			Flight flight = new Flight();
			Route route = null;
			Integer routePrimaryKey = null;
			List<Route> routeList = null;
			
			flight.setDepartureTime(departureTimestamp);
		
			// Default settings. Change this in the future to be more dynamic.
			flight.setAirplaneId(1);
			flight.setReservedSeats(0);
			flight.setSeatPrice(120.0f);
			
			routeList = routeDAO.readRouteByOriginIdAndDestinationId(originAirport.getIataId(), destinationAirport.getIataId());
			
			if(routeList.size() == 0) {
				// Create route.
				route = new Route();
				route.setOriginId(originAirport);
				route.setDestinationId(destinationAirport);
				routePrimaryKey = routeDAO.createRouteReturnPrimaryKey(route);
				flight.setRouteId(routePrimaryKey);
			} else {
				// Use route.
				route = routeList.get(0);
				flight.setRouteId(route);
			}
			
			flightDAO.createFlight(flight);
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
	
	public void createRoute(Route route) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			RouteDAO routeDAO = new RouteDAO(conn);
			routeDAO.createRoute(route);
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
	
	public void createPassenger(Passenger passenger) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			PassengerDAO passengerDAO = new PassengerDAO(conn);
			passengerDAO.createPassenger(passenger);
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
	
	public void createAirport(Airport airport) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			AirportDAO airportDAO = new AirportDAO(conn);
			airportDAO.createAirport(airport);
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
	
	public void createUserWhereRoleIdEqualsTravelerId(User user) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			UserDAO userDAO = new UserDAO(conn);
			userDAO.createUserWhereRoleIdEqualsTravelerId(user);
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
	
	public void createUserWhereRoleIdEqualsEmployeeId(User user) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			UserDAO userDAO = new UserDAO(conn);
			userDAO.createUserWhereRoleIdEqualsEmployeeId(user);
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
