package com.rest.swagger.model;

public class Person {

	private String name;
	private String location;
	
	public Person() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Person->[name=" + name + ", location=" + location + "]";
	}
	
	
}
