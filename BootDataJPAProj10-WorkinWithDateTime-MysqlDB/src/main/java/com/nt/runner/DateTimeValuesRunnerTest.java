package com.nt.runner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Person;
import com.nt.service.IPersonMgntService;

@Component
public class DateTimeValuesRunnerTest implements CommandLineRunner {
	
	@Autowired
	private IPersonMgntService service;
	
	@Override
	public void run(String... args) throws Exception {
		
		//saving(or)registering person
		Person p = new Person();
		p.setName("Raja"); p.setAge(23.5f); p.setDob(LocalDate.of(1998, 10, 30));
		p.setTob(LocalTime.of(14, 33)); p.setDoj(LocalDateTime.of(2022, 12, 15, 10, 30));
//		String result = service.registerPerson(p);
//		System.out.println(result);
		
		
		//retrieve operation
		service.getAllPersonDetails().forEach(System.out::println);
		
	
	}
}
