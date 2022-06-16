package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BootDataJpaProj6QueryMethodUseApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(BootDataJpaProj6QueryMethodUseApplication.class, args);
		
//		ApplicationContext context =  SpringApplication.run(BootDataJpaProj6QueryMethodUseApplication.class, args);
//		System.out.println(context.getClass());		//class org.springframework.context.annotation.AnnotationConfigApplicationContext
	}

}
