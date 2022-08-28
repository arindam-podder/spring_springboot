package com.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Person;

@RestController
@RequestMapping("/person")
public class PersonResource {

	@PostMapping("/save")
	public ResponseEntity<String> savePerson(@RequestBody Person person){
		System.out.println("PersonResource.savePerson()" +person);
		return new ResponseEntity<String>("person info => "+person.toString(), HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable Integer id){
		return new ResponseEntity<Person>(new Person(id, "Arindam Podder", 27, 60000.88), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePerson(@PathVariable Integer id){
		return new ResponseEntity<String>("Person(id="+id+") deleted.", HttpStatus.OK);
	}
	
}
