package com.nt.sbeans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("bike")
//@Primary
public class Bike implements Vehicle {
	
	@Override
	public void start() {
		System.out.println("Bike started");
	}

	@Override
	public void stop() {
		System.out.println("Bike stoped");
	}
	
}
