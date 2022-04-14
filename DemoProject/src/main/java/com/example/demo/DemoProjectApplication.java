package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Caching;
import org.springframework.cache.annotation.EnableCaching;

import com.example.demo.controller.CustomerController;
import com.example.demo.service.CustomerService;

@EnableCaching
@SpringBootApplication
public class DemoProjectApplication implements CommandLineRunner {

	@Autowired
	CustomerController customerController;

	public static void main(String[] args) {
		SpringApplication.run(DemoProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(customerController.getCustomer(0));
		System.out.println(customerController.getCustomer(0));
		

	}

}
