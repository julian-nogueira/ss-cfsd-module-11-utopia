package com.ss.cfsd.utopia.view;

public class AdminAirportView extends BaseView {

	private String headerMain = ""
			+ "\n========== Administrator: Airport ==================="
			+ "\n";
	private String headerReadAirport = ""
			+ "\n========== Administrator: Read Airport =============="
			+ "\n";
	private String headerCreateAirport = ""
			+ "\n========== Administrator: Add Airport ==============="
			+ "\n";
	private String headerDeleteAirport = ""
			+ "\n========== Administrator: Delete Airport ============"
			+ "\n";
	
	private String promptSelectAirportToDelete = ""
			+ "Select the airport to be deleted:\n";
	private String promptEnterIataId = ""
			+ "\nEnter the IATA id: ";
	private String promptEnterCity = ""
			+ "\nEnter the city: ";
	
	private String alertSuccessfulCreate = "\nThe airport was successfully added.";
	private String alertSuccessfulDelete = "\nThe airport was successfully deleted.";
	
	private String[] headerMainOptions = {optionAdd, optionUpdate, optionDelete, optionRead, optionReturn};

	public String getHeaderMain() {
		return headerMain;
	}
	
	public String getHeaderReadAirport() {
		return headerReadAirport;
	}
	
	public String getHeaderCreateAirport() {
		return headerCreateAirport;
	}
	
	public String getHeaderDeleteAirport() {
		return headerDeleteAirport;
	}
	
	public String getPromptSelectAirportToDelete() {
		return promptSelectAirportToDelete;
	}
	
	public String getPromptEnterIataId() {
		return promptEnterIataId;
	}

	public String getPromptEnterCity() {
		return promptEnterCity;
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
