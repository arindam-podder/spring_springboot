package com.rest.allrequestmodes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/employee/api")
public class EmployeeOperationController {

	//defining all http mode request possible in rest application
	
	@GetMapping(path = "/all")
	public ResponseEntity<String> getAllEmployee(){
		return new ResponseEntity<String>("get mapping...", HttpStatus.OK);
	}
	
	@PostMapping(path = "/save")
	public ResponseEntity<String> saveEmployee(){
		return new ResponseEntity<String>("post mapping...", HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/update")
	public ResponseEntity<String> updateEmployee(){
		return new ResponseEntity<String>("put mapping...", HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/delete")
	public ResponseEntity<String> deleteEmployee(){
		return new ResponseEntity<String>("delete mapping...", HttpStatus.OK);
	}
	
	@PatchMapping(path = "/updateEmail")
	public ResponseEntity<String> updateEmployeeEmail(){
		return new ResponseEntity<String>("patch mapping...", HttpStatus.OK);
	}
	
}//class










