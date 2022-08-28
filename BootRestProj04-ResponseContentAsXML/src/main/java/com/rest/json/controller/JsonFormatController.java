package com.rest.json.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.json.model.Company;

@RestController
@RequestMapping(path = "/xmlFormat/api")
public class JsonFormatController {

	@GetMapping(path = "/oneCompany")
	public ResponseEntity<Company> getOneCompany(){
		Company company = new Company("HCL", "Hyd", new Date(1997, 1, 20), 50000000.00);
		return new ResponseEntity<Company>(company, HttpStatus.OK);
	}
	
	@GetMapping(path = "/listOfCompany")
	public ResponseEntity<List<Company>> getListCompany(){
		Company company1 = new Company("HCL", "Hyd", new Date(1997, 1, 20), 50000000.00);
		Company company2 = new Company("IBM", "Bng", new Date(2000, 11, 12), 40000000.00);
		Company company3 = new Company("TCS", "Kol", new Date(2005, 4, 26), 30000000.00);
		return new ResponseEntity<List<Company>>(List.of(company1,company2,company3), HttpStatus.OK);
	}
	
}













