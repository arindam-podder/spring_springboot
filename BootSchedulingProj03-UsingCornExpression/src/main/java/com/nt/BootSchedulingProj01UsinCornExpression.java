package com.nt;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BootSchedulingProj01UsinCornExpression{

	public static void main(String[] args) {
		SpringApplication.run(BootSchedulingProj01UsinCornExpression.class, args);
		
		System.out.println("Corn app strat : "+ LocalDateTime.now());
		
	}

}