package com.ss.cfsd.utopia.menu;

import com.ss.cfsd.utopia.view.AdminFlightView;

public class AdminFlightMenu extends BaseMenu {
	
	private AdminFlightView adminFlightView = null;

	public AdminFlightMenu() {
		adminFlightView = new AdminFlightView();
	}
	
	public void runAdminFlightMenu() {
		String option = null;
		Integer optionNumber = null;
		
		try {
			while(true) {
				optionNumber = runMenu(adminFlightView.getHeader1(), adminFlightView.getHeader1Options(), Boolean.TRUE);
				option = adminFlightView.getHeader1Options()[optionNumber];
				
				if(adminFlightView.getOptionReturn().equals(option)) {
					return;
				} else if(adminFlightView.getOptionAdd().equals(option)) {
					//
				} else if(adminFlightView.getOptionUpdate().equals(option)) {
					//
				} else if(adminFlightView.getOptionDelete().equals(option)) {
					//
				} else if(adminFlightView.getOptionRead().equals(option)) {
					//
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
