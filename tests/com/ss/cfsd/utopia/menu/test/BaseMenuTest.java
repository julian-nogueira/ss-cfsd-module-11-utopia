package com.ss.cfsd.utopia.menu.test;

import com.ss.cfsd.utopia.menu.BaseMenu;

import java.time.LocalDate;
import java.time.LocalTime;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BaseMenuTest {

	BaseMenu baseMenu = new BaseMenu();
	
	String promptTestGetData = "Enter data: ";
	String promptTestGetDataOrNA = "Enter data or N/A: ";
	String promptTestGetDataLengthThree = "Enter abc: ";
	String promptTestGetInteger = "Enter 7: ";
	String promptTestGetFloatOrNA = "Enter 7.0: ";
	String promptTestGetDate = "Enter a date: ";
	String promptTestGetDateOrNA = "Enter a date or N/A: ";
	String promptTestGetDateOrNAOrQuit = "Enter a date or N/A or quit: ";
	String promptTestGetTime = "Enter a time: ";
	String promptTestGetTimeOrNA = "Enter a time or N/A: ";
	String promptTestGetTimeOrNAOrQuit = "Enter a time or N/A or quit: ";

	String[] optionsTestRunMenu = {"A", "B", "C"};
	
	@Test
	public void runMenu() {
		assertEquals(0, baseMenu.runMenu("", optionsTestRunMenu, Boolean.FALSE));
	}
	
	@Test
	public void getData() {
		assertEquals("data", baseMenu.getData("", promptTestGetData));
	}
	
	@Test
	public void getDataOrNA() {
		assertEquals(null, baseMenu.getDataOrNA("", promptTestGetDataOrNA));
	}
	
	@Test
	public void getDataLengthThree() {
		assertEquals("abc", baseMenu.getDataLengthThree("", promptTestGetDataLengthThree));
	}
	
	@Test
	public void getInteger() {
		assertEquals(new Integer(7), baseMenu.getInteger("", promptTestGetInteger, Boolean.FALSE));
	}
	
	@Test
	public void getFloatOrNA() {
		assertEquals(new Float(7.0f), baseMenu.getFloatOrNA("", promptTestGetFloatOrNA, Boolean.FALSE));
	}
	
	@Test
	public void getDate() {
		assertEquals(LocalDate.of(2021, 8, 1), baseMenu.getDate("", promptTestGetDate, Boolean.FALSE));
	}
	
	@Test
	public void getDateOrNA() {
		assertEquals(null, baseMenu.getDateOrNA("", promptTestGetDateOrNA, Boolean.FALSE));
	}
	
	@Test
	public void getDateOrNAOrQuit() {
		assertEquals("Quit", baseMenu.getDateOrNAOrQuit("", promptTestGetDateOrNAOrQuit, Boolean.FALSE));
	}
	
	@Test
	public void getTime() {
		assertEquals(LocalTime.parse("12:00:00"), baseMenu.getTime("", promptTestGetTime, Boolean.FALSE));
	}
	
	@Test
	public void getTimeOrNA() {
		assertEquals(null, baseMenu.getTimeOrNA("", promptTestGetTimeOrNA, Boolean.FALSE));
	}
	
	@Test
	public void getTimeOrNAOrQuit() {
		assertEquals("N/A", baseMenu.getTimeOrNAOrQuit("", promptTestGetTimeOrNAOrQuit, Boolean.FALSE));
	}
}


































