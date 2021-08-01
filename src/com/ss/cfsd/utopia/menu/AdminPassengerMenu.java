package com.ss.cfsd.utopia.menu;

import com.ss.cfsd.utopia.domain.Booking;
import com.ss.cfsd.utopia.domain.Passenger;
import com.ss.cfsd.utopia.service.AdminCreateService;
import com.ss.cfsd.utopia.service.AdminDeleteService;
import com.ss.cfsd.utopia.service.AdminReadService;
import com.ss.cfsd.utopia.view.AdminPassengerView;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class AdminPassengerMenu extends BaseMenu {

	private AdminPassengerView adminPassengerView = null;
	private AdminCreateService adminCreateService = null;
	private AdminDeleteService adminDeleteService = null;
	private AdminReadService adminReadService = null;
	
	public AdminPassengerMenu() {
		adminPassengerView = new AdminPassengerView();
		adminCreateService = new AdminCreateService();
		adminDeleteService = new AdminDeleteService();
		adminReadService = new AdminReadService();
	}
	
	public void runAdminPassengerMenu() {
		String option = null;
		Integer optionNumber = null;
		
		try {
			while(true) {
				optionNumber = runMenu(adminPassengerView.getHeaderMain(), adminPassengerView.getHeaderMainOptions(), Boolean.TRUE);
				option = adminPassengerView.getHeaderMainOptions()[optionNumber];
				
				if(adminPassengerView.getOptionReturn().equals(option)) {
					return;
				} else if(adminPassengerView.getOptionAdd().equals(option)) {
					runAdminCreatePassenger();
				} else if(adminPassengerView.getOptionUpdate().equals(option)) {
					//
				} else if(adminPassengerView.getOptionDelete().equals(option)) {
					runAdminDeletePassenger();
				} else if(adminPassengerView.getOptionRead().equals(option)) {
					runAdminReadPassenger();
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void runAdminCreatePassenger() throws SQLException {
		Passenger passenger = null;
		Booking booking = null;
		LocalDate dateOfBirth = null;
		String givenName = null;
		String familyName = null;
		String gender = null;
		String address = null;
		Integer optionNumber = null;
		List<Booking> bookingList = null;
		String[] bookingOptions = null;
	
		// Get a list of active bookings.
		bookingList = adminReadService.readBookingWhereIsActiveEqualsTrue();
		bookingOptions = new String[bookingList.size() + 1];
		
		for(int i = 0; i < bookingList.size(); i++) {
			bookingOptions[i] = bookingList.get(i).getId().toString() + ", " + bookingList.get(i).getConfirmationCode(); 
		}
		bookingOptions[bookingList.size()] = adminPassengerView.getOptionReturn();
	
		System.out.println(adminPassengerView.getHeaderCreatePassenger());

		// Get the booking from the user.
		optionNumber = runMenu(adminPassengerView.getPromptSelectBookingId(), bookingOptions, Boolean.FALSE);
		if(adminPassengerView.getOptionReturn().equals(bookingOptions[optionNumber])) {
			System.out.println(trailingNewLine);
			return;
		}
		booking = bookingList.get(optionNumber);
		
		// Get pertinent data from user.
		givenName = getData("", adminPassengerView.getPromptEnterGivenName());
		familyName = getData("", adminPassengerView.getPromptEnterFamilyName());
		dateOfBirth = getDate("", adminPassengerView.getPromptEnterDateOfBirth(), Boolean.FALSE);
		gender = getData("", adminPassengerView.getPromptEnterGender());
		address = getData("", adminPassengerView.getPromptEnterAddress());
	
		// Create the passenger object.
		passenger = new Passenger();
		passenger.setBookingId(booking);
		passenger.setGivenName(givenName);
		passenger.setFamilyName(familyName);
		passenger.setDob(Date.valueOf(dateOfBirth));
		passenger.setGender(gender);
		passenger.setAddress(address);
		
		// Create the passenger.
		adminCreateService.createPassenger(passenger);
		
		System.out.println(adminPassengerView.getAlertSuccessfulCreate());
		System.out.println(trailingNewLine);
	}
	
	public void runAdminDeletePassenger() throws SQLException {
		Passenger targetPassenger = null;
		StringBuilder spacing = new StringBuilder("  ");
		Integer optionNumber = null;
		List<Passenger> passengerList = adminReadService.readPassenger();
		String[] passengerOptions = new String[passengerList.size() + 1];
		
		System.out.println(adminPassengerView.getHeaderDeletePassenger());
	
		// Get the passenger options.
		for(int i = 0; i < passengerList.size(); i++) {
			if(i % 9 == 0) { spacing.append(" "); }
			Passenger passenger = passengerList.get(i);
			StringBuilder passengerOption = new StringBuilder();
			passengerOption.append("Given Name: " + passenger.getGivenName());
			passengerOption.append("\n" + spacing + "Family Name: " + passenger.getFamilyName());
			passengerOption.append("\n" + spacing + "Date of Birth: " + passenger.getDob());
			passengerOption.append("\n");
			passengerOptions[i] = passengerOption.toString();
		}
		passengerOptions[passengerList.size()] = adminPassengerView.getOptionReturn();
		
		optionNumber = runMenu(adminPassengerView.getPromptSelectPassengerToDelete(), passengerOptions, Boolean.FALSE);
		if(adminPassengerView.getOptionReturn().equals(passengerOptions[optionNumber])) {
			System.out.println(trailingNewLine);
			return;
		}
		targetPassenger = passengerList.get(optionNumber);
	
		// Delete the passenger.
		adminDeleteService.deletePassenger(targetPassenger);
		
		System.out.println(adminPassengerView.getAlertSuccessfulDelete());
		System.out.println(trailingNewLine);
	}
	
	public void runAdminReadPassenger() throws SQLException {
		List<Passenger> passengerList = adminReadService.readPassenger();
		StringBuilder spacing = new StringBuilder("  ");
		
		System.out.println(adminPassengerView.getHeaderReadPassenger());
		
		for(int i = 0; i < passengerList.size(); i++) {
			if(i % 9 == 0) {spacing.append(" ");}
			Passenger passenger = passengerList.get(i);
			System.out.println((i + 1) + ") Booking Id: " + passenger.getBookingId());
			System.out.println(spacing + "Given Name: " + passenger.getGivenName());
			System.out.println(spacing + "Family Name: " + passenger.getFamilyName());
			System.out.println(spacing + "Date of Birth: " + passenger.getDob());
			System.out.println(spacing + "Gender: " + passenger.getGender());
			System.out.println(spacing + "Address: " + passenger.getAddress());
			System.out.println();
		}
		System.out.print(trailingNewLine);
	}
}
