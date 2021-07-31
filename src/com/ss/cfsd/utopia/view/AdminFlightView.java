package com.ss.cfsd.utopia.view;

public class AdminFlightView extends BaseView {

	private String headerMain = ""
			+ "\n========== Administrator: Flight ===================="
			+ "\n";
	private String headerReadFlight = ""
			+ "\n========== Administrator: Read Flight ==============="
			+ "\n";
	
	private String[] headerMainOptions = {optionAdd, optionUpdate, optionDelete, optionRead, optionReturn};

	public String getHeaderMain() {
		return headerMain;
	}
	
	public String getHeaderReadFlight() {
		return headerReadFlight;
	}

	public String[] getHeaderMainOptions() {
		return headerMainOptions;
	}
}
