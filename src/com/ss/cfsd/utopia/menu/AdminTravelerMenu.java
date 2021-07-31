package com.ss.cfsd.utopia.menu;

import com.ss.cfsd.utopia.domain.User;
import com.ss.cfsd.utopia.service.AdminReadService;
import com.ss.cfsd.utopia.view.AdminTravelerView;

import java.sql.SQLException;
import java.util.List;

public class AdminTravelerMenu extends BaseMenu {

	private AdminTravelerView adminTravelerView = null;
	private AdminReadService adminReadService = null;
	
	public AdminTravelerMenu() {
		adminTravelerView = new AdminTravelerView();
		adminReadService = new AdminReadService();
	}
	
	public void runAdminTravelerMenu() {
		String option = null;
		Integer optionNumber = null;
		
		try {
			while(true) {
				optionNumber = runMenu(adminTravelerView.getHeaderMain(), adminTravelerView.getHeaderMainOptions(), Boolean.TRUE);
				option = adminTravelerView.getHeaderMainOptions()[optionNumber];
				
				if(adminTravelerView.getOptionReturn().equals(option)) {
					return;
				} else if(adminTravelerView.getOptionAdd().equals(option)) {
					//
				} else if(adminTravelerView.getOptionUpdate().equals(option)) {
					//
				} else if(adminTravelerView.getOptionDelete().equals(option)) {
					//
				} else if(adminTravelerView.getOptionRead().equals(option)) {
					runAdminReadTraveler();
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void runAdminReadTraveler() throws SQLException {
		List<User> userList = adminReadService.readTraveler();
		StringBuilder spacing = new StringBuilder("  ");
		
		System.out.println(adminTravelerView.getHeaderReadTraveler());
		
		for(int i = 0; i < userList.size(); i++) {
			if(i % 9 == 0) {spacing.append(" ");}
			User user = userList.get(i);
			System.out.println((i + 1) + ") Given Name: " + user.getGivenName());
			System.out.println(spacing + "Family Name: " + user.getFamilyName());
			System.out.println(spacing + "Username: " + user.getUsername());
			System.out.println(spacing + "Email: " + user.getEmail());
			System.out.println(spacing + "Password: " + user.getPassword());
			System.out.println(spacing + "Phone: " + user.getPhone());
			System.out.println();
		}
		System.out.print(trailingNewLine);
	}
}
