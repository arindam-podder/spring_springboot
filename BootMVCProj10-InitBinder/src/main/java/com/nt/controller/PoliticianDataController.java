package com.nt.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.model.PoliticianProfile;

@Controller
public class PoliticianDataController {
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/register")
	public String showPoliticianForm(@ModelAttribute("politician") PoliticianProfile pp) {
		return "politician_register";
	}
	
	@PostMapping("/register")
	public String showPoliticianData(@ModelAttribute("politician") PoliticianProfile pp) {
		System.out.println("politician data : "+pp);
		return "politician_data";
	}
	
	
	@InitBinder
	public void myDateBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf, true) );
	}
	
}


