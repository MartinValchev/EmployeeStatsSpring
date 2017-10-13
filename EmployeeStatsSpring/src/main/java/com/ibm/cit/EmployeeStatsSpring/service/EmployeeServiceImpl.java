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
public class EmployeeServiceImpl implements EmployeeService {
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
	@Transactional
	public EmployeeStatistics generateNewEmployeesStatistics() {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	public List<Employee> getEmpoyeeFirstName(String firstName) {
		
		return employeeDao.getEmployeeListFirstName(firstName);
	}
	@Transactional
	public List<Employee> getEmpoyeeLastName(String lastName) {
		return employeeDao.getEmployeeListLastName(lastName);
	}
	@Transactional
	public List<Employee> getEmpoyeeAge(int age) {
		return employeeDao.getEmployeeListAge(age);
	}
	@Transactional
	public List<Employee> getEmpoyeeLengthOfService(double lengthOfService) {
		return employeeDao.getEmployeeListLength(lengthOfService);
	}
	@Transactional
	public List<Employee> getEmployees() {
		return employeeDao.getEmployeeList();
	}
	@Transactional
	public int getEmployeeListSize() {

		return employeeDao.getAllEmployeesCount();
	}
	@Transactional
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	public List<Employee> getPortionEmployeeList(int offset, int limit) {
		return employeeDao.getPortionEmployeeList(offset, limit);
	}
	@Transactional
	public int getEmployeePages(int pageLimit) {
		// TODO Auto-generated method stub
		return 0;
	}
}
