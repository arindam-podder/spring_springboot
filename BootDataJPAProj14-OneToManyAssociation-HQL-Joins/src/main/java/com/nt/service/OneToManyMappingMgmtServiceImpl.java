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
	public List<Object[]> getInnerJoinData() {
		return personRepo.innerJoins();
				
	}

	@Override
	public List<Object[]> getLeftJoinData() {
		return personRepo.leftJoins();
	}

	@Override
	public List<Object[]> getRightJoinData() {
		return personRepo.rightJoins();
	}

	//@Override
/*	public List<Object[]> getFullJoinData() {
		return personRepo.fullJoins();
	}	*/

	
	
	

}
