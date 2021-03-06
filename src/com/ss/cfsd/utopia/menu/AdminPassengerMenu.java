package com.ss.cfsd.utopia.menu;

import com.ss.cfsd.utopia.domain.Booking;
import com.ss.cfsd.utopia.domain.Passenger;
import com.ss.cfsd.utopia.service.CreateService;
import com.ss.cfsd.utopia.service.DeleteService;
import com.ss.cfsd.utopia.service.ReadService;
import com.ss.cfsd.utopia.service.UpdateService;
import com.ss.cfsd.utopia.view.AdminPassengerView;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class AdminPassengerMenu extends BaseMenu {

	private AdminPassengerView adminPassengerView = null;
	private CreateService createService = null;
	private ReadService readService = null;
	private UpdateService updateService = null;
	private DeleteService deleteService = null;
	
	public AdminPassengerMenu() {
		adminPassengerView = new AdminPassengerView();
		createService = new CreateService();
		readService = new ReadService();
		updateService = new UpdateService();
		deleteService = new DeleteService();
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
					runAdminUpdatePassenger();
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
		bookingList = readService.readBookingWhereIsActiveEqualsTrue();
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
		createService.createPassenger(passenger);
		
		System.out.println(adminPassengerView.getAlertSuccessfulCreate());
		System.out.println(trailingNewLine);
	}
	
	public void runAdminUpdatePassenger() throws SQLException {
		Passenger targetPassenger = null;
		StringBuilder spacing = new StringBuilder("  ");
		String givenName = null;
		String familyName = null;
		LocalDate dateOfBirth = null;
		String gender = null;
		String address = null;
		Integer optionNumber = null;
		List<Passenger> passengerList = readService.readPassenger();
		String[] passengerOptions = new String[passengerList.size() + 1];
		
		System.out.println(adminPassengerView.getHeaderUpdatePassenger());
	
		// Get the passenger options.
		for(int i = 0; i < passengerList.size(); i++) {
			if(i % 9 == 0) { spacing.append(" "); }
			Passenger passenger = passengerList.get(i);
			StringBuilder passengerOption = new StringBuilder();
			passengerOption.append("Given Name: " + passenger.getGivenName());
			passengerOption.append("\n" + spacing + "Family Name: " + passenger.getFamilyName());
			passengerOption.append("\n" + spacing + "Date of Birth: " + passenger.getDob());
			passengerOption.append("\n" + spacing + "Gender: " + passenger.getGender());
			passengerOption.append("\n" + spacing + "Address: " + passenger.getAddress());
			passengerOption.append("\n");
			passengerOptions[i] = passengerOption.toString();
		}
		passengerOptions[passengerList.size()] = adminPassengerView.getOptionReturn();
		
		optionNumber = runMenu(adminPassengerView.getPromptSelectPassengerToUpdate(), passengerOptions, Boolean.FALSE);
		if(adminPassengerView.getOptionReturn().equals(passengerOptions[optionNumber])) {
			System.out.println(trailingNewLine);
			return;
		}
		targetPassenger = passengerList.get(optionNumber);
		
		// Prompt the user for pertinent information.
		givenName = getDataOrNA("", adminPassengerView.getPromptEnterGivenNameOrNA());
		familyName = getDataOrNA("", adminPassengerView.getPromptEnterFamilyNameOrNA());
		dateOfBirth = getDateOrNA("", adminPassengerView.getPromptEnterDateOfBirthOrNA(), Boolean.FALSE);
		gender = getDataOrNA("", adminPassengerView.getPromptEnterGenderOrNA());
		address = getDataOrNA("", adminPassengerView.getPromptEnterAddressOrNA());
		
		if(givenName != null) { targetPassenger.setGivenName(givenName); }
		if(familyName != null) { targetPassenger.setFamilyName(familyName); }
		if(dateOfBirth != null) { targetPassenger.setDob(Date.valueOf(dateOfBirth)); }
		if(gender != null) { targetPassenger.setGender(gender); }
		if(address != null) { targetPassenger.setAddress(address); }
		
		if(givenName == null && familyName == null && dateOfBirth == null && gender == null && address == null) {
			System.out.println(trailingNewLine);
			return;
		} else {
			// Update the passenger.
			updateService.updatePassenger(targetPassenger);
		}
		
		System.out.println(adminPassengerView.getAlertSuccessfulUpdate());
		System.out.println(trailingNewLine);
	}
	
	public void runAdminDeletePassenger() throws SQLException {
		Passenger targetPassenger = null;
		StringBuilder spacing = new StringBuilder("  ");
		Integer optionNumber = null;
		List<Passenger> passengerList = readService.readPassenger();
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
		deleteService.deletePassenger(targetPassenger);
		
		System.out.println(adminPassengerView.getAlertSuccessfulDelete());
		System.out.println(trailingNewLine);
	}
	
	public void runAdminReadPassenger() throws SQLException {
		List<Passenger> passengerList = readService.readPassenger();
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
