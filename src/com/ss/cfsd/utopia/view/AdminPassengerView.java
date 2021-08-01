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
	private String headerUpdatePassenger = ""
			+ "\n========== Administrator: Update Passenger =========="
			+ "\n";
	
	private String promptSelectBookingId = ""
			+ "Select the booking id and confirmation code:\n";
	private String promptSelectPassengerToDelete = ""
			+ "Select the passenger to be deleted:\n";
	private String promptSelectPassengerToUpdate = ""
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
	private String promptEnterGivenNameOrNA = ""
			+ "\nEnter the given name or N/A for no change: ";
	private String promptEnterFamilyNameOrNA = ""
			+ "\nEnter the family name or N/A for no change: ";
	private String promptEnterDateOfBirthOrNA = ""
			+ "\nEnter the date of birth in yyyy-mm-dd format or N/A for no change: ";
	private String promptEnterGenderOrNA = ""
			+ "\nEnter the gender or N/A for no change: ";
	private String promptEnterAddressOrNA = ""
			+ "\nEnter the address or N/A for no change: ";
	
	private String alertSuccessfulCreate = "\nThe passenger was successfully added.";
	private String alertSuccessfulDelete = "\nThe passenger was successfully deleted.";
	private String alertSuccessfulUpdate = "\nThe passenger was successfully updated.";
	
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

	public String getHeaderUpdatePassenger() {
		return headerUpdatePassenger;
	}

	public String getPromptSelectBookingId() {
		return promptSelectBookingId;
	}

	public String getPromptSelectPassengerToDelete() {
		return promptSelectPassengerToDelete;
	}

	public String getPromptSelectPassengerToUpdate() {
		return promptSelectPassengerToUpdate;
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

	public String getPromptEnterGivenNameOrNA() {
		return promptEnterGivenNameOrNA;
	}

	public String getPromptEnterFamilyNameOrNA() {
		return promptEnterFamilyNameOrNA;
	}

	public String getPromptEnterDateOfBirthOrNA() {
		return promptEnterDateOfBirthOrNA;
	}

	public String getPromptEnterGenderOrNA() {
		return promptEnterGenderOrNA;
	}

	public String getPromptEnterAddressOrNA() {
		return promptEnterAddressOrNA;
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
