package com.mycompany.app.my_app;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AppTest {
	private static App app;
	
	@Before
	public void setUpNumbers() {
		app = new App(2,3);
	}
	
	@Test
	public void ReturnsTheMajorBetweenTwoSetUpNumbers() {
		int value = app.major();
		assertNotEquals(2, value);
		assertEquals(3, value);
    }
	
	@Test
	public void ReturnsTheMinorBetweenTwoSetUpNumbers() {
		int value = app.minor();
		assertNotNull(value);
		assertEquals(2, value);
	}

}

