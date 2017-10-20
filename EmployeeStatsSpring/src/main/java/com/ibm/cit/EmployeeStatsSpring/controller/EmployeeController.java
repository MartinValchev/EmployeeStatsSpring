package com.ibm.cit.EmployeeStatsSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.cit.EmployeeStatsSpring.model.Employee;
import com.ibm.cit.EmployeeStatsSpring.service.EmployeeService;

@Controller
@RequestMapping(path="/employees")
public class EmployeeController {
	@Autowired
	@Qualifier("employeeService")
	private EmployeeService employeeService;
	
	@RequestMapping(path="/list")
	public ModelAndView getEmployees() {
		List<Employee> employees= employeeService.getEmployees();
		ModelAndView model = new ModelAndView("home");
		model.addObject("employees", employees);
//		Js
//		model.setView(view);
		return model;
	}
	
}