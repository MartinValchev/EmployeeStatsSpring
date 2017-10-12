package com.ibm.EmployeeStatsSpring.resource;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.cit.EmployeeStatsSpring.model.Employee;
import com.ibm.cit.EmployeeStatsSpring.service.EmployeeService;

public class SpringOrmMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext  ctx = new ClassPathXmlApplicationContext("classpath:/database-config.xml");
		ctx.refresh();
		EmployeeService  emplService = ctx.getBean("employeeService",EmployeeService.class);
		// тест get employee by id
/*		Employee empl = emplService.getEmployeeInstance(2);
		System.out.println(empl.getId());
		System.out.println(empl.getEmployeeFirstName());
		System.out.println(empl.getEmployeeLastName());
		System.out.println(empl.getAge());
		System.out.println(empl.getLengthOfService());*/
		List<Employee> employeesList = emplService.getEmployeesList();
		for(Employee empl: employeesList) {
			System.out.println(empl);
		}
	}

}
