package com.nt.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.repository.PhoneNumberRepo;
import com.nt.service.IOneToManyMappingMgmtService;

@Component
public class JoinRunnertest implements CommandLineRunner {

	@Autowired
	private IOneToManyMappingMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
	
		//get join data (inner join)
		System.out.println("INNER JOIN");
		System.out.println("--------------------------------------------------------------");
		service.getInnerJoinData().forEach(arr -> System.out.println(Arrays.toString(arr)));
		System.out.println("--------------------------------------------------------------");
		
		//get data by left join
		System.out.println("LEFT JOIN");
		System.out.println("--------------------------------------------------------------");
		service.getLeftJoinData().forEach(arr -> System.out.println(Arrays.toString(arr)));
		System.out.println("--------------------------------------------------------------");
		
		//get data by left join
		System.out.println("RIGHT JOIN");
		System.out.println("--------------------------------------------------------------");
		service.getRightJoinData().forEach(arr -> System.out.println(Arrays.toString(arr)));
		System.out.println("--------------------------------------------------------------");
		
		//get data by full join
/*		System.out.println("FULL JOIN");
		System.out.println("--------------------------------------------------------------");
		service.getFullJoinData().forEach(arr -> System.out.println(Arrays.toString(arr)));
		System.out.println("--------------------------------------------------------------");
	*/	
		
	}
}








