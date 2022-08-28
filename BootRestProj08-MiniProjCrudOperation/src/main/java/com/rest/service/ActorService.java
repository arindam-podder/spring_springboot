package com.rest.service;

import com.rest.model.Actor;

public interface ActorService {

	public Actor saveActor(Actor actor);
	
	public java.util.List<Actor> getAllActors();
	
	public void deleteActor(Integer actorId);
	
}
