package com.ss.cfsd.utopia.view;

public class AdminAirportView extends BaseView {

	private String headerMain = ""
			+ "\n========== Administrator: Airport ==================="
			+ "\n";
	private String headerReadAirport = ""
			+ "\n========== Administrator: Read Airport =============="
			+ "\n";
	
	private String[] headerMainOptions = {optionAdd, optionUpdate, optionDelete, optionRead, optionReturn};

	public String getHeaderMain() {
		return headerMain;
	}
	
	public String getHeaderReadAirport() {
		return headerReadAirport;
	}

	public String[] getHeaderMainOptions() {
		return headerMainOptions;
	}
}
