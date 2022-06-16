package com.nt.service;

import java.util.List;

import com.nt.entity.Person;

public interface IPersonLobService {
	
	public abstract String registerPerson(Person person);
	
	Person getPersonById(Integer id);

}
