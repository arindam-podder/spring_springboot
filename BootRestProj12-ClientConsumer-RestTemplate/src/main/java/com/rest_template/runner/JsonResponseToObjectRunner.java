package com.rest_template.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest_template.model.Person;

@Component
public class JsonResponseToObjectRunner implements CommandLineRunner{

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public void run(String... args) throws Exception {
		
		String serviceUrl = "http://localhost:4040/BootRestProj11-ProviderApplication/person/get/{id}";
		
		ResponseEntity<String> responseEntity = restTemplate.exchange(serviceUrl, HttpMethod.GET, null, String.class, 1043);
		
		System.out.println("respones body (json content) :- "+responseEntity.getBody());
		System.out.println("response status :- "+responseEntity.getStatusCode());
		System.out.println("---------------------------------------------------------------");
		//json content to object (de-serialization)
		ObjectMapper objectMapper = new ObjectMapper();
		Person person = objectMapper.readValue(responseEntity.getBody(), Person.class);
		System.out.println("json to object convertion data :- "+person);
		
		
	}//end run(-)
	
	
}//class end
