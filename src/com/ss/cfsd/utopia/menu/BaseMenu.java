package com.ss.cfsd.utopia.menu;

import java.util.Scanner;

public class BaseMenu {
	
	private String promptMenuOption = "\nEnter a menu option: ";
	private String invalidMenuOption = "\nInvalid menu option.";
	private String invalidInput = "\nInvalid input.";
	
	protected String trailingNewLine = "\n\n";

	public int runMenu(String header, String[] options, Boolean hasTrailingNewLine) {
		Integer optionNumber = null;

		// Display header.
		System.out.println(header);
		
		// Display options.
		for(int i = 0; i < options.length; i++) {
			System.out.println(i + 1 + ") " + options[i]);
		}
	
		// Get option.
		optionNumber = getOptionNumber(options, hasTrailingNewLine);
		
		return optionNumber;
	}

	// Get input based on an array of options.
	public int getOptionNumber(String[] options, Boolean hasTrailingNewLine) {
		Scanner scanner = new Scanner(System.in);
		String input = null;
		Boolean validOption = Boolean.FALSE;
		
		while(!validOption) {
			// Display prompt.
			System.out.print(promptMenuOption);
			
			// Get input.
			input = scanner.nextLine();
			
			try {
				// Validate input against options.
				String option = options[Integer.parseInt(input) - 1];
				validOption = Boolean.TRUE;
				if(hasTrailingNewLine) {
					System.out.println(trailingNewLine);
				}
			} catch(Exception e) {
				System.out.println(invalidMenuOption);
			}
		}

		return Integer.parseInt(input) - 1;
	}

	// Get free-form data.
	public String getData(String header, String prompt) {
		Scanner scanner = new Scanner(System.in);
		String input = null;
		Boolean validInput = Boolean.FALSE;
	
		// Display a header if one was passed.
		if(!"".equals(header)) {
			System.out.println(header);
		}
		
		while(!validInput) {
			// Get input from the user.
			System.out.print(prompt);
			input = scanner.nextLine();
			
			// Validate the input, such that it is not an empty string.
			if("".equals(input)) {
				System.out.println(invalidInput);
			} else {
				validInput = Boolean.TRUE;
			}
		}
		
		return input;
	}
	
	public Integer getInteger(String header, String prompt, Boolean hasTrailingNewLine) {
		Scanner scanner = new Scanner(System.in);
		String input = null;
		Boolean validInteger = Boolean.FALSE;

		// Display a header if one was passed.
		if(!"".equals(header)) {
			System.out.println(header);
		}
	
		// Get input from the user.
		while(!validInteger) {
			System.out.print(prompt);
			input = scanner.nextLine();
			
			// Validate the input, such that it is an integer.
			try {
				Integer.parseUnsignedInt(input);
				validInteger = Boolean.TRUE;
				if(hasTrailingNewLine) {
					System.out.println(trailingNewLine);
				}
			} catch(Exception e) {
				System.out.println(invalidInput);
			}
		}

		return Integer.parseInt(input);
	}
}