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
@RequestMapping(path = "/jsonFormat/api")
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
	
	@GetMapping(path = "/mapIntCompany")
	public ResponseEntity<Map<Integer, Company>> getMapIntCompany(){
		Map<Integer, Company>  map = new HashMap<>();
		map.put(1, new Company("Arin", "Raiganj", new Date(), 50000000.00));
		map.put(2, new Company("Arjun", "Binnagar", new Date(), 60000000.00));
		map.put(3, new Company("Chhanu", "Debinagar", new Date(), 40000000.00));
		map.put(4, new Company("Ajit", "Chakulia", new Date(), 100000000.00));
	
		return new ResponseEntity<Map<Integer,Company>>(map, HttpStatus.OK);
	}
	
	@GetMapping(path = "/map2Company")
	public ResponseEntity<Map<Company, Company>> getMap2Company(){
		Map<Company, Company>  map = new HashMap<>();
		map.put(new Company("Arin", "Raiganj", new Date(), 50000000.00),
				new Company("Arjun", "Binnagar", new Date(), 60000000.00));
	
		map.put(new Company("Chhanu", "Debinagar", new Date(), 40000000.00),
				new Company("Ajit", "Chakulia", new Date(), 100000000.00));
	
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@GetMapping(path = "/setCompany")
	public ResponseEntity<Set<Company>> getSetOfCompany(){
		Company company1 = new Company("HCL", "Hyd", new Date(1997, 1, 20), 50000000.00);
		Company company2 = new Company("IBM", "Bng", new Date(2000, 11, 12), 40000000.00);
		Company company3 = new Company("TCS", "Kol", new Date(2005, 4, 26), 30000000.00);
		
		return new ResponseEntity<Set<Company>>(Set.of(company1,company2,company3), HttpStatus.OK);
	}
	
	
	//more will come
	
}













