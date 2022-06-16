package com.sevya.cricketmatchscheduler.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sevya.cricketmatchscheduler.dtos.Match;
import com.sevya.cricketmatchscheduler.services.CricketMatchService;

@Controller
@RequestMapping("/cricket")
public class CricketMatchController {

	@Autowired
	private CricketMatchService service;
	
	
	@GetMapping("/schedule")
	public String home(Model model) {
		model.addAttribute("teams", service.getAllTeam());
		return "schedule_form";
	}
	
/*	@PostMapping("/match")
	public String matchDetail(@RequestParam String date,
			@RequestParam("teamA") Integer teamBId, @RequestParam("teamB") Integer teamBID,
			Model model
			) {
		model.addAttribute("date", date);
		model.addAttribute("captain1", service.getCaptianOfATeam(teamAId));
		model.addAttribute("captain2", service.getCaptianOfATeam(teamBId));
		return "match_detail";
	}	*/
	
	@PostMapping("/match")
	public String matchDetail(Match matchDetail, Model model
			) {
		model.addAttribute("date", matchDetail.getDate());
		model.addAttribute("teamACaptain", service.getCaptianOfATeam(matchDetail.getTeamAId()));
		model.addAttribute("teamBCaptain", service.getCaptianOfATeam(matchDetail.getTeamBId()));
		return "match_detail";
	}
	
	
	
}//CricketMatchController end
