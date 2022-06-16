package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nt.beans.PersonInfo;
import com.nt.service.IMvcService;

@Controller
//@RequestMapping("/test")
public class TestController {

	@Autowired
	private IMvcService service;
	
	
	@RequestMapping("/home")
	public String home() {
		System.out.println("TestController.home()");
		return "home";
	}
	
	
	
	//response body annotation use/test
	@ResponseBody
	@RequestMapping(value = "/person", method= RequestMethod.GET )
	public PersonInfo person() {
		System.out.println("TestController.person()");
		return service.getOnePerson();
	}
	@ResponseBody
	@RequestMapping(path = {"/list-person","/personlist"}, method = RequestMethod.GET)
	public List<PersonInfo> personList(){
		System.out.println("TestController.personList()");
		return service.getListOfPerson();
	}
	@ResponseBody
	@RequestMapping(path = {"/map-person","/personmap"}, method = RequestMethod.GET)
	public Map<Integer, PersonInfo> personMap(){
		System.out.println("TestController.personMap()");
		return Map.of( 1,service.getOnePerson(), 2,service.getOnePerson(), 3,service.getOnePerson() );
	}

	
	
	//request body annotation use/test
	@RequestMapping("/request-body1")
	public String rqstBody() {
		System.out.println("TestController.requestBody()");
		return "request_body1";
	}
	@PostMapping(value = "/request-body2" )
	public String rqstBody(PersonInfo person, Model m) {	//here request body form data will be stored in person obj(internal @RequestBody)
		System.out.println("TestController.requestBody()");
		System.out.println(person);
		m.addAttribute("person", person);
		return "request_body2";
	} 	
	@ResponseBody
	@PostMapping(value = "/request-body3" )
	public PersonInfo rqstBody1( /* @RequestBody */ PersonInfo person) {
		System.out.println("TestController.requestBody()");
		System.out.println(person);
		return person;
	} 	



}//class end











