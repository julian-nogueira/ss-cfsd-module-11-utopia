package com.ss.cfsd.utopia.view;

public class TravelerView extends BaseView {

	private String headerAuthenticate = ""
			+ "\n========== Traveler: Authenticate ===================";
	private String headerMain = ""
			+ "\n========== Traveler: Main ==========================="
			+ "\n";
	private String headerBookFlight = ""
			+ "\n========== Traveler: Book Flight ===================="
			+ "\n";
	private String headerCancelFlight = ""
			+ "\n========== Traveler: Cancel Flight =================="
			+ "\n";
	
	private String promptEnterMembershipNumber = "\nEnter your membership number: ";
	private String promptSelectAFlightToBook = "Select a flight to book:\n";
	private String promptSelectAFlightToCancel = "Select a flight to cancel:\n";
	
	private String optionBookAFlight = "Book a flight";
	private String optionCancelAFlight = "Cancel a flight";
	
	private String alertValidMembershipNumber = "\nValid membership number.";
	private String alertInvalidMembershipNumber = "\nInvalid membership number.";
	private String alertSuccessfulBooking = "\nThe flight was successfully booked.";
	private String alertSuccessfulCancellation = "\nThe flight was successfully canceled.";
	private String alertNoFlightsToCancel = "\nYou have no flights to cancel.";
	
	private String[] headerMainOptions = {optionBookAFlight, optionCancelAFlight, optionReturn};

	public String getHeaderAuthenticate() {
		return headerAuthenticate;
	}

	public String getHeaderMain() {
		return headerMain;
	}

	public String getHeaderBookFlight() {
		return headerBookFlight;
	}

	public String getHeaderCancelFlight() {
		return headerCancelFlight;
	}

	public String getPromptEnterMembershipNumber() {
		return promptEnterMembershipNumber;
	}

	public String getPromptSelectAFlightToBook() {
		return promptSelectAFlightToBook;
	}

	public String getPromptSelectAFlightToCancel() {
		return promptSelectAFlightToCancel;
	}

	public String getOptionBookAFlight() {
		return optionBookAFlight;
	}

	public String getOptionCancelAFlight() {
		return optionCancelAFlight;
	}

	public String getAlertValidMembershipNumber() {
		return alertValidMembershipNumber;
	}

	public String getAlertInvalidMembershipNumber() {
		return alertInvalidMembershipNumber;
	}

	public String getAlertSuccessfulBooking() {
		return alertSuccessfulBooking;
	}

	public String getAlertSuccessfulCancellation() {
		return alertSuccessfulCancellation;
	}

	public String getAlertNoFlightsToCancel() {
		return alertNoFlightsToCancel;
	}

	public String[] getHeaderMainOptions() {
		return headerMainOptions;
	}
}
