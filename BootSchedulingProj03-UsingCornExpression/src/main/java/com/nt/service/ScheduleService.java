package com.nt.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
	
	//in every minute exact 10th sec task execute, then each 4 sec , in a loop
/*	@Scheduled(cron = "10/4 * * * * *")  
	public void cornSchedukeTask() {
		System.out.println("-----------------------------");
		System.out.println("execute ScheduleService.cornSchedukeTask() : "+ new Date());
		System.out.println("-----------------------------");
	}	*/
	
/*	@Scheduled(cron = "5/3 4/1 * * * *")  //analyze corn, up is starting point , down is repetition 
	public void cornSchedukeTask() {
		System.out.println("-----------------------------");
		System.out.println("execute ScheduleService.cornSchedukeTask() : "+ new Date());
		System.out.println("-----------------------------");
	}	*/
	
/*	@Scheduled(cron = "10-20 * * * * *")   
	public void cornSchedukeTask() {
		System.out.println("-----------------------------");
		System.out.println("execute ScheduleService.cornSchedukeTask() : "+ new Date());
		System.out.println("-----------------------------");
	}	*/
	
	
	@Scheduled(cron = "15,17,21 * * * * *")   
	public void cornSchedukeTask() {
		System.out.println("-----------------------------");
		System.out.println("execute ScheduleService.cornSchedukeTask() : "+ new Date());
		System.out.println("-----------------------------");
	}

}





