package com.nt.crudoperation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.crudoperation.model.Employee;
import com.nt.crudoperation.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private EmployeeRepo repo;
	
	@Override
	public List<Employee> getAllEmp() {
		return repo.findAll();
	}
	
	@Override
	public String registerEmployee(Employee employee) {
		Employee emp = repo.save(employee); 
		return "employee saved with the id no = "+emp.getId();
	}
	
	@Override
	public Employee getEmpByNo(Integer no) {
		return repo.findById(no).get();
	}
	
	@Override
	public String editEmp(Employee employee) {
		Employee emp = repo.save(employee);
		return "Employee (id="+emp.getId() +") is updated successfully.";
	}
	
	@Override
	public String deleteEmp(Integer no) {
		repo.deleteById(no);
		return "Employee(id="+no+") deleted.";
	}
	
	
}//class end
