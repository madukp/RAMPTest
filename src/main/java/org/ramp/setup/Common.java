package org.ramp.setup;

import java.sql.Timestamp;

import org.junit.Test;

public class Common {

	
	public String getCurrentTime(){
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	String currentDateTime = timestamp.toString();
	return currentDateTime.substring(0, 19);
	}
	
	public String getLaterTimeStamp(int dates){
		long datestoIncrease = dates * 86400000;
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	timestamp.setTime( timestamp.getTime() + datestoIncrease);
	String currentDateTime = timestamp.toString();
	return currentDateTime.substring(0, 19);
	}
	
	
	@Test
	public void test(){
		System.out.println(getCurrentTime());
		System.out.println(getLaterTimeStamp(10));
	}
	
	
	
}
