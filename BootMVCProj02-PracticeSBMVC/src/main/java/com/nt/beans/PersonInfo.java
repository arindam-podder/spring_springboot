package com.nt.beans;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonInfo {
	private String name;
	private String fatherName;
	private Integer age;
	private String location;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public PersonInfo() {
		super();
	}
	
	public PersonInfo(String name, String fatherName, Integer age, String location) {
		super();
		this.name = name;
		this.fatherName = fatherName;
		this.age = age;
		this.location = location;
	}
	
	
	
	
/*	public static void main(String[] args) {
		List<PersonInfo> l = List.of(
				new PersonInfo("A", "B", 23, "wb"),
				new PersonInfo("C", "B", 23, "wb")
				);
		
		System.out.println(l);
		
	}	*/
	
}
