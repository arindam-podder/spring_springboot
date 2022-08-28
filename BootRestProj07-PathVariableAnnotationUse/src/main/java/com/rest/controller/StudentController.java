package com.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "student/api")
public class StudentController {

	@GetMapping(path = "/data/{id}/{name}")
	public ResponseEntity<String> studentData(@PathVariable("id") String studentId,
												@PathVariable("name") String studentName){
		System.out.println("student[ id = "+studentId+" name = "+studentName+"]");
		return new ResponseEntity<String>("Id="+studentId+",Name="+studentName, HttpStatus.OK);
	}
	
}

