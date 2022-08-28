package com.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Student;

@RestController
@RequestMapping(path = "/student/api")
public class StudentController{

	@PostMapping(path = "/save" )
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		System.out.println("student data is : "+student.toString());
		return new ResponseEntity<>(student,HttpStatus.CREATED);
	}
	
}//class end
