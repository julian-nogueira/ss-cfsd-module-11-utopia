package com.ss.cfsd.utopia.menu;

import com.ss.cfsd.utopia.domain.Airport;
import com.ss.cfsd.utopia.domain.Booking;
import com.ss.cfsd.utopia.domain.Flight;
import com.ss.cfsd.utopia.domain.User;
import com.ss.cfsd.utopia.service.CreateService;
import com.ss.cfsd.utopia.service.ReadService;
import com.ss.cfsd.utopia.service.UpdateService;
import com.ss.cfsd.utopia.view.TravelerView;

import java.sql.SQLException;
import java.util.List;

public class TravelerMenu extends BaseMenu {

	TravelerView travelerView = null;
	CreateService createService = null;
	ReadService readService = null;
	UpdateService updateService = null;
	
	public TravelerMenu() {
		travelerView = new TravelerView();
		createService = new CreateService();
		readService = new ReadService();
		updateService = new UpdateService();
	}
	
	public void runTravelerAuthenticate() {
		User traveler = null;
		Integer membershipNumber = null;
		Boolean validTraveler = Boolean.FALSE;
		List<User> userList = null;
		
		try {
			membershipNumber = getInteger(travelerView.getHeaderAuthenticate(), travelerView.getPromptEnterMembershipNumber(), Boolean.FALSE);
			
			userList = readService.readTraveler();
			for(User user: userList) {
				if(user.getId() == membershipNumber) {
					traveler = user;
					validTraveler = Boolean.TRUE;
					break;
				}
			}
			
			if(validTraveler) {
				System.out.println(travelerView.getAlertValidMembershipNumber());
				System.out.println(trailingNewLine);
				runTravelerMenu(traveler);
			} else {
				System.out.println(travelerView.getAlertInvalidMembershipNumber());
				System.out.println(trailingNewLine);
				return;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void runTravelerMenu(User traveler) {
		String option = null;
		Integer optionNumber = null;
		
		try {
			while(true) {
				optionNumber = runMenu(travelerView.getHeaderMain(), travelerView.getHeaderMainOptions(), Boolean.TRUE);
				option = travelerView.getHeaderMainOptions()[optionNumber];
				
				if(travelerView.getOptionReturn().equals(option)) {
					return;
				} else if(travelerView.getOptionBookAFlight().equals(option)) {
					runTravelerBookFlight(traveler);
				} else if(travelerView.getOptionCancelAFlight().equals(option)) {
					runTravelerCancelFlight(traveler);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void runTravelerBookFlight(User traveler) throws SQLException {
		Flight targetFlight = null;
		String option = null;
		Integer optionNumber = null;
		List<Flight> flightList = readService.readFlight();
		String[] flightOptions = new String[flightList.size() + 1];
		
		System.out.println(travelerView.getHeaderBookFlight());
	
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
		flightOptions[flightList.size()] = travelerView.getOptionReturn();
		
		optionNumber = runMenu(travelerView.getPromptSelectAFlightToBook(), flightOptions, Boolean.FALSE);
		option = flightOptions[optionNumber];
		
		if(travelerView.getOptionReturn().equals(option)) {
			System.out.println(trailingNewLine);
			return;
		} else {
			targetFlight = flightList.get(optionNumber);
			try {
				createService.createBookingFromTraveler(targetFlight, traveler);
				System.out.println(travelerView.getAlertSuccessfulBooking());
				System.out.println(trailingNewLine);
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println(trailingNewLine);
			}
		}
	}
	
	public void runTravelerCancelFlight(User traveler) throws SQLException {
		Booking targetBooking = null;
		String option = null;
		Integer optionNumber = null;
		List<Booking> bookingList = readService.readBookingByTravelerIdWhereIsActiveEqualsTrue(traveler);
		String[] flightOptions = new String[bookingList.size() + 1];
		
		System.out.println(travelerView.getHeaderCancelFlight());
		
		// Get the flight options.
		for(int i = 0; i < bookingList.size(); i ++) {
			StringBuilder flightOption = new StringBuilder();
			Flight flight = readService.readFlightByBookingId(bookingList.get(i)).get(0);
			Airport originAirport = readService.readAirportByIataId(flight.getRoute().getOriginId()).get(0);
			Airport destinationAirport = readService.readAirportByIataId(flight.getRoute().getDestinationId()).get(0);
			flightOption.append(originAirport.getIataId() + ", " + originAirport.getCity());
			flightOption.append(" -> ");
			flightOption.append(destinationAirport.getIataId() + ", " + destinationAirport.getCity());
			flightOptions[i] = flightOption.toString();
		}
		
		flightOptions[bookingList.size()] = travelerView.getOptionReturn();
		
		optionNumber = runMenu(travelerView.getPromptSelectAFlightToCancel(), flightOptions, Boolean.FALSE);
		option = flightOptions[optionNumber];
		
		if(travelerView.getOptionReturn().equals(option)) {
			System.out.println(trailingNewLine);
			return;
		} else {
			targetBooking = bookingList.get(optionNumber);
			try {
				updateService.updateBookingCancellation(targetBooking);
				System.out.println(travelerView.getAlertSuccessfulCancellation());
				System.out.println(trailingNewLine);
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println(trailingNewLine);
			}
		}
	}
}












