package com.ibm.cit.EmployeeStatsSpring.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.cit.EmployeeStatsSpring.model.Employee;
import com.ibm.cit.EmployeeStatsSpring.service.EmployeeServiceImpl;

// for testing purposes
@Controller
public class EmployeeAppController {
	

	@RequestMapping("/employee")
	public ModelAndView getEmployee() {
		ModelAndView model = new ModelAndView("EmployeeInfo");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/database-config.xml");
		EmployeeServiceImpl  emplService = context.getBean("employeeService",EmployeeServiceImpl.class);
		Employee employee = emplService.getEmpoyee(2);
		model.addObject("employee", employee);
		return model;
	}
}
