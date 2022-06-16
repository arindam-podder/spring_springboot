package com.nt.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "AM_PERSON_DETAILS")
@Setter
@Getter
public class Person {
	public Integer getPid() {
		return pid;
	}


	public void setPid(Integer pid) {
		this.pid = pid;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Set<PhoneNumber> getPhonesInfo() {
		return phonesInfo;
	}


	public void setPhonesInfo(Set<PhoneNumber> phonesInfo) {
		this.phonesInfo = phonesInfo;
	}


	@Id
	@SequenceGenerator(name = "s_gen", initialValue = 1000, allocationSize = 1, sequenceName = "PID_SEQ1" )
	@GeneratedValue(generator = "s_gen", strategy = GenerationType.SEQUENCE)
	private Integer pid;
	
	@Column(length = 20)
	private String pname;
	
	@Column(length = 50)
	private String address;
	
	@OneToMany(targetEntity = PhoneNumber.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSON_ID", referencedColumnName = "PID")
	private Set<PhoneNumber> phonesInfo;
	
	
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", address=" + address + "]";
	}

	

}
