package com.ibm.cit.EmployeeStatsSpring.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.cit.EmployeeStatsSpring.model.LoginToken;
import com.ibm.cit.EmployeeStatsSpring.service.UserLoginService;

public class AppTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/app-context.xml");
		ctx.refresh();
		System.out.println("Configuration completed");
		UserLoginService loginService = ctx.getBean("loginService", UserLoginService.class);
		/*LoginToken loginToken = loginService.getLoginToken("cb1beff1-5386-42e8-a169-fe402390d2a2");
			System.out.println(loginToken.getLoginTokenId());
			System.out.println(loginToken.getHashToken());
			System.out.println(loginToken.getExpirationDate());*/
		List<LoginToken> loginTokens = loginService.getAllLoginTokens();
		for(LoginToken loginToken:loginTokens) {
			System.out.println(loginToken.getLoginTokenId());
			System.out.println(loginToken.getHashToken());
			System.out.println(loginToken.getExpirationDate());
		}
	}

}
