package com.mycompany.app.my_app;

import junit.framework.TestCase;

public class AppTest extends TestCase{
	private static App app;
	
	public void setUp() {
		app = new App(2,3);
	}
	
	public void testMajor() {
		int value = app.major();
		assertNotSame(2, value);
		assertEquals(3, value);
    }
	
	public void testMinor() {
		int value = app.minor();
		assertNotNull(value);
		assertEquals(2, value);
	}

}

