package com.nt.crudoperation.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.nt.crudoperation.model.Employee;
import com.nt.crudoperation.service.IEmployeeService;
import com.nt.crudoperation.validations.EmployeeValidator;

@Controller
public class EmpController {

	@Autowired
	private IEmployeeService service;
	
	@Autowired
	private EmployeeValidator empVlidator;
	
	@GetMapping("/")
	public String homeForReportGeneration() {
		return "home";
	}
	
/*	@GetMapping("/report")
	public String showEmpReport(Map<String, Object> map) {
		List<Employee> emplist = service.getAllEmp();
		map.put("empsData", emplist);
		return "emp_report";
	}	*/
	//for pagination
	@GetMapping("/report")
	public String showEmpReport(@PageableDefault(page = 0,size = 3, sort = "salary",direction = Direction.DESC) Pageable pageable,
								Map<String,Object> map ) {
		Page<Employee> empPageData = service.getEmpPageData(pageable);
		//empPageData.getPageable().getPageNumber();
		map.put("empsData", empPageData);
		return "emp_report";
	}
	
	
	@GetMapping("/add")
	public String showAddEmpForm(@ModelAttribute("emp") Employee employee) {
		return "employee_register";
	}	
	@PostMapping("/add")
	public String addEmpForm(RedirectAttributes attributes, 
							 @ModelAttribute("emp") Employee employee,
							 BindingResult error) {
		
		//checking client side validation sre done or not
		if(employee.getVflag().equalsIgnoreCase("no")) {
			//checking from validation errors
			if(empVlidator.supports(employee.getClass()) ) {
				empVlidator.validate(employee, error);
				if(error.hasErrors()) {
					return "employee_register";
				}
			}
		}
		//type mismatch errors hadling
		if(error.hasFieldErrors()) {
			return "employee_register";
		}		
		String result = service.registerEmployee(employee);
		//keep results in model attribute
		attributes.addFlashAttribute("resultMsg", result);	//add flash attribute
		return "redirect:/report";	
	}	
	
	
	@GetMapping("/edit")
	public String showEditEmpForm(@RequestParam("id") Integer eid, @ModelAttribute("emp") Employee emp) {
		Employee employee = service.getEmpByNo(eid);
		//emp = employee; (or)
		BeanUtils.copyProperties(employee, emp);
		return "employee_edit";
	}
	@PostMapping("/edit")
	public String EditEmp(RedirectAttributes attributes,
						  @ModelAttribute("emp") Employee employee, 
						  BindingResult error) {
		
		//checking client side validation are done or not
		if(employee.getVflag().equalsIgnoreCase("no")) {
			if(empVlidator.supports(employee.getClass()) ) {
				empVlidator.validate(employee, error);
				if(error.hasErrors()) {
					return "employee_edit";
				}
			}	
		}
		//type mismatch errors hadling
/*		if(error.hasFieldErrors()) {
			return "employee_edit";
		}	*/
		String result = service.editEmp(employee);
		attributes.addFlashAttribute("resultMsg", result);	
		return "redirect:/report";
	}
	
	
	@GetMapping("/delete")
	public String deleteEmp(@RequestParam("id") Integer eid,RedirectAttributes attributes ) {
		String result = service.deleteEmp(eid);
		attributes.addFlashAttribute("resultMsg", result);	
		return "redirect:/report";
	}
	
	
	//this model data(reference data) will be available in each form launch 
	@ModelAttribute("countriesList")
	public Set<String> allCountries(){
		return service.getAllCountries();
	}
	
	
	@PostMapping("/statesregister")
	public String showStatesForACountryRegisterProcess(@RequestParam("location") String country,
										@ModelAttribute("emp") Employee employee,
										Map<String, Object> map) {
		//use service 
		Set<String> statesByCountry = service.getStatesByCountry(country);
		//put states list in model attribute
		map.put("statesList", statesByCountry);
		//return logical view
		return "employee_register";
	}
	
	@PostMapping("/statesupdate")
	public String showStatesForACountryUpdateProcess(@RequestParam("location") String country,
										@ModelAttribute("emp") Employee employee,
										Map<String, Object> map) {
		//use service 
		Set<String> statesByCountry = service.getStatesByCountry(country);
		//put states list in model attribute
		map.put("statesList", statesByCountry);
		//return logical view
		return "employee_edit";
	}
}//class end











