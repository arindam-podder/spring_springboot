package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PERSON_WITH_LOB")
public class Person implements Serializable{
	@Id
	@Column(name = "P_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "P_NAME", length = 20)
	private String name;
	
	@Column(name = "IS_MARRIED")
	private boolean isMarried;

	@Column(name = "P_IMAGE")
	@Lob
	private byte[] image;
	
	@Column(name = "P_AUDIO")
	@Lob
	private byte[] personAudio;
	
	@Column(name = "P_RESUME")
	@Lob
	private char[] resume;

}







