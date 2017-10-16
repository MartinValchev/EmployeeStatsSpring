package com.ibm.EmployeeStatsSpring.resource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.cit.EmployeeStatsSpring.model.LoginToken;
import com.ibm.cit.EmployeeStatsSpring.service.UserLoginService;

public class SpringOrmMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/database-config.xml");
		ctx.refresh();
		//EmployeeServiceImpl emplService = ctx.getBean("employeeService", EmployeeServiceImpl.class);
		// тест get employee by id
		/*
		 * Employee empl = emplService.getEmployeeInstance(2);
		 * System.out.println(empl.getId());
		 * System.out.println(empl.getEmployeeFirstName());
		 * System.out.println(empl.getEmployeeLastName());
		 * System.out.println(empl.getAge());
		 * System.out.println(empl.getLengthOfService());
		 */

		/*
		 * List<Employee> employeesList = emplService.getPortionEmployeeList(1, 4);
		 * for(Employee empl: employeesList) { System.out.println(empl);
		 * 
		 * }
		 */
		/*
		 * int employeesCount = emplService.getEmployeeListSize();
		 * System.out.println(employeesCount);
		 */
		/*
		 * Employee empl = new Employee(); empl.setEmployeeFirstName("Stancho");
		 * empl.setEmployeeLastName("Grigorov"); empl.setAge(43);
		 * empl.setLengthOfService(5.4); Employee newEmployee =
		 * emplService.addEmployee(empl); System.out.println(newEmployee.getId());
		 */
		// test get loginToken *********
		UserLoginService loginService = ctx.getBean("loginService", UserLoginService.class);
	LoginToken loginToken = loginService.getLoginToken("cb1beff1-5386-42e8-a169-fe402390d2a2");
		System.out.println(loginToken.getLoginTokenId());
		System.out.println(loginToken.getHashToken());
		System.out.println(loginToken.getExpirationDate());
		
		// test add login
/*		Login login = new Login();
		login.setUsername("plamko");
		login.setPassword("123456");
		Login newLogin = loginService.addUser(login);
		System.out.println(newLogin);*/
	}

}
