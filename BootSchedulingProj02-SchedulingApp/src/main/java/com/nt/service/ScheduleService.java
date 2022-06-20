package com.nt.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
	
	@Scheduled(initialDelay = 5000, fixedDelay = 2000)
	public void doSchedukeTask() {
		System.out.println("---------------------");
		System.out.println("execute ScheduleService.doSchedukeTask() "+ new Date());
		System.out.println("---------------------");
	}
	
	
	
}
