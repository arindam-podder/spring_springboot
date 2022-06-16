package com.nt.crudoperation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	
	//implementation for pagination
	@Override
	public Page<Employee> getEmpPageData(Pageable pageable) {
		//Pageable p = PageRequest.of(-,-);
		//Pageable p = PageRequest.of(-,-,-);
		Page<Employee> empPage = repo.findAll(pageable);
		return empPage;
	}
	
	
}//class end





