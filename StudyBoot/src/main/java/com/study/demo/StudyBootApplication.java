package com.study.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.study.demo.controller.MainController;

@SpringBootApplication
public class StudyBootApplication {
	
	private static final Logger LOGGER = LogManager.getLogger(MainController.class);
	
	public static void main(String[] args) {
		SpringApplication.run(StudyBootApplication.class, args);
		LOGGER.info("info log");
		LOGGER.debug("debug log");
	}

}
