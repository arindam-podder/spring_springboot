package com.nt.crudoperation.service;

import java.util.List;

import com.nt.crudoperation.model.Employee;

public interface IEmployeeService {
	public List<Employee> getAllEmp();
	
	public String registerEmployee(Employee employee);
	
	public abstract Employee getEmpByNo(Integer no);
	
	public String editEmp(Employee employee);
	
	public String deleteEmp(Integer no);
	
}
