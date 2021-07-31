package com.ss.cfsd.utopia.menu;

import com.ss.cfsd.utopia.view.AdminTravelerView;

public class AdminTravelerMenu extends BaseMenu {

	private AdminTravelerView adminTravelerView = null;
	
	public AdminTravelerMenu() {
		adminTravelerView = new AdminTravelerView();
	}
	
	public void runAdminTravelerMenu() {
		String option = null;
		Integer optionNumber = null;
		
		try {
			while(true) {
				optionNumber = runMenu(adminTravelerView.getHeader1(), adminTravelerView.getHeader1Options(), Boolean.TRUE);
				option = adminTravelerView.getHeader1Options()[optionNumber];
				
				if(adminTravelerView.getOptionReturn().equals(option)) {
					return;
				} else if(adminTravelerView.getOptionAdd().equals(option)) {
					//
				} else if(adminTravelerView.getOptionUpdate().equals(option)) {
					//
				} else if(adminTravelerView.getOptionDelete().equals(option)) {
					//
				} else if(adminTravelerView.getOptionRead().equals(option)) {
					//
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
