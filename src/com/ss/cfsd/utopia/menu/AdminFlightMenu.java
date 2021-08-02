package com.ss.cfsd.utopia.menu;

import com.ss.cfsd.utopia.domain.Airport;
import com.ss.cfsd.utopia.domain.Flight;
import com.ss.cfsd.utopia.service.CreateService;
import com.ss.cfsd.utopia.service.DeleteService;
import com.ss.cfsd.utopia.service.ReadService;
import com.ss.cfsd.utopia.service.UpdateService;
import com.ss.cfsd.utopia.view.AdminFlightView;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class AdminFlightMenu extends BaseMenu {

	private AdminFlightView adminFlightView = null;
	private CreateService createService = null;
	private ReadService readService = null;
	private UpdateService updateService = null;
	private DeleteService deleteService = null;

	public AdminFlightMenu() {
		adminFlightView = new AdminFlightView();
		createService = new CreateService();
		readService = new ReadService();
		updateService = new UpdateService();
		deleteService = new DeleteService();
	}
	
	public void runAdminFlightMenu() {
		String option = null;
		Integer optionNumber = null;
		
		try {
			while(true) {
				optionNumber = runMenu(adminFlightView.getHeaderMain(), adminFlightView.getHeaderMainOptions(), Boolean.TRUE);
				option = adminFlightView.getHeaderMainOptions()[optionNumber];
				
				if(adminFlightView.getOptionReturn().equals(option)) {
					return;
				} else if(adminFlightView.getOptionAdd().equals(option)) {
					runAdminCreateFlight();
				} else if(adminFlightView.getOptionUpdate().equals(option)) {
					runAdminUpdateFlight();
				} else if(adminFlightView.getOptionDelete().equals(option)) {
					runAdminDeleteFlight();
				} else if(adminFlightView.getOptionRead().equals(option)) {
					runAdminReadFlight();
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void runAdminCreateFlight() throws SQLException {
		Airport originAirport = null;
		Airport destinationAirport = null;
		LocalDate departureDate = null;
		LocalTime departureTime = null;
		Timestamp departureTimestamp = null;
		Integer optionNumber = null;
		List<Airport> airportList = null;
		String[] originOptions = null;
		String[] destinationOptions = null;
		
		airportList = readService.readAirport();
		originOptions = new String[airportList.size() + 1];
		
		for(int i = 0; i < airportList.size(); i++) {
			originOptions[i] = airportList.get(i).getIataId(); 
		}
		originOptions[airportList.size()] = adminFlightView.getOptionReturn();
	
		System.out.println(adminFlightView.getHeaderCreateFlight());
	
		// Get the origin airport.
		optionNumber = runMenu(adminFlightView.getPromptSelectOriginAirport(), originOptions, Boolean.FALSE);
		if(adminFlightView.getOptionReturn().equals(originOptions[optionNumber])) {
			System.out.println(trailingNewLine);
			return;
		}
		originAirport = airportList.get(optionNumber);
		
		airportList = readService.readAirportWhereIataIdNotEqualsIataId(originAirport.getIataId());
		destinationOptions = new String[airportList.size() + 1];
		
		for(int i = 0; i < airportList.size(); i++) {
			destinationOptions[i] = airportList.get(i).getIataId(); 
		}
		destinationOptions[airportList.size()] = adminFlightView.getOptionReturn();
		
		// Get the destination airport.
		optionNumber = runMenu(adminFlightView.getPromptSelectDestinationAirport(), destinationOptions, Boolean.FALSE);
		if(adminFlightView.getOptionReturn().equals(destinationOptions[optionNumber])) {
			System.out.println(trailingNewLine);
			return;
		}
		destinationAirport = airportList.get(optionNumber);
		
		// Get the departure date and time.
		departureDate = getDate("", adminFlightView.getPromptEnterDepartureDate(), Boolean.FALSE);
		departureTime = getTime("", adminFlightView.getPromptEnterDepartureTime(), Boolean.FALSE);
		departureTimestamp = Timestamp.valueOf(LocalDateTime.of(departureDate, departureTime));
		
		// Create the flight.
		createService.createFlight(originAirport, destinationAirport, departureTimestamp);
		
		System.out.println(adminFlightView.getAlertSuccessfulCreate());
		System.out.println(trailingNewLine);
	}
	
	public void runAdminUpdateFlight() throws SQLException {
		Flight targetFlight = null;
		LocalTime departureTime = null;
		Float seatPrice = null;
		StringBuilder spacing = new StringBuilder("  ");
		Integer optionNumber = null;
		List<Flight> flightList = readService.readFlight();
		String[] flightOptions = new String[flightList.size() + 1];
		
		System.out.println(adminFlightView.getHeaderUpdateFlight());
	
		// Get the flight options.
		for(int i = 0; i < flightList.size(); i++) {
			if(i % 9 == 0) { spacing.append(" "); }
			Flight flight = flightList.get(i);
			StringBuilder flightOption = new StringBuilder();
			flightOption.append("Origin: " + flight.getRoute().getOriginId());
			flightOption.append("\n" + spacing + "Destination: " + flight.getRoute().getDestinationId());
			flightOption.append("\n" + spacing + "Departure Date: " + flight.getDepartureTime().toLocalDateTime().toLocalDate());
			flightOption.append("\n" + spacing + "Departure Time: " + flight.getDepartureTime().toLocalDateTime().toLocalTime());
			flightOption.append("\n" + spacing + "Seat Price: $" + flight.getSeatPrice());
			flightOption.append("\n");
			flightOptions[i] = flightOption.toString();
		}
		flightOptions[flightList.size()] = adminFlightView.getOptionReturn();
		
		optionNumber = runMenu(adminFlightView.getPromptSelectFlightToUpdate(), flightOptions, Boolean.FALSE);
		if(adminFlightView.getOptionReturn().equals(flightOptions[optionNumber])) {
			System.out.println(trailingNewLine);
			return;
		}
		targetFlight = flightList.get(optionNumber);
		
		// Prompt the user for pertinent information.
		departureTime = getTimeOrNA("", adminFlightView.getPromptEnterDepartureTimeOrNA(), Boolean.FALSE);
		seatPrice = getFloatOrNA("", adminFlightView.getPromptEnterSeatPriceOrNA(), Boolean.FALSE);
		
		if(departureTime != null) {
			LocalDate localDate = targetFlight.getDepartureTime().toLocalDateTime().toLocalDate();
			LocalTime localTime = departureTime;
			LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
			targetFlight.setDepartureTime(Timestamp.valueOf(localDateTime));
		}
		
		if(seatPrice != null) { targetFlight.setSeatPrice(seatPrice); }
		
		if(departureTime == null && seatPrice == null) {
			System.out.println(trailingNewLine);
			return;
		} else {
			// Update the flight.
			updateService.updateFlight(targetFlight);
		}
		
		System.out.println(adminFlightView.getAlertSuccessfulUpdate());
		System.out.println(trailingNewLine);
	}
	
	public void runAdminDeleteFlight() throws SQLException {
		Flight targetFlight = null;
		StringBuilder spacing = new StringBuilder("  ");
		Integer optionNumber = null;
		List<Flight> flightList = readService.readFlight();
		String[] flightOptions = new String[flightList.size() + 1];
		
		System.out.println(adminFlightView.getHeaderDeleteFlight());
	
		// Get the flight options.
		for(int i = 0; i < flightList.size(); i++) {
			if(i % 9 == 0) { spacing.append(" "); }
			Flight flight = flightList.get(i);
			StringBuilder flightOption = new StringBuilder();
			flightOption.append("Origin: " + flight.getRoute().getOriginId());
			flightOption.append("\n" + spacing + "Destination: " + flight.getRoute().getDestinationId());
			flightOption.append("\n" + spacing + "Departure Date: " + flight.getDepartureTime().toLocalDateTime().toLocalDate());
			flightOption.append("\n" + spacing + "Departure Time: " + flight.getDepartureTime().toLocalDateTime().toLocalTime());
			flightOption.append("\n" + spacing + "Seat Price: $" + flight.getSeatPrice());
			flightOption.append("\n");
			flightOptions[i] = flightOption.toString();
		}
		flightOptions[flightList.size()] = adminFlightView.getOptionReturn();
		
		optionNumber = runMenu(adminFlightView.getPromptSelectFlightToDelete(), flightOptions, Boolean.FALSE);
		if(adminFlightView.getOptionReturn().equals(flightOptions[optionNumber])) {
			System.out.println(trailingNewLine);
			return;
		}
		targetFlight = flightList.get(optionNumber);
	
		// Delete the flight.
		deleteService.deleteFlight(targetFlight);
		
		System.out.println(adminFlightView.getAlertSuccessfulDelete());
		System.out.println(trailingNewLine);
	}
	
	public void runAdminReadFlight() throws SQLException {
		List<Flight> flightList = readService.readFlight();
		StringBuilder spacing = new StringBuilder("  ");
		
		System.out.println(adminFlightView.getHeaderReadFlight());
		
		for(int i = 0; i < flightList.size(); i++) {
			if(i % 9 == 0) {spacing.append(" ");}
			Flight flight = flightList.get(i);
			System.out.println((i + 1) + ") Origin: " + flight.getRoute().getOriginId());
			System.out.println(spacing + "Destination: " + flight.getRoute().getDestinationId());
			System.out.println(spacing + "Departure Date: " + flight.getDepartureTime().toLocalDateTime().toLocalDate());
			System.out.println(spacing + "Departure Time: " + flight.getDepartureTime().toLocalDateTime().toLocalTime());
			System.out.println(spacing + "Seat Price: $" + flight.getSeatPrice());
			System.out.println();
		}
		System.out.print(trailingNewLine);
	}
}












