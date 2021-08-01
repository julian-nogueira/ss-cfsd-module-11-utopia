package com.ss.cfsd.utopia.view;

public class AdminFlightView extends BaseView {

	private String headerMain = ""
			+ "\n========== Administrator: Flight ===================="
			+ "\n";
	private String headerReadFlight = ""
			+ "\n========== Administrator: Read Flight ==============="
			+ "\n";
	private String headerCreateFlight = ""
			+ "\n========== Administrator: Add Flight ================"
			+ "\n";
	private String headerDeleteFlight = ""
			+ "\n========== Administrator: Delete Flight ============="
			+ "\n";
	private String headerUpdateFlight = ""
			+ "\n========== Administrator: Update Flight ============="
			+ "\n";
	
	private String promptSelectOriginAirport = ""
			+ "Select the origin airport:\n";
	private String promptSelectDestinationAirport = ""
			+ "\nSelect the destination airport:\n";
	private String promptSelectFlightToDelete = ""
			+ "Select the flight to be deleted:\n";
	private String promptSelectFlightToUpdate = ""
			+ "Select the flight to be updated:\n";
	private String promptEnterDepartureDate = ""
			+ "\nEnter the departure date in yyyy-mm-dd format: ";
	private String promptEnterDepartureTime = ""
			+ "\nEnter the departure time in 24 hour hh:mm:ss format: ";
	private String promptEnterDepartureTimeOrNA = ""
			+ "\nEnter the departure time in 24 hour hh:mm:ss format or N/A for no change: ";
	private String promptEnterSeatPriceOrNA = ""
			+ "\nEnter the seat price or N/A for no change: ";
	
	private String alertSuccessfulCreate = "\nThe flight was successfully added.";
	private String alertSuccessfulDelete = "\nThe flight was successfully deleted.";
	private String alertSuccessfulUpdate = "\nThe flight was successfully updated.";
	
	private String[] headerMainOptions = {optionAdd, optionUpdate, optionDelete, optionRead, optionReturn};

	public String getHeaderMain() {
		return headerMain;
	}
	
	public String getHeaderReadFlight() {
		return headerReadFlight;
	}
	
	public String getHeaderCreateFlight() {
		return headerCreateFlight;
	}
	
	public String getHeaderDeleteFlight() {
		return headerDeleteFlight;
	}
	
	public String getHeaderUpdateFlight() {
		return headerUpdateFlight;
	}
	
	public String getPromptSelectOriginAirport() {
		return promptSelectOriginAirport;
	}
	
	public String getPromptSelectDestinationAirport() {
		return promptSelectDestinationAirport;
	}
	
	public String getPromptSelectFlightToDelete() {
		return promptSelectFlightToDelete;
	}
	
	public String getPromptSelectFlightToUpdate() {
		return promptSelectFlightToUpdate;
	}
	
	public String getPromptEnterDepartureDate() {
		return promptEnterDepartureDate;
	}
	
	public String getPromptEnterDepartureTime() {
		return promptEnterDepartureTime;
	}
	
	public String getPromptEnterDepartureTimeOrNA() {
		return promptEnterDepartureTimeOrNA;
	}
	
	public String getPromptEnterSeatPriceOrNA() {
		return promptEnterSeatPriceOrNA;
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
