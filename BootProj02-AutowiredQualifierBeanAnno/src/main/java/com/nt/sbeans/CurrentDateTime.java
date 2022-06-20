package com.nt.sbeans;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("dateTime")
public class CurrentDateTime {

	@Autowired
	@Qualifier("d1")
	private Date date;
	
	public void now() {
		System.out.println(date);
	}
	
	
}
