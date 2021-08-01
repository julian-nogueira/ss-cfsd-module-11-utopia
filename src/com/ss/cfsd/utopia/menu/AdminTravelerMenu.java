package com.ss.cfsd.utopia.menu;

import com.ss.cfsd.utopia.domain.User;
import com.ss.cfsd.utopia.service.AdminCreateService;
import com.ss.cfsd.utopia.service.AdminDeleteService;
import com.ss.cfsd.utopia.service.AdminReadService;
import com.ss.cfsd.utopia.service.AdminUpdateService;
import com.ss.cfsd.utopia.view.AdminTravelerView;

import java.sql.SQLException;
import java.util.List;

public class AdminTravelerMenu extends BaseMenu {

	private AdminTravelerView adminTravelerView = null;
	private AdminCreateService adminCreateService = null;
	private AdminReadService adminReadService = null;
	private AdminUpdateService adminUpdateService = null;
	private AdminDeleteService adminDeleteService = null;
	
	public AdminTravelerMenu() {
		adminTravelerView = new AdminTravelerView();
		adminCreateService = new AdminCreateService();
		adminReadService = new AdminReadService();
		adminUpdateService = new AdminUpdateService();
		adminDeleteService = new AdminDeleteService();
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
					runAdminCreateTraveler();
				} else if(adminTravelerView.getOptionUpdate().equals(option)) {
					runAdminUpdateTraveler();
				} else if(adminTravelerView.getOptionDelete().equals(option)) {
					runAdminDeleteTraveler();
				} else if(adminTravelerView.getOptionRead().equals(option)) {
					runAdminReadTraveler();
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void runAdminCreateTraveler() throws SQLException {
		User user = null;
		String givenName = null;
		String familyName = null;
		String username = null;
		String email = null;
		String password = null;
		String phone = null;
	
		System.out.println(adminTravelerView.getHeaderCreateTraveler());
		
		// Get pertinent data from user.
		givenName = getData("", adminTravelerView.getPromptEnterGivenName());
		familyName = getData("", adminTravelerView.getPromptEnterFamilyName());
		username = getData("", adminTravelerView.getPromptEnterUsername());
		email = getData("", adminTravelerView.getPromptEnterEmail());
		password = getData("", adminTravelerView.getPromptEnterPassword());
		phone = getData("", adminTravelerView.getPromptEnterPhone());
	
		// Create the user object.
		user = new User();
		user.setGivenName(givenName);
		user.setFamilyName(familyName);
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(phone);
		
		// Create the traveler.
		adminCreateService.createUserWhereRoleIdEqualsTravelerId(user);
		
		System.out.println(adminTravelerView.getAlertSuccessfulCreate());
		System.out.println(trailingNewLine);
	}
	
	public void runAdminUpdateTraveler() throws SQLException {
		User targetUser = null;
		StringBuilder spacing = new StringBuilder("  ");
		String givenName = null;
		String familyName = null;
		String username = null;
		String email = null;
		String password = null;
		String phone = null;
		Integer optionNumber = null;
		List<User> userList = adminReadService.readTraveler();
		String[] userOptions = new String[userList.size() + 1];
		
		System.out.println(adminTravelerView.getHeaderUpdateTraveler());
	
		// Get the user options.
		for(int i = 0; i < userList.size(); i++) {
			if(i % 9 == 0) { spacing.append(" "); }
			User user = userList.get(i);
			StringBuilder userOption = new StringBuilder();
			userOption.append("Given Name: " + user.getGivenName());
			userOption.append("\n" + spacing + "Family Name: " + user.getFamilyName());
			userOption.append("\n" + spacing + "Username: " + user.getUsername());
			userOption.append("\n" + spacing + "Email: " + user.getEmail());
			userOption.append("\n" + spacing + "Password: " + user.getPassword());
			userOption.append("\n" + spacing + "Phone: " + user.getPhone());
			userOption.append("\n");
			userOptions[i] = userOption.toString();
		}
		userOptions[userList.size()] = adminTravelerView.getOptionReturn();
		
		optionNumber = runMenu(adminTravelerView.getPromptSelectTravelerToUpdate(), userOptions, Boolean.FALSE);
		if(adminTravelerView.getOptionReturn().equals(userOptions[optionNumber])) {
			System.out.println(trailingNewLine);
			return;
		}
		targetUser = userList.get(optionNumber);
		
		// Prompt the user for pertinent information.
		givenName = getDataOrNA("", adminTravelerView.getPromptEnterGivenNameOrNA());
		familyName = getDataOrNA("", adminTravelerView.getPromptEnterFamilyNameOrNA());
		username = getDataOrNA("", adminTravelerView.getPromptEnterUsernameOrNA());
		email = getDataOrNA("", adminTravelerView.getPromptEnterEmailOrNA());
		password = getDataOrNA("", adminTravelerView.getPromptEnterPasswordOrNA());
		phone = getDataOrNA("", adminTravelerView.getPromptEnterPhoneOrNA());
		
		if(givenName != null) { targetUser.setGivenName(givenName); }
		if(familyName != null) { targetUser.setFamilyName(familyName); }
		if(username != null) { targetUser.setUsername(username); }
		if(email != null) { targetUser.setEmail(email); }
		if(password != null) { targetUser.setPassword(password); }
		if(phone != null) { targetUser.setPhone(phone); }
		
		if(givenName == null && familyName == null && username == null && email == null && password == null && phone == null) {
			System.out.println(trailingNewLine);
			return;
		} else {
			// Update the user.
			adminUpdateService.updateUser(targetUser);
		}
		
		System.out.println(adminTravelerView.getAlertSuccessfulUpdate());
		System.out.println(trailingNewLine);
	}
	
	public void runAdminDeleteTraveler() throws SQLException {
		User targetUser = null;
		StringBuilder spacing = new StringBuilder("  ");
		Integer optionNumber = null;
		List<User> userList = adminReadService.readTraveler();
		String[] userOptions = new String[userList.size() + 1];
		
		System.out.println(adminTravelerView.getHeaderDeleteTraveler());
	
		// Get the traveler options.
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
		userOptions[userList.size()] = adminTravelerView.getOptionReturn();
		
		optionNumber = runMenu(adminTravelerView.getPromptSelectTravelerToDelete(), userOptions, Boolean.FALSE);
		if(adminTravelerView.getOptionReturn().equals(userOptions[optionNumber])) {
			System.out.println(trailingNewLine);
			return;
		}
		targetUser = userList.get(optionNumber);
	
		// Delete the passenger.
		adminDeleteService.deleteUser(targetUser);
		
		System.out.println(adminTravelerView.getAlertSuccessfulDelete());
		System.out.println(trailingNewLine);
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
