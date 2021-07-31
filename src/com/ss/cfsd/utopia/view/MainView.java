package com.ss.cfsd.utopia.view;

public class MainView extends BaseView {

	private String headerMain = ""
			+ "\n====================================================="
			+ "\n================== Utopia Airlines =================="
			+ "\n====================================================="
			+ "\n";
	
	private String optionEmployee = "Employee";
	private String optionAdmin = "Administrator";
	private String optionTraveler = "Traveler";
	
	private String[] headerMainOptions = {optionEmployee, optionAdmin, optionTraveler, optionQuit};

	public String getHeaderMain() {
		return headerMain;
	}

	public String getOptionEmployee() {
		return optionEmployee;
	}

	public String getOptionAdmin() {
		return optionAdmin;
	}

	public String getOptionTraveler() {
		return optionTraveler;
	}

	public String[] getHeaderMainOptions() {
		return headerMainOptions;
	}
}
