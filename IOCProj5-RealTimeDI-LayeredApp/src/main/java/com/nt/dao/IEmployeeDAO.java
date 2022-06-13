package com.nt.dao;

import com.nt.dto.EmployeeDTO;

public interface IEmployeeDAO {
	public abstract int insertEmployee(EmployeeDTO empDTO) throws Exception;
}
