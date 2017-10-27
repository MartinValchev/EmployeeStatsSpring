package com.ibm.cit.EmployeeStatsSpring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class LoginController {
	
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public ModelAndView getLoginPage() {
		ModelAndView model = new ModelAndView("login");
		return model;
	}
}
