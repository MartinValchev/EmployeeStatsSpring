package com.ibm.cit.EmployeeStatsSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.cit.EmployeeStatsSpring.dao.EmployeeDao;
import com.ibm.cit.EmployeeStatsSpring.model.Employee;
import com.ibm.cit.EmployeeStatsSpring.model.EmployeeStatistics;

@Service(value="employeeService")
public class EmployeeService implements EmployeeStatisticsService {
	@Autowired
	@Qualifier("employeeDao")
	private EmployeeDao employeeDao;

	@Transactional
	public Employee getEmpoyee(int id) {
		return employeeDao.getEmployee(id);
	}
	@Transactional
	public List<Employee> getEmployeesList(){
		return employeeDao.getEmployeeList();
	}
	public EmployeeStatistics generateNewEmployeesStatistics() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employee> getEmpoyeeFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Employee> getEmpoyeeLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Employee> getEmpoyeeAge(int age) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Employee> getEmpoyeeLengthOfService(double lengthOfService) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}
	public int getEmployeeListSize() {
		// TODO Auto-generated method stub
		return 0;
	}
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Employee> getPortionEmployeeList(int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}
	public int getEmployeePages(int pageLimit) {
		// TODO Auto-generated method stub
		return 0;
	}
}
