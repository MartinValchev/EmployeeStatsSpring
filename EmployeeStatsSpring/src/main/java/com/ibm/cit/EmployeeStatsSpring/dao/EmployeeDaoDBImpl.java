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

	
}
