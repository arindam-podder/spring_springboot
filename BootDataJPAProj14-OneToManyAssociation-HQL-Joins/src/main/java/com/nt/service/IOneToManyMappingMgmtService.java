package com.nt.service;

import java.util.List;

import com.nt.entity.Person;

public interface IOneToManyMappingMgmtService {
	
	public List<Object[]> getInnerJoinData();
	
	public List<Object[]> getLeftJoinData();
	
	public List<Object[]> getRightJoinData();
	
/*	public List<Object[]> getFullJoinData(); */
	
	
}
