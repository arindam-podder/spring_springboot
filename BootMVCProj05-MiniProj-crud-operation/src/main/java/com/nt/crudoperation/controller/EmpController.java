package com.nt.crudoperation.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.nt.crudoperation.model.Employee;
import com.nt.crudoperation.service.IEmployeeService;

@Controller
public class EmpController {

	@Autowired
	private IEmployeeService service;
	
	@GetMapping("/")
	public String homeForReportGeneration() {
		return "home";
	}
	
	@GetMapping("/report")
	public String showEmpReport(Map<String, Object> map) {
		List<Employee> emplist = service.getAllEmp();
		map.put("empsData", emplist);
		return "emp_report";
	}
		
	@GetMapping("/add")
	public String showAddEmpForm(@ModelAttribute("emp") Employee employee) {
		employee.setLocation("India"); //setting initial val to diplay in form component as initial value 
		return "employee_register";
	}	
	
/*	@PostMapping("/add")
	public String addEmpForm(Map<String, Object> map, @ModelAttribute("emp") Employee employee) {
		String result = service.registerEmployee(employee);
		//keep results in model attribute
		map.put("resultMsg", result);	
		List<Employee> emplist = service.getAllEmp();
		map.put("empsData", emplist);
		return "emp_report";		//problem multiple form submission
	}	*/
	// post mode "/add" handler method improvisation
	@PostMapping("/add")
	public String addEmpForm(RedirectAttributes attributes, @ModelAttribute("emp") Employee employee) {
		String result = service.registerEmployee(employee);
		//keep results in model attribute
		attributes.addFlashAttribute("resultMsg", result);	//add flash attribute
		return "redirect:/report";	
	}	
	// another choice
/*	@PostMapping("/add")
	public String addEmpForm(HttpSession session, @ModelAttribute("emp") Employee employee) {
		String result = service.registerEmployee(employee);
		//keep results in model attribute
		session.setAttribute("resultMsg", result);	//add session attribute
		return "redirect:/report";	
	}	*/
	
	
	
	
	@GetMapping("/edit")
	public String showEditEmpForm(@RequestParam("id") Integer eid, @ModelAttribute("emp") Employee emp) {
		Employee employee = service.getEmpByNo(eid);
		//emp = employee; (or)
		BeanUtils.copyProperties(employee, emp);
		return "employee_eidt";
	}
	
/*	@PostMapping("/edit")
	public String EditEmp(Map<String, Object> map,@ModelAttribute("emp") Employee emp) {
		String result = service.editEmp(emp);
		map.put("resultMsg", result);	
		List<Employee> emplist = service.getAllEmp();
		map.put("empsData", emplist);
		return "emp_report";
	}	*/
	// post "/edit" handler method improvisation
	@PostMapping("/edit")
	public String EditEmp(RedirectAttributes attributes,@ModelAttribute("emp") Employee emp) {
		String result = service.editEmp(emp);
		attributes.addFlashAttribute("resultMsg", result);	
		return "redirect:/report";
	}
	
	
	
	
	
	

	
	
/*	@GetMapping("/delete")
	public String deleteEmp(@RequestParam("id") Integer eid, Map<String, Object> map) {
		String result = service.deleteEmp(eid);
		map.put("resultMsg", result);	
		List<Employee> emplist = service.getAllEmp();
		map.put("empsData", emplist);
		return "emp_report";
	}	*/
	// "/delete" handler method improvisation
/*	@GetMapping("/delete")
	public String deleteEmp(@RequestParam("id") Integer eid, Map<String, Object> map) {
		String result = service.deleteEmp(eid);
		map.put("resultMsg", result);	
		return "forward:/report";
	}	*/
	@GetMapping("/delete")
	public String deleteEmp(@RequestParam("id") Integer eid,RedirectAttributes attributes ) {
		String result = service.deleteEmp(eid);
		attributes.addFlashAttribute("resultMsg", result);	
		return "redirect:/report";
	}
	
	
	
}











