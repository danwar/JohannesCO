package edu.chalmers.dat255.johannesco.sleepapp.test;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.chalmers.dat255.johannesco.sleepapp.main.Converter;

public class ConverterTest {

	private Converter c = new Converter();;
	
	private static final int hour = 5;
	private static final int min = 30;
	private static final int millis = (5*60+30)*60*1000;
	private static final int test = 10;
	
	public void testMillisToHour(){
		assertEquals(hour, c.millisToHour(millis));
	}
	
	public void testMillisToMin(){
		assertEquals(min, c.millisToMin(millis));
	}
	
	public void testIntToMillis(){
		assertEquals(millis, c.intToMillis(hour, min));
	}
	
	public void failTestMillisToHour(){
		assertEquals(test, c.millisToHour(millis));
	}
	
	public void failTestMillisToMin(){
		assertEquals(test, c.millisToMin(millis));
	}
	
	public void failTestIntToMillis(){
		assertEquals(millis, c.intToMillis(test, test));
	}


	@Test
	public void test() {
		System.out.print("Testing");	
	}

}
