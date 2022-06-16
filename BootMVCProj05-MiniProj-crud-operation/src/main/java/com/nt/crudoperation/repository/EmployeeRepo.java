package com.nt.crudoperation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.crudoperation.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
