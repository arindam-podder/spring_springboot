package com.batch.runner;

import java.util.Scanner;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CsvToDbUsingDataJpaBatchTest implements CommandLineRunner {

	Scanner sc = new Scanner(System.in);
	
	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private Job job; 
	
	@Override
	public void run(String... args) throws Exception {
		JobParameters jobParameters = new JobParametersBuilder()
										.addLong("sysTime", System.currentTimeMillis())
										.toJobParameters();
	
		while(true) {
			System.out.print("u want to execute this batch ? ('yes' or 'no')");
			String result = sc.nextLine();
			if(result.equalsIgnoreCase("yes")) {
				JobExecution jobExecution = jobLauncher.run(job, jobParameters);
				System.out.println("Job completion status : "+jobExecution.getStatus());
				break;
			}
			else{
				System.out.println("exit app ? ('yes' or 'no')");
				String result1 = sc.nextLine();
				if(result1.equalsIgnoreCase("yes")) {
					break;
				}
				else {
					continue;
				}
			}
			
		}//while end
		
		
		
		
	}

}
