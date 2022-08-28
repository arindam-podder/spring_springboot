package com.rest_template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BootRestProj12ClientConsumerRestTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootRestProj12ClientConsumerRestTemplateApplication.class, args);
	}

	
	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
	
}
