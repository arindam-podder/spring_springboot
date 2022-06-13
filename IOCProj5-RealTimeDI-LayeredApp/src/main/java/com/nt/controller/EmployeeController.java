package com.nt.controller;

import com.nt.dto.EmployeeDTO;
import com.nt.service.IEmployeeMgmtService;

public class EmployeeController {
	
	private IEmployeeMgmtService service;

	public EmployeeController(IEmployeeMgmtService service) {
		this.service = service;
	}
	
	
	public String processEmployee(EmployeeDTO dto) throws Exception{
		String result = service.registerEmployee(dto);
		return result;
	}
	
}//class end
