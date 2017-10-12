package com.ibm.cit.EmployeeStatsSpring.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.cit.EmployeeStatsSpring.model.Employee;

// for testing purposes
@Controller
public class EmployeeAppController {
	@RequestMapping("/employee")
	public ModelAndView getEmployee() {
		ModelAndView model = new ModelAndView("EmployeeInfo");
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
		Employee employee1 = context.getBean("employee1", Employee.class);
		model.addObject("employee", employee1);
		return model;
	}
}
