package com.ibm.cit.EmployeeStatsSpring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ibm.cit.EmployeeStatsSpring.model.Employee;


@Repository
@Qualifier(value="employeeDao")
public class EmployeeDaoDBImpl implements EmployeeDao{
	
	@PersistenceContext
	private EntityManager em;
	
	public Employee getEmployee(int id) {
				
			String employeeQuerry = "Select e from Employee e where e.id =:id";
			Query query =  em.createQuery(employeeQuerry);
			query.setParameter("id", id);
			Employee empl = (Employee) query.getResultList().get(0);
			return empl;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeList() {
		List<Employee> employeeList = null;
		String employeesQuerry = "Select e from Employee e";
		Query query =  em.createQuery(employeesQuerry);
		employeeList = (List<Employee>)query.getResultList();
		return employeeList;
	}

	public List<Employee> getEmployeeListAge(int age) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeListFirstName(String firstName) {
		List<Employee> employeeList = null;
		String employeesQuerry = "From Employee as empl where empl.employeeFirstName like :firstName";
		Query query =  em.createQuery(employeesQuerry);
		String firstNameMod = firstName +'%';
		query.setParameter("firstName", firstNameMod);
		employeeList = query.getResultList();
		return employeeList;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeListLastName(String lastName) {
		List<Employee> employeeList = null;
		String employeesQuerry = "From Employee as empl where empl.employeeLastName like :lastName";
		Query query =  em.createQuery(employeesQuerry);
		String lastNameMod = lastName +'%';
		query.setParameter("lastName", lastNameMod);
		employeeList = query.getResultList();
		return employeeList;
	}

	public List<Employee> getEmployeeListLength(double lengthOfService) {
		List<Employee> employeeList = null;
		String employeesQuerry = "Select e from Employee e where e.lengthOfService =:lengthOfService";
		Query query =  em.createQuery(employeesQuerry);
		query.setParameter("lengthOfService", lengthOfService);
		employeeList = query.getResultList();
		return employeeList;
	}

	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employee> getPortionEmployeeList(int offset, int limit) {
		List<Employee> employeeList = null;
		String employeesQuerry = "Select e from Employee e";
		Query query =  em.createQuery(employeesQuerry);
		query.setFirstResult((offset-1) * limit);
		query.setMaxResults(limit);
		employeeList = (List<Employee>)query.getResultList();
		return employeeList;
	}

	public int getAllEmployeesCount() {
		String employeesQuerry = "select count(*) from Employee empl";
		Query query =  em.createQuery(employeesQuerry,Long.class);
		int employeesCount = ((Long)(query.getResultList().get(0))).intValue();
		return employeesCount;
	}
	

	
}
