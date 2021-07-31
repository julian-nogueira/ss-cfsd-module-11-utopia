package com.ss.cfsd.utopia.view;

public class AdminPassengerView extends BaseView {

	private String headerMain = ""
			+ "\n========== Administrator: Passenger ================="
			+ "\n";
	private String headerReadPassenger = ""
			+ "\n========== Administrator: Read Passenger ============"
			+ "\n";
	
	private String[] headerMainOptions = {optionAdd, optionUpdate, optionDelete, optionRead, optionReturn};

	public String getHeaderMain() {
		return headerMain;
	}
	
	public String getHeaderReadPassenger() {
		return headerReadPassenger;
	}

	public String[] getHeaderMainOptions() {
		return headerMainOptions;
	}
}
