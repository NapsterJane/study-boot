package com.study.demo;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ApplicationFilter implements HandlerInterceptor{

	@Value("${login.username}")
	private String userName;
	
	private static final Logger logger = LogManager.getLogger(ApplicationFilter.class);
	
	 @Override
	   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		 logger.debug("Application Filter");
		 
	     String encoded = request.getHeader("Authorization");
	     String[] userNameAndPwd = null;
	     
	     if(encoded != null && encoded.toLowerCase().startsWith("basic")) {
	    	 String base64Credentials = encoded.substring("Basic".length()).trim();
	    	 byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
	    	 String credentials = new String(credDecoded, StandardCharsets.UTF_8);
	    	 userNameAndPwd = credentials.split(":", 2);
	     }
	     
		 if(userNameAndPwd[0].equals(userName))
			 return true;
		 
		 response.getWriter().write("Invalid Credentials");
		 response.setStatus(401);
	      return false;
	   }
	
}
