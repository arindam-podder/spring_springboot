package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IMovieRepo;
import com.nt.view.ResultStaticView;
import com.nt.view.ResultView1;
import com.nt.view.ResultView2;


@Component
public class FinderMethodTestRunner implements CommandLineRunner{
	
	@Autowired
	private IMovieRepo movieRepo;
	
	@Override
	public void run(String... args) throws Exception {

		System.out.println("====================================================================");
		
		Iterable<ResultStaticView> data = movieRepo.findByMidGreaterThanEqualAndMidIsLessThanEqual(75, 82);
		data.forEach(result -> System.out.println(result.getMname()+"\t"+result.getYear()) );
		
		System.out.println("====================================================================");

		movieRepo.findByMidInAndRatingGreaterThanEqual( List.of(77,80,81),
									4.2f ).forEach(result-> System.out.println(result.getMname()+"\t"+result.getYear()));
		
		System.out.println("====================================================================");
	
		movieRepo. findByYearInOrderByMnameDesc(List.of("2011","2007")).forEach(result-> System.out.println(result.getMname()+"\t"+result.getYear()));
		
		System.out.println("====================================================================");
		
		
		
		
		//dynamic scalar method calling
		System.out.println("====================================================================");

		Iterable<ResultView1> it1 = movieRepo.findByRatingBetween(3.9f, 4.3f, ResultView1.class);		//see the arg class
		it1.forEach(rv1 -> System.out.println(rv1.getMid()+"  "+rv1.getMname()));	//see o/p
		System.out.println();
		Iterable<ResultView2> it2 = movieRepo.findByRatingBetween(3.9f, 4.3f, ResultView2.class);		//see the arg class
		it2.forEach(rv2 -> System.out.println(rv2.getMname()+"  "+rv2.getYear()+"  "+rv2.getRating()));	//see o/p	
	
		
		System.out.println("====================================================================");
		
	
	}//run end
}//main end












