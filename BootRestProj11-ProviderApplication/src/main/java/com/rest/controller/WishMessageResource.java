package com.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wish")
public class WishMessageResource {
	
	@GetMapping("/message")
	public ResponseEntity<String> greet(){
		return new ResponseEntity<String>("Hi,How r you?", HttpStatus.OK);
	}
	
	
	@GetMapping("/message/{id}/{name}")
	public ResponseEntity<String> messageWithPathVar(@PathVariable Integer id,
										@PathVariable String name){
		return new ResponseEntity<String>("Hi, "+id+"----"+name, HttpStatus.OK);
	}
	
	
}













