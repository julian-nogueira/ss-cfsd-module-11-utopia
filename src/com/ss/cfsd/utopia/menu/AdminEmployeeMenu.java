package com.ss.cfsd.utopia.menu;

import com.ss.cfsd.utopia.view.AdminEmployeeView;

public class AdminEmployeeMenu extends BaseMenu {

	private AdminEmployeeView adminEmployeeView = null;
	
	public AdminEmployeeMenu() {
		adminEmployeeView = new AdminEmployeeView();
	}
	
	public void runAdminEmployeeMenu() {
		String option = null;
		Integer optionNumber = null;
		
		try {
			while(true) {
				optionNumber = runMenu(adminEmployeeView.getHeader1(), adminEmployeeView.getHeader1Options(), Boolean.TRUE);
				option = adminEmployeeView.getHeader1Options()[optionNumber];
				
				if(adminEmployeeView.getOptionReturn().equals(option)) {
					return;
				} else if(adminEmployeeView.getOptionAdd().equals(option)) {
					//
				} else if(adminEmployeeView.getOptionUpdate().equals(option)) {
					//
				} else if(adminEmployeeView.getOptionDelete().equals(option)) {
					//
				} else if(adminEmployeeView.getOptionRead().equals(option)) {
					//
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
