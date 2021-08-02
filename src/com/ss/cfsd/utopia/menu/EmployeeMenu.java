package com.ss.cfsd.utopia.menu;

import com.ss.cfsd.utopia.domain.Airport;
import com.ss.cfsd.utopia.domain.Flight;
import com.ss.cfsd.utopia.service.ReadService;
import com.ss.cfsd.utopia.service.UpdateService;
import com.ss.cfsd.utopia.view.EmployeeView;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class EmployeeMenu extends BaseMenu {

	private EmployeeView employeeView = null;
	private ReadService readService = null;
	private UpdateService updateService = null;
	
	public EmployeeMenu() {
		employeeView = new EmployeeView();
		readService = new ReadService();
		updateService = new UpdateService();
	}
	
	public void runEmployeeMenu() {
		String option = null;
		Integer optionNumber = null;
		
		try {
			while(true) {
				optionNumber = runMenu(employeeView.getHeaderMain(), employeeView.getHeaderMainOptions(), Boolean.TRUE);
				option = employeeView.getHeaderMainOptions()[optionNumber];
				
				if(employeeView.getOptionReturn().equals(option)) {
					return;
				} else if(employeeView.getOptionManageFlights().equals(option)) {
					runEmployeeManageFlightsMenu();
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void runEmployeeManageFlightsMenu() throws SQLException {
		String option = null;
		Integer optionNumber = null;
		List<Flight> flightList = readService.readFlight();
		String[] flightOptions = new String[flightList.size() + 1];
		
		try {
			while(true) {
				System.out.println(employeeView.getHeaderManageFlights());
				
				// Get the flight options.
				for(int i = 0; i < flightList.size(); i++) {
					Flight flight = flightList.get(i);
					Airport originAirport = readService.readAirportByIataId(flight.getRoute().getOriginId()).get(0);
					Airport destinationAirport = readService.readAirportByIataId(flight.getRoute().getDestinationId()).get(0);
					StringBuilder flightOption = new StringBuilder();
					flightOption.append(originAirport.getIataId() + ", " + originAirport.getCity());
					flightOption.append(" -> ");
					flightOption.append(destinationAirport.getIataId() + ", " + destinationAirport.getCity());
					flightOptions[i] = flightOption.toString();
				}
				flightOptions[flightList.size()] = employeeView.getOptionReturn();
	
				optionNumber = runMenu(employeeView.getPromptSelectAFlight(), flightOptions, Boolean.TRUE);
				option = flightOptions[optionNumber];
				
				if(employeeView.getOptionReturn().equals(option)) {
					return;
				} else {
					runEmployeeManageFlightsSubMenu(flightList.get(optionNumber));
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void runEmployeeManageFlightsSubMenu(Flight flight) throws SQLException {
		String option = null;
		Integer optionNumber = null;
		
		try {
			while(true) {
				optionNumber = runMenu(employeeView.getHeaderManageFlights(), employeeView.getHeaderManageFlightsOptions(), Boolean.TRUE);
				option = employeeView.getHeaderManageFlightsOptions()[optionNumber];
				
				if(employeeView.getOptionReturn().equals(option)) {
					return;
				} else if(employeeView.getOptionViewDetails().equals(option)) {
					runEmployeeViewDetails(flight);
				} else if(employeeView.getOptionUpdateDetails().equals(option)) {
					runEmployeeUpdateDetails(flight);
				} else if(employeeView.getOptionAddSeats().equals(option)) {
					//
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void runEmployeeViewDetails(Flight flight) throws SQLException {
		StringBuilder details = new StringBuilder();
		Airport originAirport = readService.readAirportByIataId(flight.getRoute().getOriginId()).get(0);
		Airport destinationAirport = readService.readAirportByIataId(flight.getRoute().getDestinationId()).get(0);

		details.append("Origin: " + originAirport.getIataId() + ", " + originAirport.getCity());
		details.append("\nDestination: " + destinationAirport.getIataId() + ", " + destinationAirport.getCity());
		details.append("\nDeparture Date: " + flight.getDepartureTime().toLocalDateTime().toLocalDate());
		details.append("\nDeparture Time: " + flight.getDepartureTime().toLocalDateTime().toLocalTime());
	
		System.out.println(employeeView.getHeaderViewFlightDetails());
		System.out.println(details);
		System.out.println(trailingNewLine);
	}
	
	public void runEmployeeUpdateDetails(Flight flight) throws SQLException {
		LocalDateTime departureDateTimeGetDate = null;
		LocalDateTime departureDateTimeGetTime = null;
		String originAirportIataId = null;
		String destinationAirportIataId = null;
		String departureDateString = null;
		String departureTimeString = null;
		Integer optionNumber = null;
		List<Airport> airportList = readService.readAirport();
		String[] originOptions = new String[airportList.size() + 2];
		String[] destinationOptions = null;
		
		System.out.println(employeeView.getHeaderUpdateFlightDetails());
		System.out.print("Updating Flight #" + flight.getId() + ": ");
		System.out.print(flight.getRoute().getOriginId() + " -> ");
		System.out.print(flight.getRoute().getDestinationId());
		System.out.println();
		System.out.println(promptQuit);
		
		for(int i = 0; i < airportList.size(); i++) {
			originOptions[i] = airportList.get(i).getIataId(); 
		}
		originOptions[airportList.size()] = employeeView.getOptionNA();
		originOptions[airportList.size() + 1] = employeeView.getOptionQuitOperation();
	
		// Get the origin airport.
		optionNumber = runMenu(employeeView.getPromptSelectOriginAirport(), originOptions, Boolean.FALSE);
		if(employeeView.getOptionQuitOperation().equals(originOptions[optionNumber])) {
			System.out.println(trailingNewLine);
			return;
		} else if(employeeView.getOptionNA().equals(originOptions[optionNumber])) {
			originAirportIataId = null;
		} else {
			originAirportIataId = airportList.get(optionNumber).getIataId();
		}
	
		if(originAirportIataId == null) {
			airportList = readService.readAirportWhereIataIdNotEqualsIataId(flight.getRoute().getOriginId());
		} else {
			airportList = readService.readAirportWhereIataIdNotEqualsIataId(originAirportIataId);
		}
		destinationOptions = new String[airportList.size() + 2];
		
		for(int i = 0; i < airportList.size(); i++) {
			destinationOptions[i] = airportList.get(i).getIataId(); 
		}
		destinationOptions[airportList.size()] = employeeView.getOptionNA();
		destinationOptions[airportList.size() + 1] = employeeView.getOptionQuitOperation();
		
		// Get the destination airport.
		optionNumber = runMenu(employeeView.getPromptSelectDestinationAirport(), destinationOptions, Boolean.FALSE);
		if(employeeView.getOptionQuitOperation().equals(destinationOptions[optionNumber])) {
			System.out.println(trailingNewLine);
			return;
		} else if(employeeView.getOptionNA().equals(destinationOptions[optionNumber])) {
			destinationAirportIataId = null;
		} else {
			destinationAirportIataId = airportList.get(optionNumber).getIataId();
		}
	
		// Get the departure date.
		departureDateString = getDateOrNAOrQuit("", employeeView.getPromptEnterDepartureDateOrNAOrQuit(), Boolean.FALSE);
		if(optionNA.equals(departureDateString.toUpperCase())) {
			departureDateTimeGetDate = null;
		} else if(optionQuit.toUpperCase().equals(departureDateString.toUpperCase())) {
			System.out.println(trailingNewLine);
			return;
		} else {
			LocalDate localDate = LocalDate.parse(departureDateString);
			LocalTime localTime = flight.getDepartureTime().toLocalDateTime().toLocalTime();
			departureDateTimeGetDate = LocalDateTime.of(localDate, localTime);
		}
		
		// Get the departure time.
		departureTimeString = getTimeOrNAOrQuit("", employeeView.getPromptEnterDepartureTimeOrNAOrQuit(), Boolean.FALSE);
		if(optionNA.equals(departureTimeString.toUpperCase())) {
			departureDateTimeGetTime = null;
		} else if(optionQuit.toUpperCase().equals(departureTimeString.toUpperCase())) {
			System.out.println(trailingNewLine);
			return;
		} else {
			LocalDate localDate = null;
			if(departureDateTimeGetDate == null) {
				localDate = flight.getDepartureTime().toLocalDateTime().toLocalDate();
			} else {
				localDate = departureDateTimeGetDate.toLocalDate();
			}
			LocalTime localTime = LocalTime.parse(departureTimeString);
			departureDateTimeGetTime = LocalDateTime.of(localDate, localTime);
		}
		
		if(originAirportIataId == null && destinationAirportIataId == null && departureDateTimeGetDate == null && departureDateTimeGetTime == null) {
			System.out.println(trailingNewLine);
			return;
		} else {
			// Update the flight.
			if(originAirportIataId != null) { flight.getRoute().setOriginId(originAirportIataId); }
			if(destinationAirportIataId != null) { flight.getRoute().setDestinationId(destinationAirportIataId); }
			if(departureDateTimeGetDate != null) { flight.setDepartureTime(Timestamp.valueOf(departureDateTimeGetDate)); }
			if(departureDateTimeGetTime != null) { flight.setDepartureTime(Timestamp.valueOf(departureDateTimeGetTime)); }
			updateService.updateFlight(flight, flight.getRoute().getOriginId(), flight.getRoute().getDestinationId());
			System.out.println(employeeView.getAlertSuccessfulUpdate());
			System.out.println(trailingNewLine);
		}
	}
}














