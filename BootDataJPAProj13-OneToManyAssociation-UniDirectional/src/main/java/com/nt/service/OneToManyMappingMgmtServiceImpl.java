package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.repository.PersonRepo;
import com.nt.repository.PhoneNumberRepo;

@Service
public class OneToManyMappingMgmtServiceImpl implements IOneToManyMappingMgmtService {

	@Autowired
	private PersonRepo personRepo;
	
	@Autowired
	private PhoneNumberRepo phoneRepo;
	
	@Override
	public String saveDataUsingParent(Person person) {
		return "person(id="+personRepo.save(person).getPid()+") is saved.";
	}

	@Override
	public List<Person> getAllPerson() {
		return personRepo.findAll();
	}

	@Override
	public String deleteParentAndItsChild(Integer id) {
		//load parent 
		Optional<Person> opt = personRepo.findById(id);
		
		if(opt.isPresent()) {
			personRepo.delete(opt.get());	//if we delete Person , associated child will be deleted becoz of cascade  
			return "person and its phone numbers are deleted.";
		}else {
			return "person is not present.";
		}	
	}

	@Override
	public String deleteAllPhoneNumbersOfAPerson(Integer id) {
		//load parent 
		Optional<Person> opt = personRepo.findById(id);
		
		if(opt.isPresent()) {
			Person p=opt.get();
			Set<PhoneNumber> phn= p.getPhonesInfo();
			phoneRepo.deleteAll(phn);
			return "all phone numbers of that person is deleted";
		}else {
			return "person is not present.";
		}
	}

}
