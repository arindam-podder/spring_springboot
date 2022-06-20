package com.nt;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BootSchedulingProj02SchedulingApp {

	public static void main(String[] args) {
		SpringApplication.run(BootSchedulingProj02SchedulingApp.class, args);
		
		System.out.println("app strat : "+ LocalDateTime.now());
		
	}

}