package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Movie;
import com.nt.repository.IMovieRepo;

@Component
public class FinderMethodTestRunner implements CommandLineRunner{
	
	@Autowired
	private IMovieRepo movieRepo;
	
	@Override
	public void run(String... args) throws Exception {

		System.out.println("====================================================================");
		
		//List<Movie>  listOfMovies =  movieRepo.findByMname("Don");
		//System.out.println(listOfMovies);
		movieRepo.findByMnameEquals("Don").forEach(System.out::println);
		
		System.out.println("====================================================================");
		
		movieRepo.findByMnameIs("RRR").forEach(System.out::println);
		
		System.out.println("====================================================================");
		
		movieRepo.findByMnameStartingWith("Do").forEach(System.out::println);
		
		System.out.println("====================================================================");
		
		movieRepo.findByMnameEndingWith("R").forEach(System.out::println);
		
		System.out.println("====================================================================");
		
		movieRepo.findByMnameContaining("a").forEach(System.out::println);
		
		System.out.println("====================================================================");
	
		movieRepo.findByMnameContainingIgnoreCase("d").forEach(System.out::println);
		
		System.out.println("====================================================================");
		
		movieRepo.findByMnameIgnoreCase("rrr").forEach(System.out::println);
		
		System.out.println("====================================================================");
		
		movieRepo.findByMnameLike("%e%").forEach(System.out::println);
		
		System.out.println("====================================================================");
	
		movieRepo.findByMidGreaterThanAndRatingIsLessThan(80, 4.5f).forEach(System.out::println);
		
		System.out.println("====================================================================");

		movieRepo.findByMnameStartingWithOrRatingBetween("D", 3.5f, 4.0f).forEach(System.out::println);
		
		System.out.println("====================================================================");

		Iterable<Movie> it = movieRepo.findByMnameNotLikeOrYearInOrderByMnameAsc("Do%", List.of("2021","2016","2011","2022"));
		it.forEach(System.out::println);
		
		System.out.println("====================================================================");
	
	}//run end
}//main end












