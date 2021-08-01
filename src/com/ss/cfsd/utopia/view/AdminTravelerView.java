package com.ss.cfsd.utopia.view;

public class AdminTravelerView extends BaseView {

	private String headerMain = ""
			+ "\n========== Administrator: Traveler =================="
			+ "\n";
	private String headerReadTraveler = ""
			+ "\n========== Administrator: Read Traveler ============="
			+ "\n";
	private String headerCreateTraveler = ""
			+ "\n========== Administrator: Add Traveler =============="
			+ "\n";
	private String headerDeleteTraveler = ""
			+ "\n========== Administrator: Delete Traveler ==========="
			+ "\n";
	
	private String promptSelectTravelerToDelete = ""
			+ "Select the traveler to be deleted:\n";
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
	
	private String alertSuccessfulCreate = "\nThe traveler was successfully added.";
	private String alertSuccessfulDelete = "\nThe traveler was successfully deleted.";
	
	private String[] headerMainOptions = {optionAdd, optionUpdate, optionDelete, optionRead, optionReturn};

	public String getHeaderMain() {
		return headerMain;
	}
	
	public String getHeaderReadTraveler() {
		return headerReadTraveler;
	}

	public String getHeaderCreateTraveler() {
		return headerCreateTraveler;
	}
	
	public String getHeaderDeleteTraveler() {
		return headerDeleteTraveler;
	}
	
	public String getPromptSelectTravelerToDelete() {
		return promptSelectTravelerToDelete;
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
	
	public String getAlertSuccessfulDelete() {
		return alertSuccessfulDelete;
	}

	public String[] getHeaderMainOptions() {
		return headerMainOptions;
	}
}
