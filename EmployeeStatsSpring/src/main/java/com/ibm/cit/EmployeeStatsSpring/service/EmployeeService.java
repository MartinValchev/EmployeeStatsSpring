package com.ibm.cit.EmployeeStatsSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.cit.EmployeeStatsSpring.dao.EmployeeDao;
import com.ibm.cit.EmployeeStatsSpring.model.Employee;

@Service(value="employeeService")
public class EmployeeService {
	@Autowired
	@Qualifier("employeeDao")
	private EmployeeDao employeeDao;

	@Transactional
	public Employee getEmployeeInstance(int id) {
		return employeeDao.getEmployee(id);
	}
}
