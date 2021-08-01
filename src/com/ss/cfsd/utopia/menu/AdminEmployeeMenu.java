package com.ss.cfsd.utopia.menu;

import com.ss.cfsd.utopia.domain.User;
import com.ss.cfsd.utopia.service.AdminCreateService;
import com.ss.cfsd.utopia.service.AdminDeleteService;
import com.ss.cfsd.utopia.service.AdminReadService;
import com.ss.cfsd.utopia.view.AdminEmployeeView;

import java.sql.SQLException;
import java.util.List;

public class AdminEmployeeMenu extends BaseMenu {

	private AdminEmployeeView adminEmployeeView = null;
	private AdminCreateService adminCreateService = null;
	private AdminDeleteService adminDeleteService = null;
	private AdminReadService adminReadService = null;
	
	public AdminEmployeeMenu() {
		adminEmployeeView = new AdminEmployeeView();
		adminCreateService = new AdminCreateService();
		adminDeleteService = new AdminDeleteService();
		adminReadService = new AdminReadService();
	}
	
	public void runAdminEmployeeMenu() {
		String option = null;
		Integer optionNumber = null;
		
		try {
			while(true) {
				optionNumber = runMenu(adminEmployeeView.getHeaderMain(), adminEmployeeView.getHeaderMainOptions(), Boolean.TRUE);
				option = adminEmployeeView.getHeaderMainOptions()[optionNumber];
				
				if(adminEmployeeView.getOptionReturn().equals(option)) {
					return;
				} else if(adminEmployeeView.getOptionAdd().equals(option)) {
					runAdminCreateEmployee();
				} else if(adminEmployeeView.getOptionUpdate().equals(option)) {
					//
				} else if(adminEmployeeView.getOptionDelete().equals(option)) {
					runAdminDeleteEmployee();
				} else if(adminEmployeeView.getOptionRead().equals(option)) {
					runAdminReadEmployee();
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void runAdminCreateEmployee() throws SQLException {
		User user = null;
		String givenName = null;
		String familyName = null;
		String username = null;
		String email = null;
		String password = null;
		String phone = null;
	
		System.out.println(adminEmployeeView.getHeaderCreateEmployee());
		
		// Get pertinent data from user.
		givenName = getData("", adminEmployeeView.getPromptEnterGivenName());
		familyName = getData("", adminEmployeeView.getPromptEnterFamilyName());
		username = getData("", adminEmployeeView.getPromptEnterUsername());
		email = getData("", adminEmployeeView.getPromptEnterEmail());
		password = getData("", adminEmployeeView.getPromptEnterPassword());
		phone = getData("", adminEmployeeView.getPromptEnterPhone());
	
		// Create the user object.
		user = new User();
		user.setGivenName(givenName);
		user.setFamilyName(familyName);
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(phone);
		
		// Create the employee.
		adminCreateService.createUserWhereRoleIdEqualsEmployeeId(user);
		
		System.out.println(adminEmployeeView.getAlertSuccessfulCreate());
		System.out.println(trailingNewLine);
	}
	
	public void runAdminDeleteEmployee() throws SQLException {
		User targetUser = null;
		StringBuilder spacing = new StringBuilder("  ");
		Integer optionNumber = null;
		List<User> userList = adminReadService.readEmployee();
		String[] userOptions = new String[userList.size() + 1];
		
		System.out.println(adminEmployeeView.getHeaderDeleteEmployee());
	
		// Get the employee options.
		for(int i = 0; i < userList.size(); i++) {
			if(i % 9 == 0) { spacing.append(" "); }
			User user = userList.get(i);
			StringBuilder userOption = new StringBuilder();
			userOption.append("Given Name: " + user.getGivenName());
			userOption.append("\n" + spacing + "Family Name: " + user.getFamilyName());
			userOption.append("\n" + spacing + "Username: " + user.getUsername());
			userOption.append("\n");
			userOptions[i] = userOption.toString();
		}
		userOptions[userList.size()] = adminEmployeeView.getOptionReturn();
		
		optionNumber = runMenu(adminEmployeeView.getPromptSelectEmployeeToDelete(), userOptions, Boolean.FALSE);
		if(adminEmployeeView.getOptionReturn().equals(userOptions[optionNumber])) {
			System.out.println(trailingNewLine);
			return;
		}
		targetUser = userList.get(optionNumber);
	
		// Delete the employee.
		adminDeleteService.deleteUser(targetUser);
		
		System.out.println(adminEmployeeView.getAlertSuccessfulDelete());
		System.out.println(trailingNewLine);
	}
	
	public void runAdminReadEmployee() throws SQLException {
		List<User> userList = adminReadService.readEmployee();
		StringBuilder spacing = new StringBuilder("  ");
		
		System.out.println(adminEmployeeView.getHeaderReadEmployee());
		
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
