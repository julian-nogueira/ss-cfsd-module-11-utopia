package com.ss.cfsd.utopia.view;

public class AdminPassengerView extends BaseView {

	private String headerMain = ""
			+ "\n========== Administrator: Passenger ================="
			+ "\n";
	private String headerReadPassenger = ""
			+ "\n========== Administrator: Read Passenger ============"
			+ "\n";
	private String headerCreatePassenger = ""
			+ "\n========== Administrator: Add Passenger ============="
			+ "\n";
	private String headerDeletePassenger = ""
			+ "\n========== Administrator: Delete Passenger =========="
			+ "\n";
	
	private String promptSelectBookingId = ""
			+ "Select the booking id and confirmation code:\n";
	private String promptSelectPassengerToDelete = ""
			+ "Select the passenger to be deleted:\n";
	private String promptEnterGivenName = ""
			+ "\nEnter the given name: ";
	private String promptEnterFamilyName = ""
			+ "\nEnter the family name: ";
	private String promptEnterDateOfBirth = ""
			+ "\nEnter the date of birth in yyyy-mm-dd format: ";
	private String promptEnterGender = ""
			+ "\nEnter the gender: ";
	private String promptEnterAddress = ""
			+ "\nEnter the address: ";
	
	private String alertSuccessfulCreate = "\nThe passenger was successfully added.";
	private String alertSuccessfulDelete = "\nThe passenger was successfully deleted.";
	
	private String[] headerMainOptions = {optionAdd, optionUpdate, optionDelete, optionRead, optionReturn};

	public String getHeaderMain() {
		return headerMain;
	}
	
	public String getHeaderReadPassenger() {
		return headerReadPassenger;
	}
	
	public String getHeaderCreatePassenger() {
		return headerCreatePassenger;
	}
	
	public String getHeaderDeletePassenger() {
		return headerDeletePassenger;
	}
	
	public String getPromptSelectBookingId() {
		return promptSelectBookingId;
	}
	
	public String getPromptSelectPassengerToDelete() {
		return promptSelectPassengerToDelete;
	}
	
	public String getPromptEnterGivenName() {
		return promptEnterGivenName;
	}

	public String getPromptEnterFamilyName() {
		return promptEnterFamilyName;
	}

	public String getPromptEnterDateOfBirth() {
		return promptEnterDateOfBirth;
	}

	public String getPromptEnterGender() {
		return promptEnterGender;
	}

	public String getPromptEnterAddress() {
		return promptEnterAddress;
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
