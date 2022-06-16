package com.logging.practice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.logging.practice.models.Student;

@Controller
public class StudentController {

	@RequestMapping("/")
	public String welcome() {
		return "welcome";
	}
	
	@GetMapping("/register")
	public String showStudentFormPage() {
		return "student_register";
	}
	
	//data binding by @ModelAttribute
	@PostMapping("/register")
	public String registerStudent(@ModelAttribute("s1") Student st ) {	//'s1' will go to view
		return "show_student";
	}	
	
/*	@PostMapping("/register")
	public String registerStudent(Student st ) {//without @modelattribute also binding happened,model in small word will be ref name 
		return "show_student";
	}	*/
	

	/*
	 * check 140 data binding note of nataraj 
	 */
}
