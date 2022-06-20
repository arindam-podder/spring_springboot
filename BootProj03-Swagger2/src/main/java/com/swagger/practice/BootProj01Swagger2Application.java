package com.swagger.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BootProj01Swagger2Application {

	public static void main(String[] args) {
		SpringApplication.run(BootProj01Swagger2Application.class, args);
	}
	
/*	@Bean
	public Docket swaggerConfig() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				//.paths(PathSelectors.ant("/contact/*"))
				.apis(RequestHandlerSelectors.basePackage("com.swagger.practice"))
				.build();
	}	*/

	@Bean
	public Docket swaggerConfig() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				//.paths(PathSelectors.ant("/contact/*"))
				.apis(RequestHandlerSelectors.basePackage("com.swagger.practice"))
				.build()
				.apiInfo(setApiInfo());
	}

	
	private ApiInfo setApiInfo() {
		return new ApiInfo("ContactResource Doc",
				"tseting swagger", 
				"1.0", 
				"url", 
				"AP-8016977044", 
				"licence text", 
				"licenseUrl license url");
	}
	
}

//swagger-ui.html















