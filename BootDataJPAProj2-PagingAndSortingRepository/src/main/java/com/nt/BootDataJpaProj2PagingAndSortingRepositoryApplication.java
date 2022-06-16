package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.practice.PracticeCode;

@SpringBootApplication
public class BootDataJpaProj2PagingAndSortingRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootDataJpaProj2PagingAndSortingRepositoryApplication.class, args);
	
		
		
/*		ApplicationContext ctx = SpringApplication.run(BootDataJpaProj2PagingAndSortingRepositoryApplication.class, args);
		PracticeCode pc = ctx.getBean(PracticeCode.class);
		//pc.findAllWithSort();
		pc.findAllWithPageable();
*/	
	}

}
