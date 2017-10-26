package com.ibm.cit.EmployeeStatsSpring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.cit.EmployeeStatsSpring.model.Employee;

@RestController
public class NavigationController {

	@RequestMapping(value ="/home",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Employee> getHomePageNav(){
		 ResponseEntity<Employee> entity = new ResponseEntity<Employee>(HttpStatus.OK);
		return entity;
	}
	
	@RequestMapping(value ="/allEmployees",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Employee> getAllEmployeesPageNav(){
		 ResponseEntity<Employee> entity = new ResponseEntity<Employee>(HttpStatus.OK);
		return entity;
	}
	
}
