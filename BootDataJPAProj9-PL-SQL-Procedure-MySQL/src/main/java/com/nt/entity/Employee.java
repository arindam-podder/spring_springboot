package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Employee {
	@Id
	private Integer eno;
	private String ename;
	private String desg;
	private float salary;
}
