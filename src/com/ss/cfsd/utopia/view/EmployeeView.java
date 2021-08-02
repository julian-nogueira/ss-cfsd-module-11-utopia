package com.ss.cfsd.utopia.view;

public class EmployeeView extends BaseView {

	private String headerMain = ""
			+ "\n========== Employee: Main ==========================="
			+ "\n";
	private String headerManageFlights = ""
			+ "\n========== Employee: Manage Flights ================="
			+ "\n";
	private String headerViewFlightDetails = ""
			+ "\n========== Employee: View Flight Details ============"
			+ "\n";
	private String headerUpdateFlightDetails = ""
			+ "\n========== Employee: Update Flight Details =========="
			+ "\n";
	
	private String promptSelectAFlight = ""
			+ "Select a flight:\n";
	private String promptSelectOriginAirport = ""
			+ "\nSelect the origin airport:\n";
	private String promptSelectDestinationAirport = ""
			+ "\nSelect the destination airport:\n";
	private String promptEnterDepartureDateOrNAOrQuit = ""
			+ "\nEnter the departure date in yyyy-mm-dd format or N/A or quit: ";
	private String promptEnterDepartureTimeOrNAOrQuit = ""
			+ "\nEnter the departure time in 24 hour hh:mm:ss format or N/A or quit: ";
	
	private String optionManageFlights = "Manage flights";
	private String optionViewDetails = "View more details about the flight";
	private String optionUpdateDetails = "Update the details of the flight";
	private String optionAddSeats = "Add seats to the flight";
	
	private String alertSuccessfulUpdate = "\nThe flight was successfully updated.";
	
	private String[] headerMainOptions = {optionManageFlights, optionReturn};
	private String[] headerManageFlightsOptions = {optionViewDetails, optionUpdateDetails, optionAddSeats, optionReturn};
	
	public String getHeaderMain() {
		return headerMain;
	}
	
	public String getHeaderManageFlights() {
		return headerManageFlights;
	}
	
	public String getHeaderViewFlightDetails() {
		return headerViewFlightDetails;
	}
	
	public String getHeaderUpdateFlightDetails() {
		return headerUpdateFlightDetails;
	}
	
	public String getPromptSelectAFlight() {
		return promptSelectAFlight;
	}
	
	public String getPromptSelectOriginAirport() {
		return promptSelectOriginAirport;
	}
	
	public String getPromptSelectDestinationAirport() {
		return promptSelectDestinationAirport;
	}
	
	public String getPromptEnterDepartureDateOrNAOrQuit() {
		return promptEnterDepartureDateOrNAOrQuit;
	}

	public String getPromptEnterDepartureTimeOrNAOrQuit() {
		return promptEnterDepartureTimeOrNAOrQuit;
	}
	
	public String getOptionManageFlights() {
		return optionManageFlights;
	}
	
	public String getOptionViewDetails() {
		return optionViewDetails;
	}
	
	public String getOptionUpdateDetails() {
		return optionUpdateDetails;
	}
	
	public String getOptionAddSeats() {
		return optionAddSeats;
	}
	
	public String getAlertSuccessfulUpdate() {
		return alertSuccessfulUpdate;
	}
	
	public String[] getHeaderMainOptions() {
		return headerMainOptions;
	}
	
	public String[] getHeaderManageFlightsOptions() {
		return headerManageFlightsOptions;
	}
}
