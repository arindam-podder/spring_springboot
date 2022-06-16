package com.sevya.cricketmatchscheduler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sevya.cricketmatchscheduler.entities.Team;

public interface TeamRepo extends JpaRepository<Team, Integer> {
	
}
