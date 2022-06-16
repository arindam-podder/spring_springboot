package com.nt.service;

import java.util.List;

import com.nt.entity.Movie;

public interface IMovieMgmtService {
	
	public abstract String removeMoviesById(Iterable<Integer> ids);
	
	public abstract List<Movie> searchMoviesByMovie(Movie movie,boolean asc, String... property);
	
	public abstract Movie getMovieById(Integer id);
	
}
