package com.ibm.cit.EmployeeStatsSpring.dao;

import java.util.List;

import com.ibm.cit.EmployeeStatsSpring.model.Employee;




public interface EmployeeDao {
	/**
	 * get Employee entity using provided id
	 * 
	 * @param int id
	 * @throws @return
	 *             Employee
	 */
	public Employee getEmployee(int id);
	/**
	 * provides List of Employee instances
	 * 
	 * @param
	 * @throws @return
	 *             List<Employee>
	 */
	public List<Employee> getEmployeeList();
	/**
	 * provides List of Employee instances based on employee age criteria
	 * 
	 * @param int age
	 * @throws @return
	 *             List<Employee>
	 */
	public List<Employee> getEmployeeListAge(int age);
	/**
	 * provides List of Employee instances based on employee first name,offset and elements limit criteria
	 * 
	 * @param String firstName
	 * @throws @return
	 *             List<Employee>
	 */
	public List<Employee> getEmployeeListFirstName(String firstName);
	/**
	 * provides List of Employee instances based on employee last name criteria
	 * 
	 * @param String lastName
	 * @throws @return
	 *             List<Employee>
	 */
	public List<Employee> getEmployeeListLastName(String lastName);

}