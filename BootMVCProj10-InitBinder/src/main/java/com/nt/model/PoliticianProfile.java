package com.nt.model;

import java.util.Date;

import lombok.Data;

@Data
public class PoliticianProfile {
	private String name;
	private String party;
	private Date dob;
	private Date doj;
	private boolean hasConstitutionalPost=false;
}
