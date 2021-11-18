package com.cov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home()
	{
		return "Home";
	}
	
	@RequestMapping("/employee")
	public String employee()
	{
		return "employee";
	}
	
	@RequestMapping("/department")
	public String department()
	{
		return "department";
	}
	
	
	
	
	
}
