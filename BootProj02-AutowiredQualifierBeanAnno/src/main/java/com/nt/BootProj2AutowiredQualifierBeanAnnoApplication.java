package com.nt;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.nt.sbeans.CurrentDateTime;
import com.nt.sbeans.VehicleService;

@SpringBootApplication
public class BootProj2AutowiredQualifierBeanAnnoApplication {
	
	@Bean("d1")
	public Date getDateTime() {
		Date d = new Date();
		d.setDate(22);
		return d;
	}
	
	@Bean("d2")
	//@Primary
	public Date getDateTime1() {
		return new Date();
	}
	
	
	public static void main(String[] args) {
//		SpringApplication.run(BootProj2AutowiredQualifierBeanAnnoApplication.class, args);
		ApplicationContext ctx = SpringApplication.run(BootProj2AutowiredQualifierBeanAnnoApplication.class, args);
		
		System.out.println("===========================================");
//		CurrentDateTime cdt = ctx.getBean("dateTime", CurrentDateTime.class);
		CurrentDateTime cdt = ctx.getBean( CurrentDateTime.class);
		cdt.now();
		System.out.println("===========================================");
		VehicleService vs = ctx.getBean(VehicleService.class);
		vs.getService();
		System.out.println("===========================================");
		
		
	}
}










