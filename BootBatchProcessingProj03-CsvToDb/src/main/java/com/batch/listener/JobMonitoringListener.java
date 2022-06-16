package com.batch.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;


public class JobMonitoringListener implements JobExecutionListener {

	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println(jobExecution.getStartTime()+" : "+jobExecution.getStatus());
		
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println(jobExecution.getEndTime()+" : "+jobExecution.getStatus());
	}

}
