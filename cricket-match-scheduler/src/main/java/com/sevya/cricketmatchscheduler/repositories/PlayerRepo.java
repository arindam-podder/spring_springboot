package com.sevya.cricketmatchscheduler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sevya.cricketmatchscheduler.entities.Player;

public interface PlayerRepo extends JpaRepository<Player, Integer> {
	
}
