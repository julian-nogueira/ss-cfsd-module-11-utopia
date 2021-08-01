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
	private String headerUpdateTraveler = ""
			+ "\n========== Administrator: Update Traveler ==========="
			+ "\n";
	
	private String promptSelectTravelerToDelete = ""
			+ "Select the traveler to be deleted:\n";
	private String promptSelectTravelerToUpdate = ""
			+ "Select the traveler to be updated:\n";
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
	private String promptEnterGivenNameOrNA = ""
			+ "\nEnter the given name or N/A for no change: ";
	private String promptEnterFamilyNameOrNA = ""
			+ "\nEnter the family name or N/A for no change: ";
	private String promptEnterUsernameOrNA = ""
			+ "\nEnter the username or N/A for no change: ";
	private String promptEnterEmailOrNA = ""
			+ "\nEnter the email or N/A for no change: ";
	private String promptEnterPasswordOrNA = ""
			+ "\nEnter the password or N/A for no change: ";
	private String promptEnterPhoneOrNA = ""
			+ "\nEnter the phone or N/A for no change: ";
	
	private String alertSuccessfulCreate = "\nThe traveler was successfully added.";
	private String alertSuccessfulDelete = "\nThe traveler was successfully deleted.";
	private String alertSuccessfulUpdate = "\nThe traveler was successfully updated.";
	
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

	public String getHeaderUpdateTraveler() {
		return headerUpdateTraveler;
	}

	public String getPromptSelectTravelerToDelete() {
		return promptSelectTravelerToDelete;
	}

	public String getPromptSelectTravelerToUpdate() {
		return promptSelectTravelerToUpdate;
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

	public String getPromptEnterGivenNameOrNA() {
		return promptEnterGivenNameOrNA;
	}

	public String getPromptEnterFamilyNameOrNA() {
		return promptEnterFamilyNameOrNA;
	}

	public String getPromptEnterUsernameOrNA() {
		return promptEnterUsernameOrNA;
	}

	public String getPromptEnterEmailOrNA() {
		return promptEnterEmailOrNA;
	}

	public String getPromptEnterPasswordOrNA() {
		return promptEnterPasswordOrNA;
	}

	public String getPromptEnterPhoneOrNA() {
		return promptEnterPhoneOrNA;
	}

	public String getAlertSuccessfulCreate() {
		return alertSuccessfulCreate;
	}

	public String getAlertSuccessfulDelete() {
		return alertSuccessfulDelete;
	}

	public String getAlertSuccessfulUpdate() {
		return alertSuccessfulUpdate;
	}

	public String[] getHeaderMainOptions() {
		return headerMainOptions;
	}
}
