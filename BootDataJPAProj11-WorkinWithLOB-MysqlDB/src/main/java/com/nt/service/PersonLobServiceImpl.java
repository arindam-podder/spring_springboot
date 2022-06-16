package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Person;
import com.nt.repository.PersonRepository;

@Service
public class PersonLobServiceImpl implements IPersonLobService {

	@Autowired
	private PersonRepository repo;
	
	@Override
	public String registerPerson(Person person) {
		return "Person with the id="+repo.save(person).getId()+" is saved";
	}

	@Override
	public Person getPersonById(Integer id) {
		Optional<Person> opt= repo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			return null;
		}
	}
	
	
}














