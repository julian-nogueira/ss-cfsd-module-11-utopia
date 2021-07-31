package com.ss.cfsd.utopia.menu;

import com.ss.cfsd.utopia.view.MainView;

public class MainMenu extends BaseMenu {

	private MainView mainView = null;
	private AdminMenu adminMenu = null;
	
	public MainMenu() {
		mainView = new MainView();
		adminMenu = new AdminMenu();
	}

	public void runMainMenu() {
		String option = null;
		Integer optionNumber = null;
		
		try {
			while(true) {
				optionNumber = runMenu(mainView.getHeader1(), mainView.getHeader1Options(), Boolean.TRUE);
				option = mainView.getHeader1Options()[optionNumber];
				
				if(mainView.getOptionQuit().equals(option)) {
					return;
				} else if(mainView.getOptionEmployee().equals(option)) {
					//
				} else if(mainView.getOptionAdmin().equals(option)) {
					adminMenu.runAdminMenu();
				} else if(mainView.getOptionTraveler().equals(option)) {
					//
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
