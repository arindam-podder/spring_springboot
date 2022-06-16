package com.nt.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Movie;
import com.nt.repository.IMovieRepo;


@Service("movieService")
public class MovieMgmtServiceImpl implements IMovieMgmtService {

	@Autowired    //inject dynamically generated proxy class object 
	private IMovieRepo movieRepo; 	//has-a property
	
	
	/* used save(entityObj) */
	@Override
	public String resisterMovie(Movie movie) {
		System.out.println("resistering movioe");
		System.out.println("InMemoryProxy class name :: "+movieRepo.getClass()+"\n"+Arrays.toString(movieRepo.getClass().getInterfaces()));
		
		//use repo
		System.out.println("before saving :: "+movie);
		//save movie to dbb s/w
		Movie movie1 = movieRepo.save(movie);		//object based persistance operation 
		System.out.println("after saving :: "+movie1);
		
		return "Movie resister with the id value :: "+movie1.getMid();
	}
	
	
	/* used long count() method */ 
	@Override
	public long getNumberOfMovies() {
		return movieRepo.count();         
	}

    /* used boolean existsById(mid) method*/
	@Override
	public boolean checkMovieExistOrNotById(Integer mid) {
		return movieRepo.existsById(mid);
	}

	/* used Iterable<Movie> 	findAll()
	Returns all instances of the type. */
	@Override
	public Iterable<Movie> fetchAllMovies() {
		//System.out.println(movieRepo.findAll().getClass());	//internally gives java.util.ArrayList
		return movieRepo.findAll();
	}

	/* Iterable<T>  findAllById(Iterable<ID> ids)
	Returns all instances of the type T with the given IDs. */
	@Override
	public Iterable<Movie> fetchAllMoviesById(Iterable<Integer> mid) {
		return movieRepo.findAllById(mid);
	}

	/* Optional<T> 	findById(ID id)
	Retrieves an entity by its id. */
	@Override
	public Movie fetchMovieById(Integer mid) {
		//java.util.Optional<Movie> opt = movieRepo.findById(mid);
		//movieRepo.findById(mid).isPresent();
		//if(opt.isPresent()) {
		//	return opt.get();
		//}
		//else {
		//	throw new IllegalArgumentException("record not found.");
		//}
		
		return movieRepo.findById(mid).orElseThrow( ()->new IllegalArgumentException("movie not found with that id="+mid));	
		
		//return movieRepo.findById(mid).orElse(new Movie());
	}

	/* Iterable<S> 	saveAll(Iterable<S> entities)
	Saves all given entities. */
	@Override 
	public String groupMovieRegistration(Iterable<Movie> movieList) {
		Iterable<Movie> savedMovies = movieRepo.saveAll(movieList); 
		List<Integer> listOfId = new ArrayList<Integer>(); 
		if(savedMovies != null && ((List<Movie>)savedMovies).size() > 0) { 
			savedMovies.forEach(m-> { 
				listOfId.add(m.getMid()); }); 
		} 
	  	return "Movies ids = "+listOfId.toString()+", this movies are saved "; 
	 }


	@Override
	public String updateMovieDetails(Integer mid, String newYear, Float newRating) {
		Optional<Movie> opt = movieRepo.findById(mid);
		if(opt.isPresent()) {
			//get the movie
			Movie m = opt.get();
			m.setYear(newYear);			//update new year
			m.setRating(newRating);		//update new rating
			movieRepo.save(m);	//save(-) internally calls merge(-) to update the record
			return "movie with the id("+mid+") is updated successfully.";
		}
		else
			return "movie with the id("+mid+") is not available,so can't perform update operation.";
	}
	
	@Override
	public String updateMovie(Movie movie) {
		Optional<Movie> opt = movieRepo.findById(movie.getMid());
		if(opt.isPresent()) {
			movieRepo.save(movie);		//save(-) internally calls merge(-) to update the record
			return "movie is updated";
		}
		else
			return "Movie(movie with that id) is not available,so can't perform update operation.";			
	}
		
	/* void 	deleteById(ID id)
	Deletes the entity with the given id. */
	@Override
	public String removeMovieById(Integer id) {
		Optional<Movie> opt = movieRepo.findById(id);
		if(opt.isPresent()) {
			movieRepo.deleteById(id);
			return "movie with the id("+id+") deleted";
		}
		else
			return "movie with that id("+id+") not found";
	}
	
	/* void 	delete(T entity)
	Deletes a given entity. */
	@Override
	public String removeMovie(Movie movie) {
		Movie m = movieRepo.findById(movie.getMid()).orElseThrow( ()->new IllegalArgumentException("movie not found") );
		movieRepo.delete(m);
		return "movie deleted";
	}
	
	/* void 	deleteAll()
	Deletes all entities managed by the repository. */
	@Override
	public String removeAllMovies() {
		long movieCount = movieRepo.count();    
		if(movieCount>0) {
			movieRepo.deleteAll();
		}
		return movieCount+" movies record are deleted.";
	}
	
	/* void 	deleteAllById(Iterable<? extends ID> ids)
	Deletes all instances of the type T with the given IDs. */
	@Override
	public String removeAllMoviesById(Iterable<Integer> ids) {
		Iterable<Movie> itr = movieRepo.findAllById(ids);
		int movieCount = ((List<Movie>) itr).size();
		if(ids!=null && ((List<Integer>) ids).size() == movieCount) {
			movieRepo.deleteAllById(ids);
			return ((List<Integer>) ids).size()+" no of records deleted";
		}
		else {
			return "no ids are given to delete OR either all or some ids are not available to delete";
		}
	}
	
	/* void 	deleteAll(Iterable<? extends T> entities)
	Deletes the given entities. */
	@Override
	public String removeGivenMovies(Iterable<Movie> movies) {
		movieRepo.deleteAll(movies);											//not perfectly implememted, plz re try 
		return "given movies deleted";
	}
	
	

}//end class











