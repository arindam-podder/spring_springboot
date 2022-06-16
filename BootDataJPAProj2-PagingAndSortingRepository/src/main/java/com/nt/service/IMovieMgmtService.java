package com.nt.service;

import org.springframework.data.domain.Page;

import com.nt.entity.Movie;

public interface IMovieMgmtService {
	
	public abstract Iterable<Movie> displayMoviesByOrder(boolean asc, String... property);
	
	public abstract Page<Movie> generateMovieReport(int pageNo, int pageSize, boolean asc, String... properties );
}
