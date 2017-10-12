package com.ibm.cit.EmployeeStatsSpring.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8510114837159475180L;
	private String employeeFirstName;
	private String employeeLastName;
	private double age;
	private double lengthOfService;

	private int id;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	@Column(name = "first_name")
	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	@Column(name = "last_name")
	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	@Column(name = "age")
	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	@Column(name = "length_of_service")
	public double getLengthOfService() {
		return lengthOfService;
	}

	public void setLengthOfService(double lengthOfService) {
		this.lengthOfService = lengthOfService;
	}

	@Override
	public String toString() {
		return "Employee [employeeFirstName=" + employeeFirstName + ", employeeLastName=" + employeeLastName + ", age="
				+ age + ", lengthOfService=" + lengthOfService + ", id=" + id + ", getEmployeeFirstName()="
				+ getEmployeeFirstName() + ", getEmployeeLastName()=" + getEmployeeLastName() + ", getAge()=" + getAge()
				+ ", getLengthOfService()=" + getLengthOfService() + ", getId()=" + getId() + "]";
	}

	public void setId(int id) {
		this.id = id;
	}
}
