package com.logging.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:log4j.properties")
public class BootProj01LoggingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootProj01LoggingApplication.class, args);
	}

}
