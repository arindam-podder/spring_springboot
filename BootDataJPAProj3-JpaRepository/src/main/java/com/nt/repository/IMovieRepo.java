package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.nt.entity.Movie;


public interface IMovieRepo extends JpaRepository<Movie, Integer> {
	//this interface just to get proxy class(given by SP boot) implemented our interface having object base 
	   //persistance logic 
}
