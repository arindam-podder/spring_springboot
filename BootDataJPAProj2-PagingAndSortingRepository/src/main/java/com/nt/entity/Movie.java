package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@Entity
@Table(name = "SPRING_DATA_MOVIE")
public class Movie implements Serializable {
	
	@Id
	@Column(name = "MID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer mid;
	
	@Column(name = "MNAME", length = 20)
	private String mname;
	
	@Column(name = "YEAR", length = 20)
	private String  year;
	
	@Column(name = "RATING")
	private Float rating;

	public Movie() {
		
	}
	
	public Movie(String mname, String year, Float rating) {
		this.mname = mname;
		this.year = year;
		this.rating = rating;
	}
	
	
	
}







