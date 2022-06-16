package com.sevya.cricketmatchscheduler.services.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevya.cricketmatchscheduler.entities.Player;
import com.sevya.cricketmatchscheduler.entities.Team;
import com.sevya.cricketmatchscheduler.repositories.PlayerRepo;
import com.sevya.cricketmatchscheduler.repositories.TeamRepo;
import com.sevya.cricketmatchscheduler.services.CricketMatchService;

@Service
public class CricketMatchServiceImpl implements CricketMatchService {
	
	@Autowired
	private TeamRepo teamRepo;
	@Autowired
	private PlayerRepo playerRepo;
	
	
	@Override
	public List<Team> getAllTeam() {
		return teamRepo.findAll();
	}
	
	
	@Override
	public String getCaptianOfATeam(Integer teamId) {
		Team team = teamRepo.getById(teamId);
		List<Player> players = team.getPlayers();
		for (Player player:players) {
			if(player.getIsCaptain())
				return player.getName();
		}
		return team.getName();
	}
	
	
}
