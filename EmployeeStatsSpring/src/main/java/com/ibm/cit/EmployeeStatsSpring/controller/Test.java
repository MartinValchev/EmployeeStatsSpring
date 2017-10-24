package com.ibm.cit.EmployeeStatsSpring.controller;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.cit.EmployeeStatsSpring.model.Employee;
import com.ibm.cit.EmployeeStatsSpring.service.EmployeeService;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/app-context.xml");
		// ctx.refresh();
		EmployeeService employeeService = ctx.getBean("employeeService", EmployeeService.class);
		List<Employee> employees = employeeService.getEmpoyeeAge(28);
		if (employees != null) {
			for (Employee employee : employees) {
				System.out.println(employee);
			}

		}

	}

}
