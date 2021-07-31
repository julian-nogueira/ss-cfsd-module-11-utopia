package com.ss.cfsd.utopia.view;

public class AdminPassengerView extends BaseView {

	private String header1 = ""
			+ "\n========== Administrator: Passenger ================="
			+ "\n";
	
	private String[] header1Options = {optionAdd, optionUpdate, optionDelete, optionRead, optionReturn};

	public String getHeader1() {
		return header1;
	}

	public String[] getHeader1Options() {
		return header1Options;
	}
}
