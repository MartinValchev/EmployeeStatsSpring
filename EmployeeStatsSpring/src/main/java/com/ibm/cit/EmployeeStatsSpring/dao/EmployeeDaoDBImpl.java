package com.ibm.cit.EmployeeStatsSpring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.cit.EmployeeStatsSpring.model.Employee;

@Repository("employeeDao")
@Transactional(readOnly = true)
public class EmployeeDaoDBImpl implements EmployeeDao {

	@PersistenceContext
	private EntityManager em;

	public Employee getEmployee(int id) {
		Query query = em.createNamedQuery("Employee.findId", Employee.class);
		query.setParameter("id", id);
		Employee empl = (Employee) query.getResultList().get(0);
		return empl;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeList() {
		List<Employee> employeeList = null;
		Query query = em.createNamedQuery("Employee.findAll", Employee.class);
		employeeList = query.getResultList();
		return employeeList;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeListAge(int age) {
		List<Employee> employeeList = null;
		Query query = em.createNamedQuery("Employee.age", Employee.class);
		employeeList = query.getResultList();
		return employeeList;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeListFirstName(String firstName) {
		List<Employee> employeeList = null;
		Query query = em.createNamedQuery("Employee.firstName", Employee.class);
		String firstNameMod = firstName + '%';
		query.setParameter("firstName", firstNameMod);
		employeeList = query.getResultList();
		return employeeList;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeListLastName(String lastName) {
		List<Employee> employeeList = null;
		Query query = em.createNamedQuery("Employee.lastName", Employee.class);
		String lastNameMod = lastName + '%';
		query.setParameter("lastName", lastNameMod);
		employeeList = query.getResultList();
		return employeeList;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeListLength(double lengthOfService) {
		List<Employee> employeeList = null;
		Query query = em.createNamedQuery("Employee.lengthOfService", Employee.class);
		query.setParameter("lengthOfService", lengthOfService);
		employeeList = query.getResultList();
		return employeeList;
	}

	@Transactional(readOnly = false)
	public Employee addEmployee(Employee employee) {
		em.persist(employee);
		em.flush();
		int id = employee.getId();
		Employee newEmployee = employee;
		newEmployee.setId(id);
		return newEmployee;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getPortionEmployeeList(int offset, int limit) {
		List<Employee> employeeList = null;
		Query query = em.createNamedQuery("Employee.findAll", Employee.class);
		query.setFirstResult((offset - 1) * limit);
		query.setMaxResults(limit);
		employeeList = query.getResultList();
		return employeeList;
	}

	public int getAllEmployeesCount() {
		Query query = em.createNamedQuery("Employee.count", Long.class);
		int employeesCount = ((Long) (query.getResultList().get(0))).intValue();
		return employeesCount;
	}

}
