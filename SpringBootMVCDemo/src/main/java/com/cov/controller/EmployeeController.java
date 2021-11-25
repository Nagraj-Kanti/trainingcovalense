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
import com.cov.beans.Employee;
import com.cov.exception.InvalidEmployeeIdException;
import com.cov.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "API to perform operation on employee",description = "This API provides capabilitis to perform different CRUD operation on Employee")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	static Logger logger = Logger.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/{id}")
	public Employee find(@PathVariable int id) throws InvalidEmployeeIdException {
		logger.info("finding a employee with id " + id);
		Employee employee = employeeService.findById(id);
		logger.info("employee found with id " + id + " is" + employee.getName());
		return employee;
	}

	@ApiResponses(value = 
		{
				@ApiResponse(code = 200,message = "Successfully received list of employee"),
				@ApiResponse(code = 401,message = "You are unauthorized to get list of employee"),
				@ApiResponse(code = 403,message = "Forbidden"),
				@ApiResponse(code = 404,message = "Page not found")

		})
	@GetMapping()
	public List<Employee> findAll() {
		logger.info("finding all employees");
		List<Employee> employees= employeeService.findAll();
		logger.info("all employees are founded");
		return employees;
		
	}

	@PostMapping()
	public Employee insertPerson(@RequestBody Employee employee) {
		logger.info("inserting a employee with " + employee.getName());
		Employee employee1= employeeService.save(employee);
		logger.info("inserted employee with Id "+employee1.getId()+" Name "+ employee1.getName());
		return employee1;

		
	}

	@PutMapping()
	public Employee edit(@RequestBody Employee employee) throws InvalidEmployeeIdException {
		logger.info("editing a employee with " + employee.getName());
	  Employee employee1= employeeService.update(employee);
	  logger.info("updated  employee with id" + employee1.getId()+" name "+employee1.getName());
	  return employee1;
	 }

	@DeleteMapping("/{id}")
	public Employee delete(@PathVariable int id) throws InvalidEmployeeIdException {
		logger.info("deleting a employee with id " + id);
		Employee employee= employeeService.delete(id);
		logger.info("deleted employee with id " + employee.getId()+" Name "+employee.getName());
		return employee;
		
	}
}