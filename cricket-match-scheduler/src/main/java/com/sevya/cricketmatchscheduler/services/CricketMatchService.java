package com.sevya.cricketmatchscheduler.services;

import java.util.List;

import com.sevya.cricketmatchscheduler.entities.Team;

public interface CricketMatchService {
	public List<Team> getAllTeam();
	public String getCaptianOfATeam(Integer teamId);
	
}
