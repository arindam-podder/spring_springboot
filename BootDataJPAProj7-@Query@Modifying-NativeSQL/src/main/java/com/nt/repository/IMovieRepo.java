package com.nt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Movie;

public interface IMovieRepo extends JpaRepository<Movie, Integer> {
	//this interface just to get proxy class(given by SP boot) implemented our interface having object base 
	   //persistance logic 
	
	
	//*** @query with native sql ***	
	
	@Query( value = "insert into spring_data_movie values(?,?,?,?)", nativeQuery = true)
	@Modifying
	@Transactional
	public abstract int registerMovie(int id, String name, float rating, String year);
	
	
	//db releted sys date (oracle)
	@Query( value = "select sysdate from dual", nativeQuery = true)
	//@Modifying
	//@Transactional
	public abstract String fetchSysDate();
	
	
	//creating temporary table using narive sql
	@Query(value = "create table temp3(col1 number(10))", nativeQuery = true)
	@Modifying
	@Transactional
	public abstract int createTempTable();
	
}//end of interface








