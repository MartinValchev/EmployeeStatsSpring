package com.ibm.cit.EmployeeStatsSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	@RequestMapping("/testpage")
	public ModelAndView getTestMessage() {
		
		ModelAndView newModel = new ModelAndView("testpage");
		return newModel;
	}
}
