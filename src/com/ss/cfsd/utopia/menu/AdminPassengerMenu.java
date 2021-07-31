package com.ss.cfsd.utopia.menu;

import com.ss.cfsd.utopia.view.AdminPassengerView;

public class AdminPassengerMenu extends BaseMenu {

	private AdminPassengerView adminPassengerView = null;
	
	public AdminPassengerMenu() {
		adminPassengerView = new AdminPassengerView();
	}
	
	public void runAdminPassengerMenu() {
		String option = null;
		Integer optionNumber = null;
		
		try {
			while(true) {
				optionNumber = runMenu(adminPassengerView.getHeader1(), adminPassengerView.getHeader1Options(), Boolean.TRUE);
				option = adminPassengerView.getHeader1Options()[optionNumber];
				
				if(adminPassengerView.getOptionReturn().equals(option)) {
					return;
				} else if(adminPassengerView.getOptionAdd().equals(option)) {
					//
				} else if(adminPassengerView.getOptionUpdate().equals(option)) {
					//
				} else if(adminPassengerView.getOptionDelete().equals(option)) {
					//
				} else if(adminPassengerView.getOptionRead().equals(option)) {
					//
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
