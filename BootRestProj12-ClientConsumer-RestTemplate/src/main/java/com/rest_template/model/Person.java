package com.rest_template.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	private Integer id;
	private String name;
	private Integer age;
	private Double savings;
	
}
