package com.ss.cfsd.utopia.view;

public class AdminMainView extends BaseView {

	private String header1 = ""
			+ "\n========== Administrator: Main ======================"
			+ "\n";
	
	private String optionFlight = "Add/Update/Delete/Read Flight";
	private String optionPassenger = "Add/Update/Delete/Read Passenger";
	private String optionAirport = "Add/Update/Delete/Read Airport";
	private String optionTraveler = "Add/Update/Delete/Read Traveler";
	private String optionEmployee = "Add/Update/Delete/Read Employee";
	private String optionOverride = "Overried trip cancellation for a ticket";
	
	private String[] header1Options = {optionFlight, optionPassenger, optionAirport, optionTraveler, optionEmployee, optionOverride, optionReturn};

	public String getHeader1() {
		return header1;
	}

	public String getOptionFlight() {
		return optionFlight;
	}

	public String getOptionPassenger() {
		return optionPassenger;
	}

	public String getOptionAirport() {
		return optionAirport;
	}

	public String getOptionTraveler() {
		return optionTraveler;
	}

	public String getOptionEmployee() {
		return optionEmployee;
	}

	public String getOptionOverride() {
		return optionOverride;
	}

	public String[] getHeader1Options() {
		return header1Options;
	}
}
