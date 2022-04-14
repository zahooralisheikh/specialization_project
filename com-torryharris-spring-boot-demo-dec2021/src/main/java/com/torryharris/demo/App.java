package com.torryharris.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	private static final Logger LOG = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
//		System.out.println("Start"); 
		LOG.info("Start");
		SpringApplication.run(App.class, args);
		LOG.info("End");
	}
}
