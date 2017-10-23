package com.ibm.cit.EmployeeStatsSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.cit.EmployeeStatsSpring.service.EmployeeService;

@Controller
@RequestMapping(path="/")
public class EmployeeController {
	@Autowired
	@Qualifier("employeeService")
	private EmployeeService employeeService;
	
	@RequestMapping(path="/home")
	public ModelAndView getEmployeesPage() {
		ModelAndView model = new ModelAndView("home");
		return model;
	}
	@RequestMapping(path="/addEmployee")
	public ModelAndView addEmployeePage() {
		ModelAndView model = new ModelAndView("AddEmployee");
		return model;
	}
	@RequestMapping(path="/allEmployees")
	public ModelAndView allEmployeesPage() {
		ModelAndView model = new ModelAndView("AllEmployees");
		return model;
	}
	
	@RequestMapping(path="/employee")
	public ModelAndView getEmployeePage() {
		ModelAndView model = new ModelAndView("Employee");
		return model;
	}
	@RequestMapping(path="/statistics")
	public ModelAndView getStatisticsPage() {
		ModelAndView model = new ModelAndView("Statistics");
		return model;
	}
	
}
