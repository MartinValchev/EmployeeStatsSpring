package com.ibm.cit.EmployeeStatsSpring.controller;

import java.util.List;

import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.cit.EmployeeStatsSpring.model.Employee;
import com.ibm.cit.EmployeeStatsSpring.model.EmployeeStatistics;
import com.ibm.cit.EmployeeStatsSpring.service.EmployeeService;

@RestController
@RequestMapping(path = "/")
public class EmployeeController {

	@Autowired
	@Qualifier("contextLoader")
	ApplicationContextProvider contextLoader;

	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView getEmployeesPage() {
		ModelAndView model = new ModelAndView("home");
		return model;
	}

	@RequestMapping(path = "/addEmployeePage")
	public ModelAndView addEmployeePage() {
		ModelAndView model = new ModelAndView("AddEmployee");
		return model;
	}

	@RequestMapping(path = "/allEmployees")
	public ModelAndView allEmployeesPage() {
		ModelAndView model = new ModelAndView("AllEmployees");
		return model;
	}

	@RequestMapping(path = "/employeePage")
	public ModelAndView getEmployeePage() {
		ModelAndView model = new ModelAndView("Employee");
		return model;
	}

	@GET
	@RequestMapping(path = "/employee/empl_id={employeeId}")
	@ResponseBody
	public ResponseEntity<Employee> getEmployeeId(@PathVariable("employeeId") Long employeeId) {
		ApplicationContext context=  contextLoader.getApplicationContext();
		EmployeeService employeeService = context.getBean("employeeService",
				EmployeeService.class);
		int empId = employeeId.intValue();
		Employee employee = employeeService.getEmpoyee(empId);
		ResponseEntity<Employee> responseEntity = null;
		if (employee == null) {
			// Logger log = Logger.getLogger(EmployeeResource.class);
			// log.error("Ivalid employee id number provided");
			responseEntity = new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		} else {
			responseEntity = new ResponseEntity<Employee>(employee, HttpStatus.OK); 

		}

		return responseEntity;
	}
	@GET
	@RequestMapping(path = "/employee/first_name={first_name}")
	@ResponseBody
	public ResponseEntity<List<Employee>> getEmployeeFirstName(@PathVariable("first_name") String first_name) {
		ApplicationContext context=  contextLoader.getApplicationContext();
		EmployeeService employeeService = context.getBean("employeeService",
				EmployeeService.class);
		List<Employee> employees = employeeService.getEmpoyeeFirstName(first_name);
		ResponseEntity<List<Employee>> responseEntityList = null;
		if (employees == null || employees.size() ==0) {
			// Logger log = Logger.getLogger(EmployeeResource.class);
			// log.error("Ivalid employee id number provided");
			responseEntityList = new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
		} else {
			responseEntityList = new ResponseEntity<List<Employee>>(employees, HttpStatus.OK); 

		}

		return responseEntityList;
	}
	@GET
	@RequestMapping(path = "/employee/last_name={last_name}")
	@ResponseBody
	public ResponseEntity<List<Employee>> getEmployeeLastName(@PathVariable("last_name") String last_name) {
		ApplicationContext context=  contextLoader.getApplicationContext();
		EmployeeService employeeService = context.getBean("employeeService",
				EmployeeService.class);
		List<Employee> employees = employeeService.getEmpoyeeLastName(last_name);
		ResponseEntity<List<Employee>> responseEntityList = null;
		if (employees == null || employees.size() ==0) {
			// Logger log = Logger.getLogger(EmployeeResource.class);
			// log.error("Ivalid employee id number provided");
			responseEntityList = new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
		} else {
			responseEntityList = new ResponseEntity<List<Employee>>(employees, HttpStatus.OK); 

		}

		return responseEntityList;
	}
	@GET
	@RequestMapping(path = "/employee/age={age:.+}")
	@ResponseBody
	public ResponseEntity<List<Employee>> getEmployeeAge(@PathVariable("age") Double age) {
		ApplicationContext context=  contextLoader.getApplicationContext();
		EmployeeService employeeService = context.getBean("employeeService",
				EmployeeService.class);
		List<Employee> employees = employeeService.getEmpoyeeAge(age);
		ResponseEntity<List<Employee>> responseEntityList = null;
		if (employees == null || employees.size() ==0) {
			// Logger log = Logger.getLogger(EmployeeResource.class);
			// log.error("Ivalid employee id number provided");
			responseEntityList = new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
		} else {
			responseEntityList = new ResponseEntity<List<Employee>>(employees, HttpStatus.OK); 

		}

		return responseEntityList;
	}
	
	@GET
	@RequestMapping(path = "/employee/service={service:.+}")
	@ResponseBody
	public ResponseEntity<List<Employee>> getEmployeeLengthOfService(@PathVariable("service") Double service) {
		ApplicationContext context=  contextLoader.getApplicationContext();
		EmployeeService employeeService = context.getBean("employeeService",
				EmployeeService.class);
		List<Employee> employees = employeeService.getEmpoyeeLengthOfService(service);
		ResponseEntity<List<Employee>> responseEntityList = null;
		if (employees == null || employees.size() ==0) {
			// Logger log = Logger.getLogger(EmployeeResource.class);
			// log.error("Invalid employee id number provided");
			responseEntityList = new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
		} else {
			responseEntityList = new ResponseEntity<List<Employee>>(employees, HttpStatus.OK); 

		}

		return responseEntityList;
	}
	
	@RequestMapping(path = "/statistics")
	public ModelAndView getStatisticsPage() {
		ModelAndView model = new ModelAndView("Statistics");
		return model;
	}
	
	@RequestMapping(path = "/employee/stats")
	public ResponseEntity<EmployeeStatistics> getStatistics() {
		ResponseEntity<EmployeeStatistics> responseStatistics=null;
		ApplicationContext context=  contextLoader.getApplicationContext();
		EmployeeService employeeService = context.getBean("employeeService",
				EmployeeService.class);
		EmployeeStatistics statistics =employeeService.generateNewEmployeesStatistics();
		responseStatistics = new ResponseEntity<EmployeeStatistics>(statistics, HttpStatus.OK); 
		return responseStatistics;
	}

}
