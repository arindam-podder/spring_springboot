package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
public class BootMvcProj13FileUploadingDownloadingApplication {

	@Bean(name = "multipartResolver")	//fixed bean id
	public CommonsMultipartResolver commonsMultipartResolverCreation() {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setMaxUploadSize(-1); //all file together how much size is allowed -1 indicate no limit
		commonsMultipartResolver.setMaxUploadSizePerFile(10*1024*1024);	//10MB = 10 bytes * 1024 * 1024
		return commonsMultipartResolver;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj13FileUploadingDownloadingApplication.class, args);
	}

}
