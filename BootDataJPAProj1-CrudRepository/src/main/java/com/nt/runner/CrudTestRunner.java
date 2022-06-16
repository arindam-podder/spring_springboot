package com.nt.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Movie;
import com.nt.service.IMovieMgmtService;

@Component
public class CrudTestRunner implements CommandLineRunner{
	
	@Autowired
	private IMovieMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {

/*		System.out.println("===========================================================================");
 		//set movie details
		Movie m= new Movie();
		m.setMid(1);
		m.setMname("83");
		m.setRating(4.1f);
		m.setYear("2021");
	
		//invoke service method
		try {
			System.out.println(service.resisterMovie(m));
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("===========================================================================");
*/
		
/*		System.out.println("===========================================================================");
 		try {
			System.out.println("the number of movies registered in the database => "+service.getNumberOfMovies());
		}catch(Exception e) {
			e.printStackTrace();
		}
 		System.out.println("============================================================================");
*/
		
/*		System.out.println("===========================================================================");
		int mid = 2;    
		try {
			System.out.println("is movie_id ="+mid+" exits or not? => "+service.checkMovieExistOrNotById(mid));
		}catch(Exception e) {
			e.printStackTrace();
		}
 		System.out.println("============================================================================");
*/	
	
/*		System.out.println("============================================================================");
		try {
			Iterable<Movie> list=service.fetchAllMovies();   
			//down-casting
			//List<Movie> list=(List<Movie>)service.fetchAllMovies();  (or)
			//ArrayList<Movie> list = (ArrayList<Movie>)service.fetchAllMovies();
			System.out.println("class name :: "+list.getClass());  //to know which concrete class is present 
			
			System.out.println("all movies are "+service.fetchAllMovies());
			for(Movie m:list)		//enhance for loop 
				System.out.println(m);
			
			//forEach loop of Iterable 
			list.forEach( m->{
				System.out.println(m);
			} );   //or
		
			list.forEach( m-> System.out.println(m) );
			
			
			//list.forEach(System.out::println);
			
			//Arrays.asList(list).stream().forEach(System.out::println);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("============================================================================");
*/

/*		System.out.println("============================================================================");
		try {
			//List<Integer> mids = new ArrayList<Integer>();
			//mids.add(1); mids.add(21);
			//System.out.println("movies by ids are :: "+service.fetchAllMoviesById(mids));
			
			//Iterable<Movie>  movies = service.fetchAllMoviesById(mids);
			//movies.forEach(m-> System.out.println(m) );
			
			//System.out.println("movies by ids are :: "+service.fetchAllMoviesById(List.of(1,21)));  //of() java9 feature
			
			System.out.println("movies by id :: "+service.fetchAllMoviesById(Arrays.asList(1,21,5)));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("============================================================================");
*/		
		
/*		System.out.println("============================================================================");
		try {
			System.out.println("fatch movie by id :: "+service.fetchMovieById(4));
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("============================================================================");
*/
		
/*		System.out.println("============================================================================");
		try {
			//saving bunch of movie
			String result = service.groupMovieRegistration(List.of(new Movie("RRR", "2022", 4.4f),
																	new Movie("Puspa", "2021", 4.1f)
																		));
			System.out.println(result);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("============================================================================");
*/
		
/*		System.out.println("============================================================================");
		try {
			System.out.println(service.updateMovieDetails(555, null, null));
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("============================================================================");
*/		
		
/*		System.out.println("============================================================================");
		try {
			System.out.println(service.updateMovie(new Movie(555, "aa", "2020", 4.3f)));
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("============================================================================");
*/		
		
/*		System.out.println("============================================================================");
		try {
			System.out.println(service.removeMovieById(33));
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("============================================================================");
*/
		
/*		System.out.println("============================================================================");
		try {
			System.out.println(service.removeMovie(new Movie(33, null, null, null)));
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("============================================================================");
*/
		
/*		System.out.println("============================================================================");
		try {
			System.out.println(service.removeAllMovies());
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("============================================================================");
*/	
	
/*		System.out.println("============================================================================");
		try {
			System.out.println(service.removeAllMoviesById(List.of(61,33)) );
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("============================================================================");
*/		
		
/*		System.out.println("============================================================================");
		try {
			System.out.println(service.removeGivenMovies(List.of(new Movie(null, " ","2021",4.1f))) );	//not good, check implementation
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("============================================================================");
*/		
	
	}//run end
}//main end












