package com.ss.cfsd.utopia.menu;

import com.ss.cfsd.utopia.view.AdminMainView;

public class AdminMenu extends BaseMenu {
	
	private AdminMainView adminMainView = null;
	private AdminFlightMenu adminFlightMenu = null;
	private AdminPassengerMenu adminPassengerMenu = null;
	private AdminAirportMenu adminAirportMenu = null;
	private AdminTravelerMenu adminTravelerMenu = null;
	private AdminEmployeeMenu adminEmployeeMenu = null;
	
	public AdminMenu() {
		adminMainView = new AdminMainView();
		adminFlightMenu = new AdminFlightMenu();
		adminPassengerMenu = new AdminPassengerMenu();
		adminAirportMenu = new AdminAirportMenu();
		adminTravelerMenu = new AdminTravelerMenu();
		adminEmployeeMenu = new AdminEmployeeMenu();
	}

	public void runAdminMenu() {
		String option = null;
		Integer optionNumber = null;
		
		try {
			while(true) {
				optionNumber = runMenu(adminMainView.getHeader1(), adminMainView.getHeader1Options(), Boolean.TRUE);
				option = adminMainView.getHeader1Options()[optionNumber];
				
				if(adminMainView.getOptionReturn().equals(option)) {
					return;
				} else if(adminMainView.getOptionFlight().equals(option)) {
					adminFlightMenu.runAdminFlightMenu();
				} else if(adminMainView.getOptionPassenger().equals(option)) {
					adminPassengerMenu.runAdminPassengerMenu();
				} else if(adminMainView.getOptionAirport().equals(option)) {
					adminAirportMenu.runAdminAirportMenu();
				} else if(adminMainView.getOptionTraveler().equals(option)) {
					adminTravelerMenu.runAdminTravelerMenu();
				} else if(adminMainView.getOptionEmployee().equals(option)) {
					adminEmployeeMenu.runAdminEmployeeMenu();
				} else if(adminMainView.getOptionOverride().equals(option)) {
					//
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
