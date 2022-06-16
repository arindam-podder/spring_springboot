package com.batch.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.batch.listener.JobMonitoringListener;
import com.batch.model.Employee;
import com.batch.processor.EmployeeInfoItemProcessor;

@EnableBatchProcessing
@Configuration
public class BatchConfig {
	
	@Autowired
	private DataSource ds;
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	
	//***cfg item reader (used predefined one to read CSV file - FlatFileItemReader) ***
	//version-1
	@Bean
	public FlatFileItemReader<Employee> getFlatFileItemReader_version1(){
		//create FFIR obj
		FlatFileItemReader<Employee> reader = new FlatFileItemReader<>();
		reader.setResource(new ClassPathResource("emp_info.csv"));
		
		DefaultLineMapper<Employee> defaultLineMapper = new DefaultLineMapper<>();
		
		DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
		delimitedLineTokenizer.setDelimiter(",");
		delimitedLineTokenizer.setNames("empNo","empName","empAddress","empSalary");
		
		BeanWrapperFieldSetMapper<Employee> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
		beanWrapperFieldSetMapper.setTargetType(Employee.class);
		
		//set tokenizer & FieldSetMapper to the LineMapper
		defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);
		defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
		
		//set LineMapper to reader
		reader.setLineMapper(defaultLineMapper);
		
		return reader;
	}
	//version-2
/*	@Bean
	public FlatFileItemReader<Employee> getFlatFileItemReader_version2(){
		FlatFileItemReader<Employee> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource(new ClassPathResource("emp_info.csv"));
		flatFileItemReader.setLineMapper(new DefaultLineMapper<>() {
			{//instance block
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setDelimiter(",");
						setNames("empNo","empName","empAddress","empSalary");
					}
				});
				
				setFieldSetMapper(new BeanWrapperFieldSetMapper<Employee>() {
					{
						setTargetType(Employee.class);
					}
				});
			}
		});
		
		return flatFileItemReader;
	}	*/
	//version-3
/*	@Bean
	public FlatFileItemReader<Employee> getFlatFileItemReader_version3(){
		return new FlatFileItemReaderBuilder<Employee>().name("flatFileItemReader")
							.resource(new ClassPathResource("emp_info.csv"))
							.delimited().delimiter(",")
							.names("empNo","empName","empAddress","empSalary")
							.targetType(Employee.class)
							.build();
	}	*/
	

	
	//***cfg item writer (used predefined one to write into db - JdbcBatchItemWriter) ***
	//version-1
	@Bean
	public JdbcBatchItemWriter<Employee> getJdbcBatchItemWriter_version1(){
		JdbcBatchItemWriter<Employee> jdbcBatchItemWriter = new JdbcBatchItemWriter<>();
		jdbcBatchItemWriter.setDataSource(ds);
		jdbcBatchItemWriter.setSql("INSERT INTO EMPLOYEE VALUES(:empNo, :empName, :empSalary, :empAddress, :grossSalary, :netSalary)");
		jdbcBatchItemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Employee>());
		return jdbcBatchItemWriter;
	}
	//version-2
/*	@Bean
	public JdbcBatchItemWriter<Employee> getJdbcBatchItemWriter_version2(){
		return new JdbcBatchItemWriterBuilder<Employee>()
				.dataSource(ds)
				.sql("INSERT INTO EMPLOYEE VALUES(:empNo, :empName, :empAddress, :empSalary, :grossSalary, :netSalary)")
				.beanMapped()	//this makes to use BeanPropertyItemSqlParameterSourceProvider internally
				.build();
	}	*/
	
	
	
	//***cfgs ItemProcessor (used customized EmployeeInfoItemProcessor ) ***
	@Bean
	public ItemProcessor<Employee, Employee> createItemProcessor(){
		return new EmployeeInfoItemProcessor();
	}
	
	//***cfgs JobExecutionListener (used customized JobMonitoringListener ) ***
	@Bean
	public JobMonitoringListener createListener() {
		return new JobMonitoringListener();
	}
	
	

	//***cfg step object as spring bean***
	@Bean("step1")
	public Step createStep1() {
		return stepBuilderFactory.get("step1")
				.<Employee,Employee>chunk(10)
				.reader(getFlatFileItemReader_version1())
				.writer(getJdbcBatchItemWriter_version1())
				.processor(createItemProcessor())
				.build();
	}
	
	

	//***cfg step object as spring bean***
	@Bean("job1")
	public Job createJob1() {
		return jobBuilderFactory.get("job1")
				.listener(createListener())
				.incrementer(new RunIdIncrementer())
				.start(createStep1())
				.build();
	}
}//class	
	
	
	
	
	
	
	
		
	
	
	
	
	