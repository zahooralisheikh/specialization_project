package com.example.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.availability.ApplicationAvailabilityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;



@SpringBootApplication
public class ProfileDemoApplication implements CommandLineRunner{
	
	@Autowired
	Environment environment;
    public static final Log LOGGER = LogFactory.getLog(ProfileDemoApplication.class);
    
    
	public static void main(String[] args) {
		
		SpringApplication.run(ProfileDemoApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		LOGGER.info(environment.getProperty("message"));
	}



}
