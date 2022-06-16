package com.nt.runner;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.EmployeeInfo;
import com.nt.service.IEmployeeMgmtService;

@Component
public class CollectionMappingRunnerTest implements CommandLineRunner {

	@Autowired
	private IEmployeeMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		//save operation
/*		try{
			EmployeeInfo empInfo = new EmployeeInfo(null, 
													"Arindam Podder", 
													List.of("kana", "pana"), 
													Set.of(8888888L,9999999L),
													Map.of("Aadhar Card","44455666", "Passport","fg55yuw33")
													);
			
			System.out.println(service.saveEmployee(empInfo));
		}
		catch(Exception e) {
			e.printStackTrace();
		} */
		
		// retrieve operation
		service.getAllEmployee().forEach(System.out::println);
		
	}
}














