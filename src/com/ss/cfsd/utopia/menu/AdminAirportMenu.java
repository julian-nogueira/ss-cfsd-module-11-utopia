package com.ss.cfsd.utopia.menu;

import com.ss.cfsd.utopia.domain.Airport;
import com.ss.cfsd.utopia.service.AdminReadService;
import com.ss.cfsd.utopia.view.AdminAirportView;

import java.sql.SQLException;
import java.util.List;

public class AdminAirportMenu extends BaseMenu {

	private AdminAirportView adminAirportView = null;
	private AdminReadService adminReadService = null;
	
	public AdminAirportMenu() {
		adminAirportView = new AdminAirportView();
		adminReadService = new AdminReadService();
	}
	
	public void runAdminAirportMenu() {
		String option = null;
		Integer optionNumber = null;
		
		try {
			while(true) {
				optionNumber = runMenu(adminAirportView.getHeaderMain(), adminAirportView.getHeaderMainOptions(), Boolean.TRUE);
				option = adminAirportView.getHeaderMainOptions()[optionNumber];
				
				if(adminAirportView.getOptionReturn().equals(option)) {
					return;
				} else if(adminAirportView.getOptionAdd().equals(option)) {
					//
				} else if(adminAirportView.getOptionUpdate().equals(option)) {
					//
				} else if(adminAirportView.getOptionDelete().equals(option)) {
					//
				} else if(adminAirportView.getOptionRead().equals(option)) {
					runAdminReadAirport();
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void runAdminReadAirport() throws SQLException {
		List<Airport> airportList = adminReadService.readAirport();
		StringBuilder spacing = new StringBuilder("  ");
		
		System.out.println(adminAirportView.getHeaderReadAirport());
		
		for(int i = 0; i < airportList.size(); i++) {
			if(i % 9 == 0) {spacing.append(" ");}
			Airport airport = airportList.get(i);
			System.out.println((i + 1) + ") IATA Id: " + airport.getIataId());
			System.out.println(spacing + "City: " + airport.getCity());
			System.out.println();
		}
		System.out.print(trailingNewLine);
	}
}
