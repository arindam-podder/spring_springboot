package com.rest.repository;

import org.springframework.data.repository.CrudRepository;

import com.rest.model.Actor;

public interface ActorRepository extends CrudRepository<Actor, Integer> {

}
