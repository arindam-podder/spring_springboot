/*
 * here i used boot given slf4j 
 */

package com.logging.practice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.core.Layout; 

@RestController
public class LoggingPracticeController {

	private static Logger logger = LoggerFactory.getLogger(LoggingPracticeController.class);
	
	
	@RequestMapping("/boot_slf4j")
	public String logging() {

		
		logger.debug("logger debug.");
		logger.trace("logger trace.");
		logger.info("logger info.");
		logger.warn("logger warn.");
		logger.error("logger error.");
		
		
		return "welcome to spring boot logging";
	}
	
}
