package com.ibm.cit.EmployeeStatsSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.cit.EmployeeStatsSpring.dao.EmployeeDao;
import com.ibm.cit.EmployeeStatsSpring.model.Employee;
import com.ibm.cit.EmployeeStatsSpring.model.EmployeeStatistics;

@Service(value = "employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	@Qualifier("employeeDao")
	private EmployeeDao employeeDao;
	
	@Autowired
	@Qualifier("calculations")
	private Calculations calculations;

	public Employee getEmpoyee(int id) {
		Employee empl = employeeDao.getEmployee(id);
		return empl;
	}

	public List<Employee> getEmployeesList() {
		return employeeDao.getEmployeeList();
	}

	public EmployeeStatistics generateNewEmployeesStatistics() {
		List<Employee> employeeeList = employeeDao.getEmployeeList();
		calculations.setListEmployees(employeeeList);
		double avgLengthOfService = calculations.calculateAvgLenghtOfService();
		double employeeAvgAge = calculations.calculateAvgEmpAge();
		double maxLengthOfService = calculations.findMaxLengthOfService();
		String mostCommonChars = calculations.getThreeMostCommonChars();
		EmployeeStatistics empoyeeStatistics = new EmployeeStatistics(employeeAvgAge, mostCommonChars,
				avgLengthOfService, maxLengthOfService);

		return empoyeeStatistics;
	}

	public List<Employee> getEmpoyeeFirstName(String firstName) {

		return employeeDao.getEmployeeListFirstName(firstName);
	}

	public List<Employee> getEmpoyeeLastName(String lastName) {
		return employeeDao.getEmployeeListLastName(lastName);
	}

	public List<Employee> getEmpoyeeAge(double age) {
		return employeeDao.getEmployeeListAge(age);
	}

	public List<Employee> getEmpoyeeLengthOfService(double lengthOfService) {
		return employeeDao.getEmployeeListLength(lengthOfService);
	}

	public List<Employee> getEmployees() {
		return employeeDao.getEmployeeList();
	}

	public int getEmployeeListSize() {

		return employeeDao.getAllEmployeesCount();
	}

	public Employee addEmployee(Employee employee) {

		return employeeDao.addEmployee(employee);
	}

	public List<Employee> getPortionEmployeeList(int offset, int limit) {
		return employeeDao.getPortionEmployeeList(offset, limit);
	}

	public int getEmployeePages(int pageLimit) {
		// TODO Auto-generated method stub
		return 0;
	}
}
