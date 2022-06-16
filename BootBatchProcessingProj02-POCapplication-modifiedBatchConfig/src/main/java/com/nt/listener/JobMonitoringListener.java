package com.nt.listener;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;



//@Component("jobMonitoringListener")
public class JobMonitoringListener implements JobExecutionListener {

	private long startTime,endTime;
	
	private static final Logger log =LoggerFactory.getLogger(JobMonitoringListener.class); 
	
	
	public JobMonitoringListener() {
		super();
		log.info("JobMonitoringListener constructor executed.");
	}

	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("job beging at : "+new Date());
		startTime = System.currentTimeMillis();
		System.out.println("job status : "+jobExecution.getStatus());
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("job completed at : "+new Date());
		endTime = System.currentTimeMillis();
		System.out.println("job status :"+jobExecution.getStatus());
		System.out.println("Time taken for job execution : "+(endTime-startTime));
		System.out.println("job exit status : "+jobExecution.getExitStatus());
	}

}//class
