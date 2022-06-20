package com.using.jdk;

import java.util.Date;
import java.util.Timer;

public class SchedulingTest {

	public static void main(String[] args) {
		System.out.println("start of app : "+ new Date());
		
		Timer timer = new Timer();
		//month count = 0-11 , year = 1900 to continue
		//timer.schedule(new MyTask(), new Date((2022-1900), 05, 03, 11, 20,40));	//point of time
		
		timer.schedule(new MyTask(), 5000, 3000); 	//executing in a loop 
	}
	
}
