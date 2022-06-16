package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nt.entity.Student;
import com.nt.service.IStudentService;

@Controller
public class StudentController {

	private IStudentService studentService;
	
	
	public StudentController(IStudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping(path = "/students")
	public String listStudents(Map<String, Object> map) {
		map.put("students", studentService.getAllStudent());
		return "students_data";
	}
	
	@GetMapping(path = "/add")
	public String showStudentForm() {
		return "create_student";
	}
	
	@PostMapping(path = "/add")
	public String addStudent(@ModelAttribute Student student) {
		System.out.println(student.getFirstName()+" : "+student.getLastName()+" : "+student.getEmail());
		studentService.addStudent(student);
		return "redirect:students";
	}
	
	@GetMapping(path = "/update/{id}")
	public String editStudentForm(@PathVariable("id") Long id,
								  @ModelAttribute("std") Student student) {
		
		Student studentById = studentService.getStudentById(id);
		student.setFirstName(studentById.getFirstName());	//here we have to add data
		student.setLastName(studentById.getLastName());		//little confused,plz check
		student.setEmail(studentById.getEmail());			//but id present in student
		return "edit_student";
	}
	
	@PostMapping(path = "/update")
	public String updateStudent(@ModelAttribute Student student ) {
		studentService.updateStudent(student);
		return "redirect:students";
	}
	
	@GetMapping(path = "/delete/{id}")
	public String deleteStudent(@PathVariable("id") Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
	
	 
}//class end



