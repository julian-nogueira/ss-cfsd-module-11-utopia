package com.ss.cfsd.utopia.view;

public class AdminTravelerView extends BaseView {

	private String header1 = ""
			+ "\n========== Administrator: Traveler =================="
			+ "\n";
	
	private String[] header1Options = {optionAdd, optionUpdate, optionDelete, optionRead, optionReturn};

	public String getHeader1() {
		return header1;
	}

	public String[] getHeader1Options() {
		return header1Options;
	}
}
