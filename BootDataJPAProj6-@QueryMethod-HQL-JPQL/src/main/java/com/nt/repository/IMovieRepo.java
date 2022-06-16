package com.nt.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Movie;

public interface IMovieRepo extends JpaRepository<Movie, Integer> {
	//this interface just to get proxy class(given by SP boot) implemented our interface having object base 
	   //persistance logic 
	
	
	
	// ***** @Query method use  ******
	//------------------------------------
	
	//@Query("FROM Movie where mid>=?1 and mid<=?2")
	@Query("FROM Movie where mid>=:min and mid<=:max")
	//public abstract List<Movie> getMoviesByIdRange( @Param("min") int start, @Param("max") int end); 
	public abstract List<Movie> getMoviesByIdRange(int min, int max); 
	
	
	@Query("from Movie where mname in(:name1, :name2, :name3) order by mname ")
	//@Query("from Movie where mname in(?1, ?2, ?3) order by mname ")
	public abstract List<Movie> searchMoviesByMnames(String name1 , String name2, String name3);
	
	
	
	
	//scalar operation 
	
	//specific multiple column with multiple record
	//-------------------------------------------------------
	@Query("select mid,mname,year from Movie where rating>=:start and rating<=:end")
	public abstract List<Object[]> getMovieDetailsByRatingRange(Float start, Float end);
	
	//specific single column with multiple record 
	@Query("select mname from Movie where year=?1")
	public abstract List<String> getMoviesNameByYear(String year);
	
	
	//single row entity data (when u sure single row is coming and all column value )
	@Query("from Movie where mname=:name")	//assume mname is unique
	public abstract Movie getMovieDataByName(String name); 
	
	//specific multiple column with single row	(return type is tricky one , plz remember)
	@Query("select mid,rating,year from Movie where mname=:name")
	public abstract Object fetchMovieDetailsByName(String name);
	
	//single row with single column
	@Query("select year from Movie where mname=:name")
	public abstract String getMovieYearByName(String name);
	
	
	
	
	//aggregate function using hql/jpql
	@Query("select max(rating),min(rating),avg(rating),count(*) from Movie")
	public abstract Object getAggregateDataOfMovie();
	
	
	//sub queries using hql/jpql
	@Query("from Movie where rating=(select max(rating) from Movie)")
	public abstract List<Movie> getMaxRatingMovies();
	
	
	
	
	//*** non-select operation usig @Query + @Modifying *** (need transactional environment , plz remmeber that)
	
	@Query("update Movie set rating=?1 where mname=?2")
	@Modifying
	@Transactional
	public abstract int modifyRatingByMovieName(float rating ,String name);
	
	
	@Query("delete from Movie where year=:year")
	@Modifying
	@Transactional
	public abstract int deleteMovieByYear(String year);
	 
	
	
}//end of interface








