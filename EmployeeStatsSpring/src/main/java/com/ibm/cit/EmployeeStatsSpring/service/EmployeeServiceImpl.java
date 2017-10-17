package com.ibm.cit.EmployeeStatsSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.cit.EmployeeStatsSpring.dao.EmployeeDao;
import com.ibm.cit.EmployeeStatsSpring.model.Employee;

@Service(value="employeeService")
@Repository
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	@Qualifier("employeeDao")
	private EmployeeDao employeeDao;

	public Employee getEmpoyee(int id) {
		Employee empl =employeeDao.getEmployee(id);
		return empl;
}
	

	public List<Employee> getEmployeesList(){
		return employeeDao.getEmployeeList();
	}

	public EmployeeStatistics generateNewEmployeesStatistics() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employee> getEmpoyeeFirstName(String firstName) {
		
		return employeeDao.getEmployeeListFirstName(firstName);
	}

	public List<Employee> getEmpoyeeLastName(String lastName) {
		return employeeDao.getEmployeeListLastName(lastName);
	}

	public List<Employee> getEmpoyeeAge(int age) {
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
