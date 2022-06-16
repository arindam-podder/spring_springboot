package com.nt.runner;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Movie;
import com.nt.repository.IMovieRepo;


@Component
public class QueryMethodTestRunner implements CommandLineRunner{
	
	@Autowired
	private IMovieRepo movieRepo;
	
	@Autowired
	private EntityManager manager;
	
	@Override
	public void run(String... args) throws Exception {

		StoredProcedureQuery procedureQuery = manager.createStoredProcedureQuery("P_GET_MOVIES_BY_YEAR_RANGE", Movie.class);
		procedureQuery.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter(3, Movie.class, ParameterMode.REF_CURSOR);
		
		procedureQuery.setParameter(1, "2010");
		procedureQuery.setParameter(2, "2022");
		
		List<Movie>  list = procedureQuery.getResultList();
		list.forEach(System.out::println);
		
	
		
		//authentication procedure
		StoredProcedureQuery procedure = manager.createStoredProcedureQuery("P_AUTHENTICATION");
		procedure.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		procedure.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		procedure.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);
		
		procedure.setParameter(1, "ARINDAM");
		procedure.setParameter(2, "A1234");
		
		String result = (String) procedure.getOutputParameterValue(3);
		
		System.out.println(result);
		
	}//run end
}//main end












