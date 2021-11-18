package com.cov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cov.beans.Department;
import com.cov.beans.Employee;
import com.cov.exception.InvalidDepartmentIdException;
import com.cov.exception.InvalidEmployeeIdException;
import com.cov.service.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;

	@RequestMapping(value = "regdept", method = RequestMethod.GET)
	public ModelAndView newDepartment() {
		ModelAndView modelAndView = new ModelAndView("regDepartment", "department", new Department());
		return modelAndView;
	}

	@RequestMapping(value = "regdept", method = RequestMethod.POST)
	public ModelAndView saveDepartment(@ModelAttribute Department dept) {
		ModelAndView modelAndView = new ModelAndView("savedDepartment");
		modelAndView.addObject("dept", departmentService.save(dept));
		return modelAndView;
	}

	@RequestMapping("getDepts")
	public ModelAndView findAll() {
		ModelAndView modelAndView = new ModelAndView("showDepartment", "depts", departmentService.findAll());
		return modelAndView;
	}

	@RequestMapping(value = "editDept", method = RequestMethod.GET)
	public ModelAndView editEmp(@RequestParam int id) throws InvalidDepartmentIdException {
		Department deptToEdit = departmentService.findById(id);
		ModelAndView modelAndView = new ModelAndView("editDept", "deptToEdit", deptToEdit);
		return modelAndView;
	}

	@RequestMapping(value = "updateDept", method = RequestMethod.POST)
	public ModelAndView updateEditDept(@ModelAttribute("deptToEdit") Department department)
			throws InvalidDepartmentIdException {
		departmentService.update(department);
		ModelAndView modelAndView = new ModelAndView("redirect:" + "getDepts");
		System.out.println("Employee Updated successfully with id : " + department.getId());
		return modelAndView;
	}

}
