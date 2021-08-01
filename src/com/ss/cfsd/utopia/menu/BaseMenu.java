package com.ss.cfsd.utopia.menu;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class BaseMenu {
	
	private String promptMenuOption = "\nEnter a menu option: ";
	private String invalidMenuOption = "\nInvalid menu option.";
	private String invalidInput = "\nInvalid input.";
	
	protected String trailingNewLine = "\n\n";
	protected String optionNA = "N/A";

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
	
	public String getDataOrNA(String header, String prompt) {
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
			
			if(optionNA.equals(input.toUpperCase())) {
				return null;
			}
			
			// Validate the input, such that it is not an empty string.
			if("".equals(input)) {
				System.out.println(invalidInput);
			} else {
				validInput = Boolean.TRUE;
			}
		}
		
		return input;
	}
	
	// Get free-form data of length three.
	public String getDataLengthThree(String header, String prompt) {
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
			if(input.length() != 3) {
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
	
	public Float getFloatOrNA(String header, String prompt, Boolean hasTrailingNewLine) {
		Scanner scanner = new Scanner(System.in);
		String input = null;
		Boolean validFloat = Boolean.FALSE;

		// Display a header if one was passed.
		if(!"".equals(header)) {
			System.out.println(header);
		}
	
		// Get input from the user.
		while(!validFloat) {
			System.out.print(prompt);
			input = scanner.nextLine();
			
			// Validate the input, such that it is an integer.
			try {
				if(optionNA.equals(input.toUpperCase())) {
					return null;
				}
				if(Float.parseFloat(input) > 0) {
					validFloat = Boolean.TRUE;
					if(hasTrailingNewLine) {
						System.out.println(trailingNewLine);
					}
				}
			} catch(Exception e) {
				System.out.println(invalidInput);
			}
		}

		return Float.parseFloat(input);
	}
	
	public LocalDate getDate(String header, String prompt, Boolean hasTrailingNewLine) {
		Scanner scanner = new Scanner(System.in);
		String input = null;
		Boolean validDate = Boolean.FALSE;

		// Display a header if one was passed.
		if(!"".equals(header)) {
			System.out.println(header);
		}
	
		// Get input from the user.
		while(!validDate) {
			System.out.print(prompt);
			input = scanner.nextLine();
			
			// Validate the input, such that it is a LocalDate.
			try {
				LocalDate.parse(input);
				validDate = Boolean.TRUE;
				if(hasTrailingNewLine) {
					System.out.println(trailingNewLine);
				}
			} catch(Exception e) {
				System.out.println(invalidInput);
			}
		}

		return LocalDate.parse(input);
	}
	
	public LocalDate getDateOrNA(String header, String prompt, Boolean hasTrailingNewLine) {
		Scanner scanner = new Scanner(System.in);
		String input = null;
		Boolean validDate = Boolean.FALSE;

		// Display a header if one was passed.
		if(!"".equals(header)) {
			System.out.println(header);
		}
	
		// Get input from the user.
		while(!validDate) {
			System.out.print(prompt);
			input = scanner.nextLine();
			
			// Validate the input, such that it is a LocalDate.
			try {
				if(optionNA.equals(input.toUpperCase())) {
					return null;
				}
				LocalDate.parse(input);
				validDate = Boolean.TRUE;
				if(hasTrailingNewLine) {
					System.out.println(trailingNewLine);
				}
			} catch(Exception e) {
				System.out.println(invalidInput);
			}
		}
		
		return LocalDate.parse(input);
	}
	
	public LocalTime getTime(String header, String prompt, Boolean hasTrailingNewLine) {
		Scanner scanner = new Scanner(System.in);
		String input = null;
		Boolean validTime = Boolean.FALSE;

		// Display a header if one was passed.
		if(!"".equals(header)) {
			System.out.println(header);
		}
	
		// Get input from the user.
		while(!validTime) {
			System.out.print(prompt);
			input = scanner.nextLine();
			
			// Validate the input, such that it is a LocalTime.
			try {
				LocalTime.parse(input);
				validTime = Boolean.TRUE;
				if(hasTrailingNewLine) {
					System.out.println(trailingNewLine);
				}
			} catch(Exception e) {
				System.out.println(invalidInput);
			}
		}

		return LocalTime.parse(input);
	}
	
	public LocalTime getTimeOrNA(String header, String prompt, Boolean hasTrailingNewLine) {
		Scanner scanner = new Scanner(System.in);
		String input = null;
		Boolean validTime = Boolean.FALSE;

		// Display a header if one was passed.
		if(!"".equals(header)) {
			System.out.println(header);
		}
	
		// Get input from the user.
		while(!validTime) {
			System.out.print(prompt);
			input = scanner.nextLine();
			
			// Validate the input, such that it is a LocalTime.
			try {
				if(optionNA.equals(input.toUpperCase())) {
					return null;
				}
				LocalTime.parse(input);
				validTime = Boolean.TRUE;
				if(hasTrailingNewLine) {
					System.out.println(trailingNewLine);
				}
			} catch(Exception e) {
				System.out.println(invalidInput);
			}
		}

		return LocalTime.parse(input);
	}
}
