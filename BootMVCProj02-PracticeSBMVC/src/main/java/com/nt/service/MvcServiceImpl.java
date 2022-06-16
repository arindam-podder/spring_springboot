package com.nt.service;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.nt.beans.PersonInfo;

@Service
public class MvcServiceImpl implements IMvcService {
	@Override
	public PersonInfo getOnePerson() {
		String[] names = new String[] {"Arindam", "Subhas", "Naren", "Netaji", "Nibedita" };
		String[] f_names = new String[] {"Ajit", "Dada", "Raja" };
		String[] locations = new String[] {"Delhi", "Kolkata", "Siliguri", "Hydrabad"};
		Random r = new Random();
		return new PersonInfo(names[r.nextInt(names.length)], f_names[r.nextInt(f_names.length)], r.nextInt(30), 
																				locations[r.nextInt(locations.length)]);
	}


	@Override
	public List<PersonInfo> getListOfPerson(){
		return List.of(getOnePerson(), getOnePerson(), getOnePerson());
	}


}//class end
