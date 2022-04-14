package com.torryharris.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

//Java - JUnit, Mockito  
//JavaScript - jasmine 

@SpringBootTest
public class EmployeeControllerTests2 {

	@Autowired
	private EmployeeController employeeController;

	// positive test case
	@Test
	public void testGetEmpById() {
		HttpStatus expected = HttpStatus.OK;
		HttpStatus actual = employeeController.getEmpById(1).getStatusCode(); // 200
		assertEquals(expected, actual);
	}

	// negative test case
	@Test
	public void testGetEmpById2() {
		HttpStatus unexpected = HttpStatus.NOT_FOUND;
		HttpStatus actual = employeeController.getEmpById(1).getStatusCode(); // 200
		assertNotEquals(unexpected, actual);
	}

	@Test
	public void testGetEmpByName() {
		String expected = "Sonu";
		String actual = employeeController.getEmpByFirstName("Sonu").get(0).getFirstName();
		assertEquals(expected, actual);
	}

}
