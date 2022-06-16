package com.nt.crudoperation.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_crud")
public class Employee {

	@Id
	@SequenceGenerator(name = "emp_crud_seq", allocationSize = 3 , initialValue = 101)
	@GeneratedValue(generator = "emp_crud_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name = "emp_name")
	private String name;
	
	@Column(name = "emp_location")
	private String location;
	
	@Column(name = "emp_salary")
	private Double salary;
	
	@Column(name="dob")
	@DateTimeFormat(pattern = "[yyyy-MM-dd][yyyy/MM/dd][dd/MM/yyyy][dd-MM-yyyy][d/M/yyyy]")
	private LocalDate dateOfBirth;
	
	private String role;
	
}
