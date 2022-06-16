/*
package com.sevya.cricketmatchscheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sevya.cricketmatchscheduler.entities.Player;
import com.sevya.cricketmatchscheduler.entities.Team;
import com.sevya.cricketmatchscheduler.repositories.TeamRepo;

import net.bytebuddy.agent.builder.AgentBuilder.FallbackStrategy.Simple;

 @Component
public class DbScricpt implements CommandLineRunner {

	@Autowired
	private TeamRepo repo;

	@Override
	public void run(String... args) throws Exception {
		saveData(repo);
	}

	public static void saveData(TeamRepo repo) {

		// teams
		Team ind = new Team();
		ind.setName("India");
		ind.setCode("IND");
		Team eng = new Team();
		eng.setName("England");
		eng.setCode("ENG");
		Team aus = new Team();
		aus.setName("Australia");
		aus.setCode("AUS");
		Team sa = new Team();
		sa.setName("South Africa");
		sa.setCode("SA");
		Team pak = new Team();
		pak.setName("Pakistan");
		pak.setCode("PAK");
		Team nz = new Team();
		nz.setName("New Zealand");
		nz.setCode("NZ");
		Team sl = new Team();
		sl.setName("Sri Lanka");
		sl.setCode("SL");
		Team ban = new Team();
		ban.setName("Bangladesh");
		ban.setCode("BNG");

		// players
		Player rohit = new Player();
		rohit.setName("Rohit Sharma");
		rohit.setSpeciality("Batsman");
		rohit.setIsCaptain(true);
		rohit.setTeam(ind);
		Player virat = new Player();
		virat.setName("Virat Kohli");
		virat.setSpeciality("Batsman");
		virat.setIsViceCaptain(true);
		virat.setTeam(ind);
		Player jasprit = new Player();
		jasprit.setName("Jasprit Bumrah");
		jasprit.setSpeciality("Bowler");
		jasprit.setTeam(ind);
		Player jadeja = new Player();
		jadeja.setName("Rabidra Jadeja");
		jadeja.setSpeciality("All-rounder");
		jadeja.setTeam(ind);
		Player joe = new Player();
		joe.setName("Joe Root");
		joe.setSpeciality("Batsman");
		joe.setIsCaptain(true);
		joe.setTeam(eng);
		Player ben = new Player();
		ben.setName("Ben Stokes");
		ben.setSpeciality("All-rounder");
		ben.setTeam(eng);
		Player jos = new Player();
		jos.setName("Jos Butler");
		jos.setSpeciality("Wicket-kepper");
		jos.setTeam(eng);
		Player aron = new Player();
		aron.setName("Aaron Finch");
		aron.setSpeciality("Batsman");
		aron.setIsCaptain(true);
		aron.setTeam(aus);
		Player smith = new Player();
		smith.setName("Stiven Smith");
		smith.setSpeciality("Batsman");
		smith.setIsViceCaptain(true);
		smith.setTeam(aus);
		Player temba = new Player();
		temba.setName("Temba Bavuma");
		temba.setSpeciality("Batsman");
		temba.setIsCaptain(true);
		temba.setTeam(sa);
		Player kagiso = new Player();
		kagiso.setName("Kagiso Rabada");
		kagiso.setSpeciality("Bowler");
		kagiso.setIsViceCaptain(true);
		kagiso.setTeam(sa);
		Player babar = new Player();
		babar.setName("Babar Azam");
		babar.setSpeciality("Batsman");
		babar.setIsCaptain(true);
		babar.setTeam(pak);
		Player kane = new Player();
		kane.setName("Kane Wiliamson");
		kane.setSpeciality("Batsman");
		kane.setIsCaptain(true);
		kane.setTeam(nz);
		Player chamika = new Player();
		chamika.setName("Chamika Karunaratne");
		chamika.setSpeciality("Batsman");
		chamika.setIsCaptain(true);
		chamika.setTeam(sl);
		Player tamim = new Player();
		tamim.setName("Tamin Iqbal");
		tamim.setSpeciality("Batsman");
		tamim.setIsCaptain(true);
		tamim.setTeam(ban);
		Player saqib = new Player();
		saqib.setName("Saqib Al Hasan");
		saqib.setSpeciality("All-rounder");
		saqib.setIsViceCaptain(true);
		saqib.setTeam(ban);

		// set player to team
		ind.setPlayers(List.of(rohit, virat,jadeja,jasprit));
		eng.setPlayers(List.of(joe, ben,jos));
		aus.setPlayers(List.of(aron,smith));
		sa.setPlayers(List.of(temba,kagiso));
		pak.setPlayers(List.of(babar));
		nz.setPlayers(List.of(kane));
		sl.setPlayers(List.of(chamika));
		ban.setPlayers(List.of(tamim));

		// save team(parent) , player(child) will be saved automatically bcoz of cascade
		repo.saveAll(List.of(eng, ind, aus, sa, pak, nz, sl, ban));
	}

}*/
