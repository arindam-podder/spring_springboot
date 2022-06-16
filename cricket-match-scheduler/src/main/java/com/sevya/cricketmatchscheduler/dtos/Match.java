package com.sevya.cricketmatchscheduler.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Match {
	private String date;
	private	Integer teamAId;
	private Integer teamBId;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getTeamAId() {
		return teamAId;
	}
	public void setTeamAId(Integer teamAId) {
		this.teamAId = teamAId;
	}
	public Integer getTeamBId() {
		return teamBId;
	}
	public void setTeamBId(Integer teamBId) {
		this.teamBId = teamBId;
	}
	
	
}
