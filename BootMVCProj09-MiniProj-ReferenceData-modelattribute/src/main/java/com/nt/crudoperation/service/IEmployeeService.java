package com.nt.crudoperation.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.crudoperation.model.Employee;

public interface IEmployeeService {
	public List<Employee> getAllEmp();
	
	public String registerEmployee(Employee employee);
	
	public abstract Employee getEmpByNo(Integer no);
	
	public String editEmp(Employee employee);
	
	public String deleteEmp(Integer no);
	
	
	//for pagination
	public Page<Employee> getEmpPageData(Pageable pageable);
	
	//for all country list
	public Set<String> getAllCountries();
 	
	//to get states of a country
	public Set<String> getStatesByCountry(String country);
	
}













