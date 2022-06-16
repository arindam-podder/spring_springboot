package com.nt.practice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Component;

import com.nt.entity.Movie;
import com.nt.repository.IMovieRepo;

@Component
public class PracticeCode {
	@Autowired
	private IMovieRepo repo;
	
	
	//** prcatice code for how to use findAll(Sort) and findAll(Pageable) method of PagingAndSorting Repo **  
	
	/*Iterable<T> 	findAll(Sort sort)
	Returns all entities sorted by the given options. */
	public void findAllWithSort() {
	/*	Order order = new Order(Direction.DESC, "mid");
		Sort sort = Sort.by(order);
		Iterable<Movie> movies = repo.findAll(sort);
		movies.forEach(System.out::println);	*/
	
	/*	Sort sort = Sort.by("year");
		Iterable<Movie> movies = repo.findAll(sort);
		movies.forEach(System.out::println);	*/

		Sort sort = Sort.by(Direction.ASC, "rating");
		Iterable<Movie> movies = repo.findAll(sort);
		movies.forEach(System.out::println);	
		
	}
	
	
	
	
/*	Page<T> 	findAll(Pageable pageable)
	Returns a Page of entities meeting the paging restriction provided in the Pageable object.  */
	public void findAllWithPageable() {
	/*	Pageable pageable = PageRequest.of(0, 4);
		Page<Movie> page = repo.findAll(pageable);
		page.forEach(m -> System.out.println(m)); 	*/
		
	/*	Sort sort = Sort.by(Direction.DESC, "mid");
		Pageable pageable = PageRequest.of(1, 3, sort);
		Page<Movie> page = repo.findAll(pageable);
		page.forEach(m -> System.out.println(m)); 	*/
		
		Pageable pageable = PageRequest.of(1, 3, Direction.ASC, "year");
		Page<Movie> page = repo.findAll(pageable);
		List<Movie> list = page.getContent(); 
		list.forEach(System.out::println);
	}
	
	
	
}
