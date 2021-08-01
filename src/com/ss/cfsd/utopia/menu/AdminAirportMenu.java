package com.ss.cfsd.utopia.menu;

import com.ss.cfsd.utopia.domain.Airport;
import com.ss.cfsd.utopia.service.AdminCreateService;
import com.ss.cfsd.utopia.service.AdminDeleteService;
import com.ss.cfsd.utopia.service.AdminReadService;
import com.ss.cfsd.utopia.view.AdminAirportView;

import java.sql.SQLException;
import java.util.List;

public class AdminAirportMenu extends BaseMenu {

	private AdminAirportView adminAirportView = null;
	private AdminCreateService adminCreateService = null;
	private AdminDeleteService adminDeleteService = null;
	private AdminReadService adminReadService = null;
	
	public AdminAirportMenu() {
		adminAirportView = new AdminAirportView();
		adminCreateService = new AdminCreateService();
		adminDeleteService = new AdminDeleteService();
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
					runAdminCreateAirport();
				} else if(adminAirportView.getOptionUpdate().equals(option)) {
					//
				} else if(adminAirportView.getOptionDelete().equals(option)) {
					runAdminDeleteAirport();
				} else if(adminAirportView.getOptionRead().equals(option)) {
					runAdminReadAirport();
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void runAdminCreateAirport() throws SQLException {
		Airport airport = null;
		String iataId = null;
		String city = null;
	
		System.out.println(adminAirportView.getHeaderCreateAirport());

		// Get pertinent data from user.
		iataId = getDataLengthThree("", adminAirportView.getPromptEnterIataId());
		city = getData("", adminAirportView.getPromptEnterCity());
	
		// Create the airport object.
		airport = new Airport();
		airport.setIataId(iataId.toUpperCase());
		airport.setCity(city);
		
		// Create the airport.
		adminCreateService.createAirport(airport);
		
		System.out.println(adminAirportView.getAlertSuccessfulCreate());
		System.out.println(trailingNewLine);
	}
	
	public void runAdminDeleteAirport() throws SQLException {
		Airport targetAirport = null;
		Integer optionNumber = null;
		List<Airport> airportList = adminReadService.readAirport();
		String[] airportOptions = new String[airportList.size() + 1];
		
		System.out.println(adminAirportView.getHeaderDeleteAirport());
	
		// Get the airport options.
		for(int i = 0; i < airportList.size(); i++) {
			Airport airport = airportList.get(i);
			StringBuilder airportOption = new StringBuilder();
			airportOption.append(airport.getIataId() + ", " + airport.getCity());
			airportOptions[i] = airportOption.toString();
		}
		airportOptions[airportList.size()] = adminAirportView.getOptionReturn();
		
		optionNumber = runMenu(adminAirportView.getPromptSelectAirportToDelete(), airportOptions, Boolean.FALSE);
		if(adminAirportView.getOptionReturn().equals(airportOptions[optionNumber])) {
			System.out.println(trailingNewLine);
			return;
		}
		targetAirport = airportList.get(optionNumber);
	
		// Delete the airport.
		adminDeleteService.deleteAirport(targetAirport);
		
		System.out.println(adminAirportView.getAlertSuccessfulDelete());
		System.out.println(trailingNewLine);
	}
	
	public void runAdminReadAirport() throws SQLException {
		List<Airport> airportList = adminReadService.readAirport();
		
		System.out.println(adminAirportView.getHeaderReadAirport());
		
		for(int i = 0; i < airportList.size(); i++) {
			Airport airport = airportList.get(i);
			System.out.println((i + 1) + ") " + airport.getIataId() + ", " + airport.getCity());
		}
		System.out.println();
		System.out.print(trailingNewLine);
	}
}
