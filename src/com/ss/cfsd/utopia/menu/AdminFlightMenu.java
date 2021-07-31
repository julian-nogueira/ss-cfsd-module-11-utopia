package com.ss.cfsd.utopia.menu;

import com.ss.cfsd.utopia.domain.Flight;
import com.ss.cfsd.utopia.service.AdminReadService;
import com.ss.cfsd.utopia.view.AdminFlightView;

import java.sql.SQLException;
import java.util.List;

public class AdminFlightMenu extends BaseMenu {

	private AdminFlightView adminFlightView = null;
	private AdminReadService adminReadService = null;

	public AdminFlightMenu() {
		adminFlightView = new AdminFlightView();
		adminReadService = new AdminReadService();
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
					//
				} else if(adminFlightView.getOptionUpdate().equals(option)) {
					//
				} else if(adminFlightView.getOptionDelete().equals(option)) {
					//
				} else if(adminFlightView.getOptionRead().equals(option)) {
					runAdminReadFlight();
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void runAdminReadFlight() throws SQLException {
		List<Flight> flightList = adminReadService.readFlight();
		StringBuilder spacing = new StringBuilder("  ");
		
		System.out.println(adminFlightView.getHeaderReadFlight());
		
		for(int i = 0; i < flightList.size(); i++) {
			if(i % 9 == 0) {spacing.append(" ");}
			Flight flight = flightList.get(i);
			System.out.println((i + 1) + ") Origin: " + flight.getRoute().getOriginId());
			System.out.println(spacing + "Destination: " + flight.getRoute().getDestinationId());
			System.out.println(spacing + "Departure Time: " + flight.getDepartureTime().toLocalDateTime().toLocalDate());
			System.out.println(spacing + "Seat Price: $" + flight.getSeatPrice());
			System.out.println();
		}
		System.out.print(trailingNewLine);
	}
}












