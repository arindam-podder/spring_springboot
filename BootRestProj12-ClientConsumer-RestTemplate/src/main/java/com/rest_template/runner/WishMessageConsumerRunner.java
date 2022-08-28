package com.rest_template.runner;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class WishMessageConsumerRunner implements CommandLineRunner {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public void run(String... args) throws Exception {

		// request to simple get api 
/*		System.out.println("--------------------------------------------------------------");
		
		String serviceUrl = "http://localhost:4040/BootRestProj11-ProviderApplication/wish/message";
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(serviceUrl, String.class);
			
		System.out.println("response body (output) = "+ responseEntity.getBody());
		System.out.println("response header = "+ responseEntity.getHeaders());
		System.out.println("status = "+ responseEntity.getStatusCode() + " , "+responseEntity.getStatusCodeValue());
	
		System.out.println("--------------------------------------------------------------");
*/	
		
		// request to get api with path variables 
/*		System.out.println("--------------------------------------------------------------");
		
		String serviceUrl = "http://localhost:4040/BootRestProj11-ProviderApplication/wish/message/{id}/{name}";
		//ResponseEntity<String> responseEntity = restTemplate.getForEntity(serviceUrl, String.class, Map.of("id",101,"name","Arindam Podder"));
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(serviceUrl, String.class, 101,"Arjun");
		System.out.println("response body (output) = "+ responseEntity.getBody());
		System.out.println("response header = "+ responseEntity.getHeaders());
		System.out.println("status = "+ responseEntity.getStatusCode() + " , "+responseEntity.getStatusCodeValue());
			
		System.out.println("--------------------------------------------------------------");
*/
		
		
		//request to get api using exchange() method 
		System.out.println("--------------------------------------------------------------");
		
		String serviceUrl = "http://localhost:4040/BootRestProj11-ProviderApplication/wish/message";
		ResponseEntity<String> responseEntity = restTemplate.exchange(serviceUrl, 
							  									HttpMethod.GET,
							  									null,	//no body data,no header 
							  									String.class);
		System.out.println("response body (output) = "+ responseEntity.getBody());
		System.out.println("response header = "+ responseEntity.getHeaders());
		System.out.println("status = "+ responseEntity.getStatusCode() + " , "+responseEntity.getStatusCodeValue());
		
		System.out.println("--------------------------------------------------------------");
		
		// request to get api with path variables using exchange() method
		System.out.println("--------------------------------------------------------------");
		
		String serviceUrl1 = "http://localhost:4040/BootRestProj11-ProviderApplication/wish/message/{id}/{name}";
		ResponseEntity<String> responseEntity2 = restTemplate.exchange(serviceUrl1,
																HttpMethod.GET, 
																null, String.class, 
																Map.of("id", 555, "name", "Arindam"));
		System.out.println("response body (output) = "+ responseEntity2.getBody());
		System.out.println("response header = "+ responseEntity2.getHeaders());
		System.out.println("status = "+ responseEntity2.getStatusCode() );
		
		
		System.out.println("--------------------------------------------------------------");
		
	}//run(-) method end
	
}//class end
