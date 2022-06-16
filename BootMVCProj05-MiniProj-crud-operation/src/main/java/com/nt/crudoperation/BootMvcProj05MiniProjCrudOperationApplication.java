package com.nt.crudoperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nt.crudoperation.model.Employee;
import com.nt.crudoperation.repository.EmployeeRepo;

@SpringBootApplication
public class BootMvcProj05MiniProjCrudOperationApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj05MiniProjCrudOperationApplication.class, args);
	
	
	}
	

}
