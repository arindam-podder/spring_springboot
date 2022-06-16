package com.nt.service;

import java.util.List;

import com.nt.entity.EmployeeInfo;

public interface IEmployeeMgmtService {
	
	public abstract String saveEmployee(EmployeeInfo emp);
	
	List<EmployeeInfo> getAllEmployee();

}
