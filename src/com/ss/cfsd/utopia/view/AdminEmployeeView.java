package com.ss.cfsd.utopia.view;

public class AdminEmployeeView extends BaseView {

	private String headerMain = ""
			+ "\n========== Administrator: Employee =================="
			+ "\n";
	private String headerReadEmployee = ""
			+ "\n========== Administrator: Read Employee ============="
			+ "\n";
	
	private String[] headerMainOptions = {optionAdd, optionUpdate, optionDelete, optionRead, optionReturn};

	public String getHeaderMain() {
		return headerMain;
	}
	
	public String getHeaderReadEmployee() {
		return headerReadEmployee;
	}

	public String[] getHeaderMainOptions() {
		return headerMainOptions;
	}
}
