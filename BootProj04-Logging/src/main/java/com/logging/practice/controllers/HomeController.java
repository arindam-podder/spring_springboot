/*
 * here i used log4j logging tools, added this jar from maven repository  
 */

package com.logging.practice.controllers;

import java.io.IOException;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.xml.XMLLayout;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	private static Logger logger = Logger.getLogger(HomeController.class);
	
/*	{
		//Layout layout = new SimpleLayout();
		//Layout layout = new HTMLLayout();
		//Layout layout = new XMLLayout();
		Layout layout = new PatternLayout("%d || %p || %C{1}:%L || %M || %m %n");
		
		
		ConsoleAppender consoleAppender = new ConsoleAppender(layout);
		FileAppender fileAppender = null;
		try {
			fileAppender = new FileAppender(layout, "application.log");
		} catch (IOException e) {
			logger.error("file appender has some prob.");
			e.printStackTrace();
		}
		
		logger.addAppender(consoleAppender);
		logger.addAppender(fileAppender);
		logger.setLevel(Level.ALL);		
	}	*/
	
	@GetMapping("/log4j")
	public String logging() {
		logger.trace("log4j logger trace");
		logger.debug("log4j logger debug");
		logger.info("log4j logger info");
		logger.warn("log4j logger warn");
		logger.error("log4j logger error");
		logger.fatal("log4j logger fatal");
		
		
		return "welcome to log4j logging mechanism.";
	}

}
