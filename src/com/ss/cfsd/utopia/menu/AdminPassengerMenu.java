package com.ss.cfsd.utopia.menu;

import com.ss.cfsd.utopia.domain.Passenger;
import com.ss.cfsd.utopia.service.AdminReadService;
import com.ss.cfsd.utopia.view.AdminPassengerView;

import java.sql.SQLException;
import java.util.List;

public class AdminPassengerMenu extends BaseMenu {

	private AdminPassengerView adminPassengerView = null;
	private AdminReadService adminReadService = null;
	
	public AdminPassengerMenu() {
		adminPassengerView = new AdminPassengerView();
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
					//
				} else if(adminPassengerView.getOptionUpdate().equals(option)) {
					//
				} else if(adminPassengerView.getOptionDelete().equals(option)) {
					//
				} else if(adminPassengerView.getOptionRead().equals(option)) {
					runAdminReadPassenger();
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
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
