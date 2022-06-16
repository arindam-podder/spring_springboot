package com.nt.service;

import com.nt.entity.Movie;

public interface IMovieMgmtService {
	
	public abstract String resisterMovie(Movie movie);
	
	public abstract String groupMovieRegistration(Iterable<Movie> movieList);
	
	public abstract long getNumberOfMovies();
	
	public abstract boolean checkMovieExistOrNotById(Integer mid);
	
	public abstract Iterable<Movie> fetchAllMovies();
	
	public abstract Iterable<Movie> fetchAllMoviesById(Iterable<Integer> mid);
	
	public abstract Movie fetchMovieById(Integer mid);
	
	public abstract String updateMovieDetails(Integer mid, String newYear, Float newRating);		//for partial update of record 
	
	public abstract String updateMovie(Movie movie);		//for full object/record update 
	
	public abstract String removeMovieById(Integer id); 

	public abstract String removeMovie(Movie movie); 

	public abstract String removeAllMovies(); 
	
	public abstract String removeAllMoviesById(Iterable<Integer> ids); 
	
	public abstract String removeGivenMovies(Iterable<Movie> movies);
	
}
