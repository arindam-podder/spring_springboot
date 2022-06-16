package com.sevya.cricketmatchscheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sevya.cricketmatchscheduler.entities.Player;
import com.sevya.cricketmatchscheduler.entities.Team;
import com.sevya.cricketmatchscheduler.repositories.PlayerRepo;
import com.sevya.cricketmatchscheduler.repositories.TeamRepo;

@SpringBootApplication
public class CricketMatchSchedulerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CricketMatchSchedulerApplication.class, args);
	}

}
