package com.nt.repository;

import org.springframework.data.repository.CrudRepository;

import com.nt.entity.Movie;


public interface IMovieRepo extends CrudRepository<Movie, Integer> {
	//this interface just to get proxy class(given by SP boot) implemented our interface having object base 
	   //persistance logic 
}
