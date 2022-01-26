package com.study.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/StudyBoot")
public class MainController {
	
	private static final Logger logger = LogManager.getLogger(MainController.class);
	
	@Value("${login.username}")
	private String userName;

	@GetMapping(value = "/hello")
	public String hello() {
		logger.info("hello world page --INFO " + userName);
		logger.debug("hello world page --DEBUG " + userName);
		
		int a = 2;
		if(a == 1)
		throw new RuntimeException();
		
		return "hello";
	}

}
