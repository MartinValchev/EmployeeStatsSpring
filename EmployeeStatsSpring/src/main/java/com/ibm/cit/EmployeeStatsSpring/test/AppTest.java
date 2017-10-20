package com.ibm.cit.EmployeeStatsSpring.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.cit.EmployeeStatsSpring.model.Employee;
import com.ibm.cit.EmployeeStatsSpring.model.EmployeeStatistics;
import com.ibm.cit.EmployeeStatsSpring.service.EmployeeService;

public class AppTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/app-context.xml");
		ctx.refresh();
		System.out.println("Configuration completed");
		//UserLoginService loginService = ctx.getBean("loginService", UserLoginService.class);
		/*LoginToken loginToken = loginService.getLoginToken("cb1beff1-5386-42e8-a169-fe402390d2a2");
			System.out.println(loginToken.getLoginTokenId());
			System.out.println(loginToken.getHashToken());
			System.out.println(loginToken.getExpirationDate());*/
	/*	List<LoginToken> loginTokens = loginService.getAllLoginTokens();
		for(LoginToken loginToken:loginTokens) {
			System.out.println(loginToken.getLoginTokenId());
			System.out.println(loginToken.getHashToken());
			System.out.println(loginToken.getExpirationDate());
		}*/
		
	/*	Login login = loginService.getLogin("todorv", "08f5b04545cbf7eaa238621b9ab84734");
		loginService.addLoginToken("cb1beff1-5386-42e8-a169-fe402390d2a3", new Date(), login);*/
		//loginService.deleteLoginToken("cb1beff1-5386-42e8-a169-fe402390d2a3");
		EmployeeService employeeService =  ctx.getBean("employeeService",EmployeeService.class);
		/*List<Employee> employeeList = employeeService.getPortionEmployeeList(1, 4);
		for(Employee empl: employeeList) {
			System.out.println(empl);
		}*/
		EmployeeStatistics emplStatistics =employeeService.generateNewEmployeesStatistics();
		System.out.println(emplStatistics.toString());
	}

}
