package com.torryharris.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

//	@RequestMapping("/hello") // this is not recommended 
	@GetMapping("/hello")
	public String hello() {
		LOG.info("hello");
		return "Hello world!";
	}

	@GetMapping("/hi")
	public String hi() {
		LOG.info("hi");
		return "Hi! How are you?";
	}

//	@GetMapping("/*")
//	public String page404() {
//		LOG.warn("page404");
//		return "The page you are looking for is not found.";
//	}

}
