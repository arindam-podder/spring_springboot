package com.nt.crudoperation.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.crudoperation.model.Employee;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Employee.class);		//checks whether u r passing correct model or not 
	}

	@Override
	public void validate(Object target, Errors errors) {
		//type casting
		Employee employee = (Employee) target;
	
		if(employee.getName()==null || employee.getName().equals("") || employee.getName().length()==0 ) {
			//errors.rejectValue("emp_name", "emp.name.required");	//emp_name not valid , pass model filed name
			
			// name = it is field of Employee model , emp.name.required = key in validation.properties
			errors.rejectValue("name", "emp.name.required");
		}
		else if(employee.getName().length()<=3 || employee.getName().length() >= 21) {
			errors.rejectValue("name", "emp.name.length");
		}
		if( hasNumberOrSpecialCharacter(employee.getName()) ) {
			errors.rejectValue("name", "emp.name.onlychar");
		}
		
		if(employee.getDateOfBirth() == null) {
			errors.rejectValue("dateOfBirth", "emp.dob.required");
		}
		
		if(employee.getSalary() == null ) {
			errors.rejectValue("salary", "emp.salary.required");
		}
		else if(employee.getSalary() < 1.00  || employee.getSalary() > 100000.00) {
			errors.rejectValue("salary","emp.salary.range");
		}
		
		if(employee.getRole() == null || employee.getRole().length()==0 || employee.getRole().equals("")) {
			errors.rejectValue("role", "emp.role.required");
		}
	}//validate(-,-) method end

	
	
	
	//my defined methods
	private boolean hasNumberOrSpecialCharacter(String name) {
		if(name!= null) {
			Pattern pattern = Pattern.compile("[^A-Za-z ]");
			Matcher matcher = pattern.matcher(name);
			return matcher.find();
		}
		return false;
	}
	
	
	
	
	
	
}//class end














