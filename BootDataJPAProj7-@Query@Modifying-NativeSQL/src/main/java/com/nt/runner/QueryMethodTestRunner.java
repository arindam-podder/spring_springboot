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
		
		
//		int res = movieRepo.registerMovie(33, "Alvida", 3.3f, "2009");
//		if(res>0) {
//			System.out.println("register successfully.");
//			
//		}
//		else {
//			System.out.println("register fail.sorry");
//		}

		System.out.println("====================================================================");
	
//		System.out.println("oracle db sys date : "+movieRepo.fetchSysDate());
		
		System.out.println("====================================================================");
	
		int res = movieRepo.createTempTable();
		System.out.println(res<0?"table already present":"temp table created");
		
		System.out.println("====================================================================");
		
		
		
		
	}//run end
}//main end












