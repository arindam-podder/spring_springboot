package com.nt.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.nt.entity.Movie;
import com.nt.view.ResultStaticView;
import com.nt.view.View;


public interface IMovieRepo extends JpaRepository<Movie, Integer> {
	//this interface just to get proxy class(given by SP boot) implemented our interface having object base 
	   //persistance logic 
	
	
	
	//finder methods with static scalar projection
	public abstract Iterable<ResultStaticView> findByMidGreaterThanEqualAndMidIsLessThanEqual(int gtel, int ltel);
	
	public abstract Iterable<ResultStaticView> findByMidInAndRatingGreaterThanEqual(List<Integer> mids, float ratimg );
	
	public abstract Iterable<ResultStaticView> findByYearInOrderByMnameDesc(List<String> years);
	
	
	
	
	//dynamic scalar projection
	public abstract <T extends View> Iterable<T>  findByRatingBetween(float start, float end, Class<T> cls_obj);
	
	
}
