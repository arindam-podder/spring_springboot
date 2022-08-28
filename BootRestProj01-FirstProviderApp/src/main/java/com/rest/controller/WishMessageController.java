package com.rest.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/message")
public class WishMessageController {

	@GetMapping(path = "/greeting")
	public ResponseEntity<String> showMessage(){
		//system time
		LocalDateTime ldt = LocalDateTime.now();
		//get the hour 
		int hour = ldt.getHour();
		String msg = null;
		if(hour < 12 && hour > 6) {
			msg = "Good Morning.";
		}
		else if(hour < 17) {
			msg = "Good Afternoon.";
		}
		else if(hour < 19) {
			msg = "Good Evening";
		}
		else {
			msg = "Good Night.";
		}
		
		//create & return ResponseEntity having the response content & response status
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(msg, HttpStatus.OK);	
		return responseEntity;
	}
	
}
