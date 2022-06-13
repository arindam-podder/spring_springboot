package com.nt.service;

import com.nt.dto.EmployeeDTO;

public interface IEmployeeMgmtService {
	public abstract String registerEmployee(EmployeeDTO empDTO) throws Exception;
}
