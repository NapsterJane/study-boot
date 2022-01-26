package com.study.demo.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.study.demo.ApplicationFilter;

@SuppressWarnings("deprecation")
@Component
public class InterceptorConfig extends WebMvcConfigurerAdapter{
	@Autowired
	ApplicationFilter applicationFilter;
	
	private static final Logger logger = LogManager.getLogger(InterceptorConfig.class);
	
	@Override
	   public void addInterceptors(InterceptorRegistry registry) {
		logger.debug("Config Class");
	      registry.addInterceptor(applicationFilter);
	   }
}
