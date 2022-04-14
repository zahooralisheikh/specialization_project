package com.torryharris.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torryharris.demo.exception.DepartmentNotFoundException;
import com.torryharris.demo.exception.EmployeeAlreadyExistsException;
import com.torryharris.demo.exception.EmployeeNotFoundException;
import com.torryharris.demo.model.Employee;
import com.torryharris.demo.repository.DepartmentRepository;
import com.torryharris.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	public List<Employee> getAllEmployees() {
		LOG.info("getAllEmployees");

		return employeeRepository.findAll(); // SELECT * FROM ...
	}

	public Employee getEmployeeById(int eid) {
		LOG.info("getEmployeeById");
		Optional<Employee> empOptional = employeeRepository.findById(eid);
		if (empOptional.isPresent())
			return empOptional.get();
		throw new EmployeeNotFoundException();
	}

	public List<Employee> getEmployeeByFirstName(String firstName) {
		LOG.info("getEmployeeByFirstName");
		return employeeRepository.findByFirstName(firstName); // SELECT * FROM ... WHERE ...
	}

	public List<Employee> getEmployeeByCity(String city) {
		LOG.info("getEmployeeByCity");
		return employeeRepository.findByDepartment_City(city); // SELECT * FROM ... WHERE ...
	}

	public Employee addEmployee(Employee emp) {
		LOG.info("addEmployee");
		if (!employeeRepository.existsById(emp.getEmployeeId())) {
			if (emp.getDepartment() == null) {
				return employeeRepository.save(emp);
			} else if (departmentRepository.existsById(emp.getDepartment().getDepartmentId())) {
				return employeeRepository.save(emp);
			} else {
				throw new DepartmentNotFoundException();
			}
		} else {
			throw new EmployeeAlreadyExistsException();
		}
	}

//	public Employee addEmployee(Employee emp) {
//		LOG.info("addEmployee");
//		if (!employeeRepository.existsById(emp.getEmployeeId())) {
//			if (emp.getDepartment() != null && departmentRepository.existsById(emp.getDepartment().getDepartmentId())) 
//				return employeeRepository.save(emp);
//			else
//				throw new DepartmentNotFoundException();
//		} else
//			throw new EmployeeAlreadyExistsException();
//	}

	public Employee updateEmployee(Employee emp) {
		LOG.info("updateEmployee");
		return employeeRepository.save(emp); // UPDATE ...
	}

	public Employee deleteEmployee(int eid) {
		LOG.info("deleteEmployee " + eid);
		employeeRepository.deleteById(eid); // DELETE
		return null;
	}
}

//package com.torryharris.demo.service;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.torryharris.demo.model.Employee;
//import com.torryharris.demo.repository.DepartmentRepository;
//import com.torryharris.demo.repository.EmployeeRepository;
//
//@Service
//public class EmployeeService {
//
//	@Autowired
//	EmployeeRepository employeeRepository;
//
//	@Autowired
//	DepartmentRepository departmentRepository;
//
//	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
//
//	public List<Employee> getAllEmployees() {
//		LOG.info("getAllEmployees");
//
//		return employeeRepository.findAll(); // SELECT * FROM ...
//	}
//
//	public Employee getEmployeeById(int eid) {
//		LOG.info("getEmployeeById");
//		return employeeRepository.findById(eid).get(); // SELECT * FROM ... WHERE ...
//	}
//
//	public List<Employee> getEmployeeByFirstName(String firstName) {
//		LOG.info("getEmployeeByFirstName");
//		return employeeRepository.findByFirstName(firstName); // SELECT * FROM ... WHERE ...
//	}
//
//	public List<Employee> getEmployeeByCity(String city) {
//		LOG.info("getEmployeeByCity");
//		return employeeRepository.findByDepartment_City(city); // SELECT * FROM ... WHERE ...
//	}
//
//	public Employee addEmployee(Employee emp) {
//		LOG.info("addEmployee");
//		if (emp.getDepartment() != null) {
//			if (departmentRepository.existsById(emp.getDepartment().getDepartmentId())) {
//				LOG.info("employee added successfully.");
//				return employeeRepository.save(emp); // INSERT INTO ...
//			} else {
//				LOG.warn("employee was not added because given department id does not exist.");
//				return null;
//			}
//		} else {
//			LOG.info("employee added successfully without department.");
//			return employeeRepository.save(emp); // INSERT INTO ...
//		}
//	}
//
//	public Employee updateEmployee(Employee emp) {
//		LOG.info("updateEmployee");
//		return employeeRepository.save(emp); // UPDATE ...
//	}
//
//	public Employee deleteEmployee(int eid) {
//		LOG.info("deleteEmployee " + eid);
//		employeeRepository.deleteById(eid); // DELETE
//		return null;
//	}
//}

//package com.torryharris.demo.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//
//import com.torryharris.demo.model.Employee;
//
//@Service
//public class EmployeeService {
//
//	public List<Employee> empList = new ArrayList<>();
//
//	{
//		empList.add(new Employee(101, "Sonu", 45000));
//		empList.add(new Employee(102, "Monu", 40000));
//		empList.add(new Employee(103, "Tonu", 50000));
//		empList.add(new Employee(104, "Ponu", 35000));
//		empList.add(new Employee(105, "Gonu", 60000));
//	}
//
//	public List<Employee> getAllEmployees() {
//		System.out.println("getAllEmployees");
//		return empList;
//	}
//
//	public Employee getEmployeeById(int eid) {
//		System.out.println("getEmployeeById");
//		return empList.get(0);
//	}
//
//	public Employee addEmployee(Employee emp) {
//		System.out.println("addEmployee");
//		empList.add(emp);
//		return emp;
//	}
//
//	public Employee updateEmployee(Employee emp) {
//		System.out.println("updateEmployee");
////		empList.add(emp); // dummy code 
//		return emp;
//	}
//
//	public Employee deleteEmployee(int eid) {
//		System.out.println("deleteEmployee " + eid);
////		empList.add(emp); // dummy code 
//		return null;
//	}
//}
