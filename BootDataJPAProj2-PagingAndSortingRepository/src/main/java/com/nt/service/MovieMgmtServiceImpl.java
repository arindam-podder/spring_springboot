package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.nt.entity.Movie;
import com.nt.repository.IMovieRepo;

@Service("movieService")
public class MovieMgmtServiceImpl implements IMovieMgmtService {
	
	@Autowired    //inject dynamically generated proxy class object 
	private IMovieRepo movieRepo; 	//has-a property
	
	/* Iterable<T> 	findAll(Sort sort)
	Returns all entities sorted by the given options. */
	@Override
	public Iterable<Movie> displayMoviesByOrder(boolean asc, String... property) {
		Sort s = Sort.by(asc?Direction.ASC:Direction.DESC, property);
		Iterable<Movie> movie = movieRepo.findAll(s);
		return movie;
	}
	
	/* Page<T> 	findAll(Pageable pageable)
	Returns a Page of entities meeting the paging restriction provided in the Pageable object. */
	@Override
	public Page<Movie> generateMovieReport(int pageNo, int pageSize, boolean asc, String... properties) {
		Sort s = Sort.by(asc?Direction.ASC:Direction.DESC, properties);
		//Pageable pageable = PageRequest.of(pageNo, pageSize);
		Pageable pageable = PageRequest.of(pageNo, pageSize, s);
		Page<Movie> page = movieRepo.findAll(pageable);
		return page;
	}
	

}//end class











