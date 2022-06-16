package com.nt.service;

import java.util.List;

import com.nt.beans.PersonInfo;

public interface IMvcService {
	public abstract PersonInfo getOnePerson();
	public List<PersonInfo> getListOfPerson();
}
