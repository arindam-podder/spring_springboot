package com.rest.swagger.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.swagger.model.Person;

@RestController
@RequestMapping("/home")
public class HomeResource {

	@GetMapping("/get")
	public ResponseEntity<String> getHi(){
		return new ResponseEntity<String>("Hi,all" , HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Person> savePerson(@RequestBody Person person){
		System.out.println(person);
		return new ResponseEntity<Person>(person,HttpStatus.CREATED);
	}
	
}
