package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Movie;
import com.nt.repository.IMovieRepo;


@Component
public class QueryMethodTestRunner implements CommandLineRunner{
	
	@Autowired
	private IMovieRepo movieRepo;
	
	@Override
	public void run(String... args) throws Exception {

		
		System.out.println("====================================================================");
		
//		movieRepo.getMoviesByIdRange(81, 84).forEach(System.out::println);
		
		System.out.println("====================================================================");
		
		List<Movie> list= movieRepo.searchMoviesByMnames("RRR", "Don", "Puspa");
//		list.forEach(System.out::println);
		
		System.out.println("====================================================================");
		
//		movieRepo.getMovieDetailsByRatingRange(3.5f, 4.2f).forEach(record -> System.out.println(record[0]+" "+record[1]+" "+record[2]) );
		
		System.out.println("====================================================================");
		
//		movieRepo.getMoviesNameByYear("2021").forEach(System.out::println);

		System.out.println("====================================================================");
		
//		System.out.println( movieRepo.getMovieDataByName("RRR").toString()  );

		
		System.out.println("====================================================================");

		Object data = movieRepo.fetchMovieDetailsByName("Atrangi re");
		Object[] result = (Object[]) data;
		for(Object obj : result) {
//			System.out.print(obj+" ");
		}
		System.out.println();
		
		System.out.println("====================================================================");

//		System.out.println(  movieRepo.getMovieYearByName("Don")   );
		
		System.out.println("====================================================================");
	
		Object data1 = movieRepo.getAggregateDataOfMovie();
		Object[] arr = (Object[]) data1;
//		System.out.println("max rating : "+arr[0]);
//		System.out.println("min rating : "+arr[1]);
//		System.out.println("avg rating : "+arr[2]);
//		System.out.println("total movie : "+arr[3]);
	
		System.out.println("====================================================================");
	
//		movieRepo.getMaxRatingMovies().forEach(System.out::println);
	
		System.out.println("====================================================================");

//		int res = movieRepo.modifyRatingByMovieName((float)4.9, "RRR");
//		if(res>0) {
//			System.out.println("rating update successfully");
//		}
//		else {
//			System.out.println("update fail, may be Movie not present");
//		}
		System.out.println("====================================================================");
	
		int res = movieRepo.deleteMovieByYear("2011");		
		if(res>0) {
			System.out.println(res+" movies delete  successfully");
		}
		else {
			System.out.println(" Movie not present on that year.");
		}
		
		System.out.println("====================================================================");
	
	}//run end
}//main end












