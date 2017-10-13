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
@NamedQueries({ @NamedQuery(name = "Employee.findAll", query = "select e from Employee e"),
		@NamedQuery(name = "Employee.findId", query = "Select e from Employee e where e.id =:id"),
		@NamedQuery(name = "Employee.firstName", query = "From Employee as empl where empl.employeeFirstName like :firstName"),
		@NamedQuery(name = "Employee.lastName", query = "From Employee as empl where empl.employeeLastName like :lastName"),
		@NamedQuery(name = "Employee.age", query = "Select e from Employee e where e.age =:age"),
		@NamedQuery(name = "Employee.lengthOfService", query = "Select e from Employee e where e.lengthOfService =:lengthOfService"),
		@NamedQuery(name = "Employee.count", query = "select count(*) from Employee empl") })
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
