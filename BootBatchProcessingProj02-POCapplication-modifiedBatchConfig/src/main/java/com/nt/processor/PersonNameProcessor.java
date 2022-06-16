package com.nt.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

//@Component("personNameProcessor")
public class PersonNameProcessor implements ItemProcessor<String, String> {

	private static final Logger log =LoggerFactory.getLogger(PersonNameProcessor.class); 
	
	public PersonNameProcessor() {
		super();
		log.info("PersonNameProcessor constructor executed.");
	}

	@Override
	public String process(String item) throws Exception {
		System.out.println("PersonNameProcessor.process()");
		if(item.equalsIgnoreCase("Kanchan"))
			return "Kanchan  father's name is Goutam.";
		else if(item.equalsIgnoreCase("Sanjoy"))
			return "Sanjoy father's name is Hopna.";
		else if(item.equalsIgnoreCase("Raj"))
			return "Raj father's name is Binod.";
		
		return null;
	}

}//class
