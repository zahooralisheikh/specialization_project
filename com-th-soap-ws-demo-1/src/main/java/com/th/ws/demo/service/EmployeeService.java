package com.th.ws.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.th.ws.demo.exception.EmployeeNotFoundException;
import com.th.ws.demo.model.Employee;
import com.th.ws.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired(required = true)
	EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee getEmployeeById(int employeeId) {

		Optional<Employee> empOptional = employeeRepository.findById(employeeId);
		if (empOptional.isPresent())
			return empOptional.get();
		throw new EmployeeNotFoundException("Employee with id " + employeeId + " does not exist.");
	}

	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee updateEmployee(Employee employee) {
		// logic
		Optional<Employee> employeeDb = employeeRepository.findById(employee.getEmployeeId());
		if(employeeDb.isPresent()) {
		Employee employeeUpdate = employeeDb.get();
		employeeUpdate.setSalary(employee.getSalary());
		employeeUpdate.setFirstName(employee.getFirstName());
		}
		return employee;
	}

	public Object deleteEmployee(int employeeId) {
		// logic
		employeeRepository.deleteById(employeeId);
		return null;
	}

}
