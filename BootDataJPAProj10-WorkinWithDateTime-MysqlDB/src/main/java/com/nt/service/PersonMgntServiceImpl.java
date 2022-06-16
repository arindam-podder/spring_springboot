package com.nt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nt.entity.Person;
import com.nt.repository.IPersonRepository;

@Service
public class PersonMgntServiceImpl implements IPersonMgntService {

	private IPersonRepository repo;
	
	//if there is one constructor in class no need to place autowired anno , dependent class will be injected automatically
	public PersonMgntServiceImpl(IPersonRepository repo) {
		this.repo = repo;
	}

	@Override
	public String registerPerson(Person person) {
		Person p = repo.save(person);
		return "person with the id="+p.getId()+" is saved";
	}
	
	@Override
	public List<Person> getAllPersonDetails() {
		return repo.findAll();
	}
	
}




