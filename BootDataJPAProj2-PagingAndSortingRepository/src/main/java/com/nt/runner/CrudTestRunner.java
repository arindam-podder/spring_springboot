package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Movie;
import com.nt.service.IMovieMgmtService;

@Component("runner")
public class CrudTestRunner implements CommandLineRunner{
	
	@Autowired
	private IMovieMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {

/*		System.out.println("======================================================");
		try {
			Iterable<Movie> m = service.displayMoviesByOrder(true, "mname","year");
			m.forEach(m1 -> System.out.println(m1));
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("======================================================");
*/
		
		System.out.println("======================================================");
		try {
			 Page<Movie> page = service.generateMovieReport(0, 2, true, "mid");         
			 //page.forEach(p-> System.out.println(p));
			 System.out.println("page number :: "+page.getNumber());						//find more on Page<T>				
			 System.out.println("page count ::"+page.getTotalPages());
			 System.out.println("each page size :: "+page.getSize());
			 System.out.println("total element persent in the page :: "+page.getNumberOfElements());
			 List<Movie> listMovie = page.getContent();
			 listMovie.forEach(System.out::println);
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("======================================================");
		
		
		
		
		
		
	}//run end
}//main end












