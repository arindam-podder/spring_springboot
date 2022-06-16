package com.nt.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nt.listener.JobMonitoringListener;
import com.nt.processor.PersonNameProcessor;
import com.nt.reader.PersonNameReader;
import com.nt.writer.PersonNameWriter;

@Configuration
//gives spring batch features through auto-configuration, 
//like giving JobBuilderFactory,StepBuilderFactory and etc..
@EnableBatchProcessing
public class BatchConfig {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
//	@Autowired
//	private JobMonitoringListener jobMonitoringListener;
//	@Autowired
//	private PersonNameReader personNameReader;
//	@Autowired
//	private PersonNameProcessor personNameProcessor;
//	@Autowired
//	private PersonNameWriter personNameWriter;
	
	@Bean
	public JobExecutionListener jobListener() {
		return new JobMonitoringListener();
	}
	
	@Bean
	public ItemReader<String> reader(){
		return new PersonNameReader();
	}
	
	@Bean
	public ItemProcessor<String, String> processor(){
		return new PersonNameProcessor(); 
	}
	
	@Bean
	public ItemWriter<String> writer(){
		return new PersonNameWriter();
	}
	
	//create step object using StepBuilderFactory
	@Bean(name = "step1")
	public Step createStep() {
		System.out.println("BatchConfig.createStep()");
		return stepBuilderFactory.get("step1")
							.<String,String>chunk(2) 	//unique generic 
							.reader(reader())
							.processor(processor())
							.writer(writer())
							.build();			
	}
	
	//create job object using JobBuilderFactory
	@Bean(name = "job1")
	public Job createJob() {
		System.out.println("BatchConfig.createJob()");
		return jobBuilderFactory.get("job1")
				.listener(jobListener())
				.incrementer(new RunIdIncrementer())	//check this meaning
				.start(createStep())
				.build();
	}
	
}//class











