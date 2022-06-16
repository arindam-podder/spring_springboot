package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.nt.entity.Movie;


public interface IMovieRepo extends JpaRepository<Movie, Integer> {
	//this interface just to get proxy class(given by SP boot) implemented our interface having object base 
	   //persistance logic 
	
	
	
	//finder methods
	public abstract List<Movie> findByMnameEquals(String mname);		//1
	public abstract List<Movie> findByMnameIs(String mname);			//2
	public abstract List<Movie> findByMname(String mname);		//3
						//above all 1,2,3 method is similar in functionality and O/P wise 
	
	
	
	public abstract List<Movie> findByMnameStartingWith(String chars);		//sql pattern ::  like '<chars>%'
	
	public abstract List<Movie> findByMnameEndingWith(String chars);		//sql pattern ::  like '%<chars>'
	
	public abstract List<Movie> findByMnameContaining(String chars);		//sql pattern ::  like '%<chars>%'
	
	public abstract List<Movie> findByMnameContainingIgnoreCase(String chars);	 //sql pattern ::like '%<chars>%' , not case sensitive
	
	public abstract List<Movie> findByMnameIgnoreCase(String mname);
	
	public abstract List<Movie> findByMnameLike(String pattern);	//here we have to give pattern
	
	
	//finder method with multiple param(properties) and use of and,or operation
	public abstract Iterable<Movie> findByMidGreaterThanAndRatingIsLessThan(int mid, float rating);
	
	public abstract Iterable<Movie> findByMnameStartingWithOrRatingBetween(String chars, float start, float end);
	
	public abstract Iterable<Movie> findByMnameNotLikeOrYearInOrderByMnameAsc(String pattern, List<String> year);
	
	
	
}
