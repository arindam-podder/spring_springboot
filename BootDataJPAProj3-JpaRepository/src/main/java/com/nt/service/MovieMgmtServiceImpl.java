package com.nt.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Movie;
import com.nt.repository.IMovieRepo;


@Service("movieService")
public class MovieMgmtServiceImpl implements IMovieMgmtService {

	@Autowired    //inject dynamically generated proxy class object 
	private IMovieRepo movieRepo; 	//has-a property
	
	
	/* void 	deleteAllByIdInBatch(Iterable<ID> ids)
	Deletes the entities identified by the given ids using a single query. */
	@Override
	public String removeMoviesById(Iterable<Integer> ids) {
		List<Movie> list= movieRepo.findAllById(ids);
		long count = list.size();
		movieRepo.deleteAllByIdInBatch(ids);			//delete operation
		return count+" number of movies are deleted.";
	}
	
	
	/* <S extends T>
	List<S> 	findAll(Example<S> example, Sort sort) */
	@Override
	public List<Movie> searchMoviesByMovie(Movie movie, boolean asc, String... property) {
		Example<Movie> exm = Example.of(movie);
		Sort s = Sort.by(asc?Direction.ASC:Direction.DESC, property);
		List<Movie> list = movieRepo.findAll(exm, s);
		return list;
	}
	
	/* T 	getById(ID id)
	Returns a reference to the entity with the given identifier. */
	@Override
	public Movie getMovieById(Integer id) {
		Movie m = movieRepo.getById(id);			//getById need hibernet lazy load permissino , cfg in application.properties
		return m;
	}
	
	
}//end class











