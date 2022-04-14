package com.torryharris.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torryharris.demo.model.Department;
import com.torryharris.demo.service.DepartmentService;

@CrossOrigin(origins = "*")
@RestController
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	@GetMapping("/deplist")
	public ResponseEntity<List<Department>> getAllDeps() {
		return new ResponseEntity<List<Department>>(departmentService.getAllDepartments(), HttpStatus.OK);
	}

}
