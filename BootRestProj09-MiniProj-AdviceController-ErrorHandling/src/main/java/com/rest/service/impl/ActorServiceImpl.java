package com.rest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.exception.ActorNotFoundException;
import com.rest.model.Actor;
import com.rest.repository.ActorRepository;
import com.rest.service.ActorService;

@Service
public class ActorServiceImpl implements ActorService {

	@Autowired
	private ActorRepository actorRepository;
	
	@Override
	public Actor saveActor(Actor actor) {
		Actor savedActor = actorRepository.save(actor);
		return savedActor;
	}
	
	@Override
	public List<Actor> getAllActors() {
		List<Actor> actors = new ArrayList<>();
		actorRepository.findAll().forEach( actor -> actors.add(actor) );
		return actors;
	}
	
	@Override
	public void deleteActor(Integer actorId) {
		Optional<Actor> optional = actorRepository.findById(actorId);
		if(optional.isPresent()) {
			actorRepository.deleteById(actorId);
		}else {
			throw new ActorNotFoundException("actor not found with the id="+actorId);
		}
		
	}
	
}











