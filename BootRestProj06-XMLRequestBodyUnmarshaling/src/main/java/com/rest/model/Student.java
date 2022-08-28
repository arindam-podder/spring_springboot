package com.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	private Integer rollNo;
	private String Name;
	private Double average;
	private Boolean isVaccinated;
	
}
