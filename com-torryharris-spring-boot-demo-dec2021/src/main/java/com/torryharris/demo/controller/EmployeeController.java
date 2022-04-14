package com.torryharris.demo.controller;

import com.torryharris.demo.model.Employee;
import com.torryharris.demo.service.EmployeeService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// TM Forum Standards 

@RestController
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:8086/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

//	private final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

//	@CrossOrigin(origins = "http://localhost:8086/")
	@GetMapping("/getempbyid/{eid}")
	public ResponseEntity<Employee> getEmpById(@PathVariable(name = "eid") int eid) {
		LOG.info("getEmpById " + eid);
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(eid), HttpStatus.OK);
	}

//	@CrossOrigin(origins = "http://localhost:8086/")
	@GetMapping("/getempbyfirstname/{firstname}")
	public List<Employee> getEmpByFirstName(@PathVariable(name = "firstname") String firstName) {
		LOG.info("getEmpById " + firstName);
		return employeeService.getEmployeeByFirstName(firstName);
	}

	@GetMapping("/getempbycity/{city}")
	public List<Employee> getEmpByCity(@PathVariable(name = "city") String city) {
		LOG.info("getEmpByCity " + city);
		return employeeService.getEmployeeByCity(city);
	}

	@GetMapping("/emplist")
	public List<Employee> empList() {
		LOG.info("empList");
		return employeeService.getAllEmployees();
	}

	@PostMapping("/addemp")
	public ResponseEntity<Employee> addEmp(@RequestBody Employee emp) {
		LOG.info("addEmp " + emp.toString());
		Employee empTemp = employeeService.addEmployee(emp);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee added successfully."); // more can be added
		HttpStatus status = HttpStatus.CREATED;
		return new ResponseEntity<Employee>(empTemp, headers, status);
	}

//	@PostMapping("/addemp")
//	public Employee addEmp(@RequestBody Employee emp) {
//		LOG.info("addEmp " + emp.toString());
//		return employeeService.addEmployee(emp);
//	}

	@PutMapping("/updateemp")
	public Employee updateEmp(@RequestBody Employee emp) {
		LOG.info("updateEmp");
		return employeeService.updateEmployee(emp);
	}

	@DeleteMapping("/deleteemp/{eid}")
	public Employee deleteEmp(@PathVariable(name = "eid") int eid) {
		LOG.info("deleteEmp " + eid);
		return employeeService.deleteEmployee(eid);
	}
}

//package com.torryharris.demo.controller;
//
//import com.torryharris.demo.model.Employee;
//import com.torryharris.demo.service.EmployeeService;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class EmployeeController {
//
//	@Autowired
//	private EmployeeService employeeService;
//
////	private final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);
//	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
//
//	@GetMapping("/getempbyid/{eid}")
//	public Employee getEmpById(@PathVariable(name = "eid") int eid) {
//		LOG.info("getEmpById " + eid);
//		return employeeService.getEmployeeById(eid);
//	}
//
//	@GetMapping("/getempbyfirstname/{firstname}")
//	public List<Employee> getEmpByFirstName(@PathVariable(name = "firstname") String firstName) {
//		LOG.info("getEmpById " + firstName);
//		return employeeService.getEmployeeByFirstName(firstName);
//	}
//
//	@GetMapping("/getempbycity/{city}")
//	public List<Employee> getEmpByCity(@PathVariable(name = "city") String city) {
//		LOG.info("getEmpByCity " + city);
//		return employeeService.getEmployeeByCity(city);
//	}
//
//	@GetMapping("/emplist")
//	public List<Employee> empList() {
//		LOG.info("empList");
//		return employeeService.getAllEmployees();
//	}
//
//	@PostMapping("/addemp")
//	public Employee addEmp(@RequestBody Employee emp) {
//		LOG.info("addEmp " + emp.toString());
//		return employeeService.addEmployee(emp);
//	}
//
//	@PutMapping("/updateemp")
//	public Employee updateEmp(@RequestBody Employee emp) {
//		LOG.info("updateEmp");
//		return employeeService.updateEmployee(emp);
//	}
//
//	@DeleteMapping("/deleteemp/{eid}")
//	public Employee deleteEmp(@PathVariable(name = "eid") int eid) {
//		LOG.info("deleteEmp " + eid);
//		return employeeService.deleteEmployee(eid);
//	}
//}

// json object for /addemp method 

//{
//    "firstName": "Sunil",
//    "salary": 2564578.0,
//    "department": {
//        "departmentId": 35
//    }
//}
