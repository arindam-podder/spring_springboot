package com.nt.writer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component("personNameWriter")
public class PersonNameWriter implements ItemWriter<String> {

	private static final Logger log =LoggerFactory.getLogger(PersonNameWriter.class); 
	
	public PersonNameWriter() {
		super();
		log.info("PersonNameWriter is executed.");
	}

	@Override
	public void write(List<? extends String> items) throws Exception {
		System.out.println("PersonNameWriter.write()");
		items.forEach(System.out::println);
	}

}//class
