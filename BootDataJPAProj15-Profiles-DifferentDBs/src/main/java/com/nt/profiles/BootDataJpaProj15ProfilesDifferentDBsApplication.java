package com.nt.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nt.profiles.beans.Person;


@SpringBootApplication
public class BootDataJpaProj15ProfilesDifferentDBsApplication implements CommandLineRunner{

	@Autowired
	private Person person; 
	
	public static void main(String[] args) {
		SpringApplication.run(BootDataJpaProj15ProfilesDifferentDBsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("------------------------------------");
		System.out.println("Active person details  :");
		System.out.println(person.toString());
		System.out.println("------------------------------------");
		
	}
}
