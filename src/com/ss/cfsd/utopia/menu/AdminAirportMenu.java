package com.ss.cfsd.utopia.menu;

import com.ss.cfsd.utopia.view.AdminAirportView;

public class AdminAirportMenu extends BaseMenu {

	private AdminAirportView adminAirportView = null;
	
	public AdminAirportMenu() {
		adminAirportView = new AdminAirportView();
	}
	
	public void runAdminAirportMenu() {
		String option = null;
		Integer optionNumber = null;
		
		try {
			while(true) {
				optionNumber = runMenu(adminAirportView.getHeader1(), adminAirportView.getHeader1Options(), Boolean.TRUE);
				option = adminAirportView.getHeader1Options()[optionNumber];
				
				if(adminAirportView.getOptionReturn().equals(option)) {
					return;
				} else if(adminAirportView.getOptionAdd().equals(option)) {
					//
				} else if(adminAirportView.getOptionUpdate().equals(option)) {
					//
				} else if(adminAirportView.getOptionDelete().equals(option)) {
					//
				} else if(adminAirportView.getOptionRead().equals(option)) {
					//
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
