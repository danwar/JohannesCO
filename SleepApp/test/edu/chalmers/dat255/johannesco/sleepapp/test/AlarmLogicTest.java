package edu.chalmers.dat255.johannesco.sleepapp.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.chalmers.dat255.johannesco.sleepapp.main.AlarmLogic;

public class AlarmLogicTest {


	private AlarmLogic al = new AlarmLogic();;
	
	private static final int start = (8*60+15)*60*1000;
	private static final int stop = (9*60+30)*60*1000;
	private static final int test = (5*60+30)*60*1000;
	
	@Before
	public void setUp() throws Exception {
		al.sleepSetup(start);
		al.wakeSetup(stop);
	}
	
	public void testCreate(){
		assertNotNull(al);
	}


	public void testGetSleepTime() {
	assertEquals(start, al.getSleepTime());
	}

	public void testSetSleepTime() {
	al.sleepSetup(test);
	assertEquals(test, al.getSleepTime());
	}
	
	public void testGetWakeTime() {
	assertEquals(stop, al.getWakeTime());
	}
	
	public void failTestGetWakeTime() {
	assertEquals(test, al.getWakeTime());
	}

	public void testSetWakeTime() {
	al.sleepSetup(test);
	assertEquals(test, al.getWakeTime());
	}
		
	@After
	public void tearDown() throws Exception {
		al = null;
	}

	@Test
	public void test() {
		System.out.print("Testing");
	}

}
