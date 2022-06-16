package com.nt.service;

import java.util.List;

import com.nt.entity.Employee;
import com.nt.entity.Movie;

public interface IMovieService {
	public List<Movie> getMoviesByRatingRange(float r1, float r2); 
	
	
	public List<Employee> getEmployeesBySalaryRange(float sal1, float sal2); 
	
}
