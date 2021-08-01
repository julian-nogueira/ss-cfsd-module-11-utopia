package com.ss.cfsd.utopia.view;

public class AdminEmployeeView extends BaseView {

	private String headerMain = ""
			+ "\n========== Administrator: Employee =================="
			+ "\n";
	private String headerReadEmployee = ""
			+ "\n========== Administrator: Read Employee ============="
			+ "\n";
	private String headerCreateEmployee = ""
			+ "\n========== Administrator: Add Employee =============="
			+ "\n";
	
	private String promptEnterGivenName = ""
			+ "Enter the given name: ";
	private String promptEnterFamilyName = ""
			+ "\nEnter the family name: ";
	private String promptEnterUsername = ""
			+ "\nEnter the username: ";
	private String promptEnterEmail = ""
			+ "\nEnter the email: ";
	private String promptEnterPassword = ""
			+ "\nEnter the password: ";
	private String promptEnterPhone = ""
			+ "\nEnter the phone: ";
	
	private String alertSuccessfulCreate = "\nThe employee was successfully added.";
	
	private String[] headerMainOptions = {optionAdd, optionUpdate, optionDelete, optionRead, optionReturn};

	public String getHeaderMain() {
		return headerMain;
	}
	
	public String getHeaderReadEmployee() {
		return headerReadEmployee;
	}
	
	public String getHeaderCreateEmployee() {
		return headerCreateEmployee;
	}

	public String getPromptEnterGivenName() {
		return promptEnterGivenName;
	}

	public String getPromptEnterFamilyName() {
		return promptEnterFamilyName;
	}

	public String getPromptEnterUsername() {
		return promptEnterUsername;
	}

	public String getPromptEnterEmail() {
		return promptEnterEmail;
	}

	public String getPromptEnterPassword() {
		return promptEnterPassword;
	}

	public String getPromptEnterPhone() {
		return promptEnterPhone;
	}
	
	public String getAlertSuccessfulCreate() {
		return alertSuccessfulCreate;
	}

	public String[] getHeaderMainOptions() {
		return headerMainOptions;
	}
}
