package edu.chalmers.dat255.johannesco.sleepapp.test.model;

import junit.framework.TestCase;
import edu.chalmers.dat255.johannesco.sleepapp.main.model.SleepStyle;

public class SleepStyleTest extends TestCase {
	
	private SleepStyle style;
	private static final String styleName = "test";
	private static final long styleSleepTimeMillis = 8 * 60 * 60 * 1000;
	private static final long styleWakeTimeMillis = 20 * 60 * 60 * 1000;
	
	protected void setUp() {
		style = new SleepStyle(styleName,
				styleSleepTimeMillis, styleWakeTimeMillis);
	}
	
	protected void tearDown() {
		style = null;
	}

	public void testCreate() {
		assertNotNull(style);
	}
	
	public void testGetName() {
		assertEquals(styleName, style.getName());
	}
	
	public void testSetName() {
		style.setName("anothername");
		assertEquals("anothername", style.getName());
	}

}
