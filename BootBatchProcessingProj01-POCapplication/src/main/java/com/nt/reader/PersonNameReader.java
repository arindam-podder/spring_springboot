package com.nt.reader;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component("personNameReader")
public class PersonNameReader implements ItemReader<String> {

	private static final Logger log =LoggerFactory.getLogger(PersonNameReader.class); 
	
	List<String> names = List.of("Kanchan", "Sanjoy", "Raj", "");
	private static int count = 0;
	
	public PersonNameReader() {
		super();
		log.info("PersonNameReader constructor executed.");
	}

	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.out.println("NameReader.read()");
		if(count<names.size())
			return names.get(count++);
		return null;
	}

}//class
