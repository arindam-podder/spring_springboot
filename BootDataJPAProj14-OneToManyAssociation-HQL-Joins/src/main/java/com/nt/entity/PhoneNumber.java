package com.nt.entity;

import java.io.Serializable;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "AM_PHONENUMBERS_DETAILS")
@Setter
@Getter
public class PhoneNumber implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name = "REG_NO")
	private Integer regNo;
	
	@Column(name = "PHONE_NUMBER")
	private Long phoneNumber;
	
	@Column(name = "NUMBER_TYPE", length = 20)
	private String numberType;
	
	@Column(name = "PROVIDER",length = 20 )
	private String provider;
	
	
	@Override
	public String toString() {
		return "PhoneNumber [regNo=" + regNo + ", phoneNumber=" + phoneNumber + ", numberType=" + numberType
				+ ", provider=" + provider + "]";
	}



}










