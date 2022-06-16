package com.nt.service;

import java.util.List;

import com.nt.entity.Person;

public interface IOneToManyMappingMgmtService {
	
	public abstract String saveDataUsingParent(Person person);
	
	public List<Person> getAllPerson();
	
	public String deleteParentAndItsChild(Integer id);
	
	public String deleteAllPhoneNumbersOfAPerson(Integer id);
	
	
	
}
