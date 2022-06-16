package com.nt.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.entity.Employee;
import com.nt.entity.Movie;
import com.nt.repository.IMovieRepo;

@Component
public class MovieServiceImpl implements IMovieService {
	
	@Autowired
	private EntityManager manager;
	
	@Override
	public List<Movie> getMoviesByRatingRange(float r1, float r2) {
		StoredProcedureQuery spq = manager.createStoredProcedureQuery("P_GET_MOVIES_BY_RATING_RANGE", Movie.class);
		//register in param
		spq.registerStoredProcedureParameter(1, Float.class, ParameterMode.IN);
		spq.registerStoredProcedureParameter(2, Float.class, ParameterMode.IN);
		//set value to in param
		spq.setParameter(1, r1);
		spq.setParameter(2, r2);
		
		List<Movie> list = spq.getResultList();
		
		return list;	
	}

	@Override
	public List<Employee> getEmployeesBySalaryRange(float sal1, float sal2) {
		StoredProcedureQuery spq = manager.createStoredProcedureQuery("P_GET_EMP_BY_SAL_RANGE", Employee.class);
		//register in param
		spq.registerStoredProcedureParameter(1, Float.class, ParameterMode.IN);
		spq.registerStoredProcedureParameter(2, Float.class, ParameterMode.IN);
		//set value to in param
		spq.setParameter(1, sal1);
		spq.setParameter(2, sal2);
			
		List<Employee> list = spq.getResultList();
				
		return list;
		
	}
	
	
	
	
}





