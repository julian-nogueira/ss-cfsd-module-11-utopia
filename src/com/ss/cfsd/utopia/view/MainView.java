package com.ss.cfsd.utopia.view;

public class MainView extends BaseView {

	private String header1 = ""
			+ "\n====================================================="
			+ "\n================== Utopia Airlines =================="
			+ "\n====================================================="
			+ "\n";
	
	private String optionEmployee = "Employee";
	private String optionAdmin = "Administrator";
	private String optionTraveler = "Traveler";
	
	private String[] header1Options = {optionEmployee, optionAdmin, optionTraveler, optionQuit};

	public String getHeader1() {
		return header1;
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

	public String[] getHeader1Options() {
		return header1Options;
	}
}
