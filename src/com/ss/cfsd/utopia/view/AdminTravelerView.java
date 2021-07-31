package com.ss.cfsd.utopia.view;

public class AdminTravelerView extends BaseView {

	private String headerMain = ""
			+ "\n========== Administrator: Traveler =================="
			+ "\n";
	private String headerReadTraveler = ""
			+ "\n========== Administrator: Read Traveler ============="
			+ "\n";
	
	private String[] headerMainOptions = {optionAdd, optionUpdate, optionDelete, optionRead, optionReturn};

	public String getHeaderMain() {
		return headerMain;
	}
	
	public String getHeaderReadTraveler() {
		return headerReadTraveler;
	}

	public String[] getHeaderMainOptions() {
		return headerMainOptions;
	}
}
