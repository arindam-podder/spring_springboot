package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("v_service")
public class VehicleService {

	@Autowired
	@Qualifier("car")
	private Vehicle vehicle;
	
	public void getService() {
		vehicle.start();
		vehicle.stop();
	}
	
}
