package com.ibm.cit.EmployeeStatsSpring.controller;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonFormat;
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

	
	@RequestMapping(path = "/employee/add",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		EmployeeService employeeService =getEmployeeService();
		Employee newEmployee = employeeService.addEmployee(employee);
		ResponseEntity<Employee> responseEntity = null;
		if (employee == null) {
			// Logger log = Logger.getLogger(EmployeeResource.class);
			// log.error("Ivalid employee id number provided");
			responseEntity = new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			responseEntity = new ResponseEntity<Employee>(newEmployee, HttpStatus.CREATED);

		}

		return responseEntity;
	}
	
	@RequestMapping(path = "/employee")
	public ModelAndView getEmployeePage() {
		ModelAndView model = new ModelAndView("Employee");
		return model;
	}

	@RequestMapping(path = "/allEmployees")
	public ModelAndView getAllEmployeesPage() {
		ModelAndView model = new ModelAndView("AllEmployees");
		return model;
	}

	@RequestMapping(path = "/employee/employeeList")
	public ResponseEntity<List<Employee>> allEmployees(@RequestParam(value = "start") Long start,
			@RequestParam(value = "size") Long size) {
		int startParam = start.intValue();
		int sizeParam = size.intValue();
		ResponseEntity<List<Employee>> responseEntity = null;
		EmployeeService employeeService = getEmployeeService();
		List<Employee> employeesList = employeeService.getPortionEmployeeList(startParam, sizeParam);
		int employeeCount = employeeService.getEmployeeListSize();
		if (employeesList.size() == 0) {
			responseEntity = new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
		} else {
			Date expirationDate = new Date();
			expirationDate = new Date(expirationDate.getTime() + 15 * 60 * 1000);
		
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Set-Cookie", "employee_count=" +employeeCount +  ";Path=/EmployeeStatsSpring/employee/");
			responseEntity = new ResponseEntity<List<Employee>>(employeesList,headers, HttpStatus.OK);
		}

		return responseEntity;
	}

	private EmployeeService getEmployeeService() {
		ApplicationContext context = contextLoader.getApplicationContext();
		EmployeeService employeeService = context.getBean("employeeService", EmployeeService.class);

		return employeeService;
	}

	@GET
	@RequestMapping(path = "/employee/empl_id={employeeId}")
	@ResponseBody
	public ResponseEntity<Employee> getEmployeeId(@PathVariable("employeeId") Long employeeId) {
		EmployeeService employeeService =getEmployeeService();
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
		EmployeeService employeeService =getEmployeeService();
		List<Employee> employees = employeeService.getEmpoyeeFirstName(first_name);
		ResponseEntity<List<Employee>> responseEntityList = null;
		if (employees == null || employees.size() == 0) {
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
		EmployeeService employeeService =getEmployeeService();
		List<Employee> employees = employeeService.getEmpoyeeLastName(last_name);
		ResponseEntity<List<Employee>> responseEntityList = null;
		if (employees == null || employees.size() == 0) {
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
		EmployeeService employeeService =getEmployeeService();
		List<Employee> employees = employeeService.getEmpoyeeAge(age);
		ResponseEntity<List<Employee>> responseEntityList = null;
		if (employees == null || employees.size() == 0) {
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
		EmployeeService employeeService =getEmployeeService();
		List<Employee> employees = employeeService.getEmpoyeeLengthOfService(service);
		ResponseEntity<List<Employee>> responseEntityList = null;
		if (employees == null || employees.size() == 0) {
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
		ResponseEntity<EmployeeStatistics> responseStatistics = null;
		EmployeeService employeeService =getEmployeeService();
		EmployeeStatistics statistics = employeeService.generateNewEmployeesStatistics();
		responseStatistics = new ResponseEntity<EmployeeStatistics>(statistics, HttpStatus.OK);
		return responseStatistics;
	}

}
