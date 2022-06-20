package com.using.jdk;

import java.util.Date;
import java.util.TimerTask;

public class MyTask extends TimerTask {

	@Override
	public void run() {
		System.out.println("----------------------");
		System.out.println("from mytask : "+new Date());
		System.out.println("----------------------");
	}
}

