package com.batch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_jpa")
public class Employee {

	@Id
	private Integer empNo;
	@Column(name = "emp_name")
	private String empName;
	@Column(name = "emp_address")
	private String empAddress;
	@Column(name = "emp_salary")
	private Float  empSalary;
		
}
