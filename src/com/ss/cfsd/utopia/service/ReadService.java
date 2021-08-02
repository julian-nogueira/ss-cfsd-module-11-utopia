package com.ss.cfsd.utopia.service;

import com.ss.cfsd.utopia.dao.AirportDAO;
import com.ss.cfsd.utopia.dao.BookingDAO;
import com.ss.cfsd.utopia.dao.FlightBookingsDAO;
import com.ss.cfsd.utopia.dao.FlightDAO;
import com.ss.cfsd.utopia.dao.PassengerDAO;
import com.ss.cfsd.utopia.dao.RouteDAO;
import com.ss.cfsd.utopia.dao.UserDAO;
import com.ss.cfsd.utopia.domain.Airport;
import com.ss.cfsd.utopia.domain.Booking;
import com.ss.cfsd.utopia.domain.Flight;
import com.ss.cfsd.utopia.domain.FlightBookings;
import com.ss.cfsd.utopia.domain.Passenger;
import com.ss.cfsd.utopia.domain.Route;
import com.ss.cfsd.utopia.domain.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ReadService {

	Util util = null;
	
	public ReadService() {
		util = new Util();
	}
	
	public List<Flight> readFlight() throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			FlightDAO flightDAO = new FlightDAO(conn);
			List<Flight> flightList = flightDAO.readFlight();
			
			// Add route to each flight.
			for(Flight flight: flightList) {
				flight.setRoute(readRouteById(flight.getRouteId()));
			}
			
			return flightList;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	public List<Flight> readFlightByBookingId(Booking booking) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			FlightDAO flightDAO = new FlightDAO(conn);
			List<Flight> flightList = flightDAO.readFlightByBookingId(booking.getId());
			
			// Add route to each flight.
			for(Flight flight: flightList) {
				flight.setRoute(readRouteById(flight.getRouteId()));
			}
			
			return flightList;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	public List<Flight> readFlightByUserId(User user) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			FlightDAO flightDAO = new FlightDAO(conn);
			FlightBookingsDAO flightBookingsDAO = new FlightBookingsDAO(conn);
			List<Flight> flightList = flightDAO.readFlightByUserId(user.getId());
			List<FlightBookings> flightBookings = null; 
			
			// Add route to each flight.
			for(Flight flight: flightList) {
				flightBookings = flightBookingsDAO.readFlightBookingsByUserIdAndFlightId(user.getId(), flight.getId());
				flight.setRoute(readRouteById(flight.getRouteId()));
				flight.setFlightBookings(flightBookings);
			}
			
			return flightList;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	public List<Passenger> readPassenger() throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			PassengerDAO passengerDAO = new PassengerDAO(conn);
			List<Passenger> passengerList = passengerDAO.readPassenger();
			return passengerList;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	public List<Airport> readAirport() throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			AirportDAO airportDAO = new AirportDAO(conn);
			List<Airport> airportList = airportDAO.readAirport();
			return airportList;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	public List<Airport> readAirportByIataId(String iataId) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			AirportDAO airportDAO = new AirportDAO(conn);
			List<Airport> airportList = airportDAO.readAirportByIataId(iataId);
			return airportList;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	public List<Airport> readAirportWhereIataIdNotEqualsIataId(String iataId) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			AirportDAO airportDAO = new AirportDAO(conn);
			List<Airport> airportList = airportDAO.readAirportWhereIataIdNotEqualsIataId(iataId);
			return airportList;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	public List<User> readTraveler() throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			UserDAO userDAO = new UserDAO(conn);
			List<User> userList = userDAO.readUserWhereRoleIdEqualsTravelerId();
			return userList;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	public List<User> readEmployee() throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			UserDAO userDAO = new UserDAO(conn);
			List<User> userList = userDAO.readUserWhereRoleIdEqualsEmployeeId();
			return userList;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	public Route readRouteById(Integer id) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			RouteDAO routeDAO = new RouteDAO(conn);
			List<Route> routeList = routeDAO.readRouteById(id);
			return routeList.get(0);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	public List<Booking> readBookingByTravelerIdWhereIsActiveEqualsTrue(User traveler) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			BookingDAO bookingDAO = new BookingDAO(conn);
			FlightBookingsDAO flightBookingsDAO = new FlightBookingsDAO(conn);
			List<FlightBookings> flightBookingsList = null;
			
			// Get bookings by user id.
			List<Booking> bookingList = bookingDAO.readBookingByUserIdWhereIsActiveEqualsTrue(traveler.getId());
		
			// Add flight bookings to bookings.
			for(Booking booking: bookingList) {
				flightBookingsList = flightBookingsDAO.readFlightBookingsByBookingId(booking.getId());
				booking.setFlightBookings(flightBookingsList);
			}
			
			return bookingList;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	public List<Booking> readBookingWhereIsActiveEqualsTrue() throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			BookingDAO bookingDAO = new BookingDAO(conn);
			List<Booking> bookingList = bookingDAO.readBookingWhereIsActiveEqualsTrue();
			return bookingList;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
}
