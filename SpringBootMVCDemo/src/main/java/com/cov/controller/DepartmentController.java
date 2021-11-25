package com.cov.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cov.beans.Department;

import com.cov.exception.InvalidDepartmentIdException;

import com.cov.service.DepartmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "API to perform operation on department",description = "This API provides capabilitis to perform different CRUD operation on Department")
@RestController
@RequestMapping("/department")
public class DepartmentController {
	static Logger logger = Logger.getLogger(DepartmentController.class);
	
	@Autowired
	DepartmentService departmentService;

	@GetMapping("/{id}")
	public Department find(@PathVariable int id) throws InvalidDepartmentIdException {
		logger.info("finding a employee with id " + id);
		Department department = departmentService.findById(id);
		logger.info("employee found with id " + id + " is" + department.getName());
		return department;
	}

	@ApiResponses(value = 
		{
				@ApiResponse(code = 200,message = "Successfully received list of department"),
				@ApiResponse(code = 401,message = "You are unauthorized to get list of department"),
				@ApiResponse(code = 403,message = "Forbidden"),
				@ApiResponse(code = 404,message = "Page not found")

		})
	@GetMapping()
	public List<Department> findAll() {
		logger.info("finding all departments");
		List<Department> departments= departmentService.findAll();
		logger.info("all departments are finded");
		return departments;
	}

	@PostMapping()
	public Department insert(@RequestBody Department department) {
		logger.info("inserting a department with " + department.getName());
		  Department department1=departmentService.save(department);
		logger.info("inserted  department with " + department1.getName()+" Id "+department1.getId());
		return department1; 
	}

	@PutMapping()
	public Department edit(@RequestBody Department department) throws InvalidDepartmentIdException {
		logger.info("editing a department with " + department.getName());
		Department department1= departmentService.update(department);
		logger.info("updated a department with name " + department1.getName());
		return department1;
	}

}