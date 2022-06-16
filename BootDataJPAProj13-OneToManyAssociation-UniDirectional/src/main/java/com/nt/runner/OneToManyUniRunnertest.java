package com.nt.runner;

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
public class OneToManyUniRunnertest implements CommandLineRunner {

	@Autowired
	private IOneToManyMappingMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
	
		
/*		//prepare child data
		PhoneNumber ph1 = new PhoneNumber();
		ph1.setPhoneNumber(6666666L); ph1.setNumberType("office"); ph1.setProvider("airtel");
		
		PhoneNumber ph2 = new PhoneNumber();
		ph2.setPhoneNumber(99996666L); ph2.setNumberType("home"); ph2.setProvider("jio");
		
		//prepare parent object
		Person p = new Person();
		p.setPname("Arindam Podder"); p.setAddress("Raiganj,WB");
		p.setPhonesInfo(Set.of(ph1,ph2));
		
		try {
			System.out.println(service.saveDataUsingParent(p));
		}catch(Exception e) {
			e.printStackTrace();
		}	*/
		
		//retrieve operation 
/*		List<Person> list = service.getAllPerson();
		list.forEach( per -> { 
						System.out.println("name :- "+per.getPname());
						System.out.println("Address "+per.getAddress());
						Set<PhoneNumber> ph = per.getPhonesInfo();
						System.out.println("contact details :- ");
						ph.forEach( p -> System.out.println(p.getNumberType()+" : "+p.getPhoneNumber()+" : "+p.getProvider()) );
						System.out.println();
					});
				*/
		
		//delete parent and its associate child
/*		String result = service.deleteParentAndItsChild(1001);
		System.out.println(result);		*/
	
		
		//delete all associate child of a parent
		Scanner sc = new Scanner(System.in);
		System.out.println("give person id to delete his all phone number");
		Integer id = sc.nextInt();
		String result = service.deleteAllPhoneNumbersOfAPerson(id);
		System.out.println(result);
	}
}








