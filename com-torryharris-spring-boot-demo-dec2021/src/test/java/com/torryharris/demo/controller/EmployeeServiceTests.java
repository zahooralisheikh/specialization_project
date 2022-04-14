package com.torryharris.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.torryharris.demo.model.Department;
import com.torryharris.demo.model.Employee;
import com.torryharris.demo.repository.EmployeeRepository;
import com.torryharris.demo.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTests {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceTests.class);

	@InjectMocks
	private EmployeeService service;

	@Mock
	private EmployeeRepository repository;

	private static List<Employee> empList;

	@BeforeAll // always static
	public static void createEmpData() {
		LOG.info("createEmpData");
		empList = new ArrayList<>();
		empList.add(new Employee(101, "Sonu", 25000, new Department(10)));
		empList.add(new Employee(102, "Monu", 35000, new Department(20)));
		empList.add(new Employee(103, "Tonu", 30000, new Department(20)));
	}

	@AfterAll // always static
	public static void removeEmpData() {
		LOG.info("removeEmpData");
		empList = null;
	}

	@BeforeEach // always non static
	public void beforeEachTestCase() {
		LOG.info("beforeEachTestCase");
	}

	@AfterEach // always non static
	public void afterEachTestCase() {
		LOG.info("afterEachTestCase");
	}

	@Test // always non static
	public void testGetAllEmployees() {
		LOG.info("testGetAllEmployees");
		when(repository.findAll()).thenReturn(empList);
		assertEquals(3, service.getAllEmployees().size());
		verify(repository, times(1)).findAll();
	}

	@Test // always non static
	public void testGetAllEmployeesTimes() {
		LOG.info("testGetAllEmployeesTimes");
		when(repository.findAll()).thenReturn(empList);
		service.getAllEmployees();
		service.getAllEmployees();
		service.getAllEmployees();
		verify(repository, times(3)).findAll();
	}

//	@Test
//	public void testGetEmployeeById() {
//		when(repository.findById(102).get()).thenReturn(empList.get(1));
//
//		service.getEmployeeById(102);
//		service.getEmployeeById(102);
//		service.getEmployeeById(102);
//
//		verify(repository, times(3)).findById(102);
//
////		when(repository.findById(101).get()).thenReturn(empList.get(0));
////		assertEquals(101, service.getEmployeeById(101).getEmployeeId());
//	}
}
