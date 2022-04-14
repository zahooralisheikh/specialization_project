package com.torryharris.demo.controller;

//import static org.mockito.Mockito.when;
import org.mockito.Mockito;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.torryharris.demo.model.Department;
import com.torryharris.demo.model.Employee;
import com.torryharris.demo.service.EmployeeService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTests {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeControllerTests.class);

	@Autowired
	MockMvc mockMvc;

	@MockBean
	EmployeeService service;

	public static List<Employee> empList;

	@BeforeAll
	public static void createEmpData() {
		LOG.info("createEmpData");
		empList = new ArrayList<>();
		empList.add(new Employee(101, "Sonu", 25000, new Department(10)));
		empList.add(new Employee(102, "Monu", 35000, new Department(20)));
		empList.add(new Employee(103, "Tonu", 30000, new Department(20)));
	}

	@Test
	public void testGetAllEmployees() throws Exception {
		LOG.info("testGetAllEmployees");
		Mockito.when(service.getAllEmployees()).thenReturn(empList);
		mockMvc.perform(get("/emplist"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", Matchers.hasSize(3)));
	}

}

