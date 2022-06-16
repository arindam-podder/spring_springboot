package com.nt.runner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Movie;
import com.nt.repository.IMovieRepo;
import com.nt.service.IMovieMgmtService;

@Component
public class CrudTestRunner implements CommandLineRunner{
	
	@Autowired
	private IMovieMgmtService service;
	
//	@Autowired
//	private IMovieRepo movieRepo;
	
	@Override
	public void run(String... args) throws Exception {

/*		System.out.println("====================================================================");
		try {
			//String result = service.removeMoviesById(List.of(55,33));
			//System.out.println(result);
			List<Integer> list = new ArrayList<Integer>();
			list.add(null);
			list.add(62);
			System.out.println(service.removeMoviesById(list));
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("====================================================================");
*/
		
/*		System.out.println("====================================================================");
		try {
			Movie m = new Movie(63, "RRR", "2022", 4.4f);
			List<Movie> list= service.searchMoviesByMovie(m, true, "mid");			//method is not khas 
			System.out.println(list.size());
			list.forEach(System.out::println);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("====================================================================");
*/		
		
		System.out.println("====================================================================");
		try {
			Movie m = service.getMovieById(63);
			System.out.println(m);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("====================================================================");
		
		
	}//run end
}//main end












