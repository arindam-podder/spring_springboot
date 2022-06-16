package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
	
	@GetMapping(path = "/")
	public String showHome() {
		return "welcome";
	}
	
	@GetMapping(path = "/register")
	public String showCusRegisterForm() {
		return "register_customer";
	}
	
	
	
}
