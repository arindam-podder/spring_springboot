package com.rest_template.runner;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class PersonResourceConsumRunner implements CommandLineRunner{

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public void run(String... args) throws Exception {
				
		// request to to post api along with json data
/*		System.out.println("---------------------------------------------------------------------");

		String serviceUrl = "http://localhost:4040/BootRestProj11-ProviderApplication/person/save";
		//prepare request header
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		//create data as req body
		String jsonData = "{\"id\":203,\"name\":\"Arindam Podder\",\"age\":24,\"savings\":20000.00}";
		//put header and json dadat in http entity
		HttpEntity<String> entity = new HttpEntity<String>(jsonData, headers);
		
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(serviceUrl, entity, String.class);
		
		System.out.println("respones body(output) "+responseEntity.getBody());
		System.out.println("status : "+responseEntity.getStatusCode());
		System.out.println("response headers : "+ responseEntity.getHeaders());
		
		System.out.println("---------------------------------------------------------------------");
*/
		
		//delete api request
/*		System.out.println("---------------------------------------------------------------------");
	
		String serviceUrl = "http://localhost:4040/BootRestProj11-ProviderApplication/person/delete/{id}";
		restTemplate.delete(serviceUrl, Map.of("id",104));	//delete() has no RT
		System.out.println("delete operation is completed");
		System.out.println("---------------------------------------------------------------------");
*/
		
		//post request using Exchange()
		String serviceUrl = "http://localhost:4040/BootRestProj11-ProviderApplication/person/save";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		//create data as req body
		String jsonData = "{\"id\":203,\"name\":\"Arindam Podder\",\"age\":24,\"savings\":20000.00}";
		//put header and json dadat in http entity
		HttpEntity<String> entity = new HttpEntity<String>(jsonData, headers);
		
		ResponseEntity<String> responseEntity = restTemplate.exchange(serviceUrl, HttpMethod.POST, entity, String.class);
		
		System.out.println("respones body(output) "+responseEntity.getBody());
		System.out.println("status : "+responseEntity.getStatusCode());
		System.out.println("response headers : "+ responseEntity.getHeaders());
	}
	
}//class end




