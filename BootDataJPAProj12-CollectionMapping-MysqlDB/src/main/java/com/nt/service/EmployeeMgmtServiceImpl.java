package com.nt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nt.entity.EmployeeInfo;
import com.nt.repository.EmployeeInfoRepo;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	private EmployeeInfoRepo repo;
	
	//if one cons present , no need to place autowired
	public EmployeeMgmtServiceImpl(EmployeeInfoRepo repo) {
		this.repo = repo;
	}

	@Override
	public String saveEmployee(EmployeeInfo emp) {
		EmployeeInfo e = repo.save(emp);
		return "employee with the id="+e.getId()+" is saved."; 
	}

	@Override
	public List<EmployeeInfo> getAllEmployee() {
		return repo.findAll();
	}

}
