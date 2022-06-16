package com.nt.runner;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Employee;
import com.nt.entity.Movie;
import com.nt.repository.IMovieRepo;
import com.nt.service.IMovieService;


@Component
public class PlsqlMysqlTestRunner implements CommandLineRunner{
	
	@Autowired
	private IMovieService service;
	
	
	@Override
	public void run(String... args) throws Exception {

		List<Movie> list1 = service.getMoviesByRatingRange(4.0f, 5.0f);
		//list1.forEach(System.out::println);
		
		List<Employee> list2 = service.getEmployeesBySalaryRange(1800.00f, 22000.00f);
		list2.forEach(System.out::println);
		
		
	}//run end
}//main end












