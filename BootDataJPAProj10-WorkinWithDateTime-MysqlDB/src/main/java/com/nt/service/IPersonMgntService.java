package com.nt.service;

import java.util.List;

import com.nt.entity.Person;

public interface IPersonMgntService {
	public abstract String registerPerson(Person person);
	public abstract List<Person> getAllPersonDetails();
	
}
