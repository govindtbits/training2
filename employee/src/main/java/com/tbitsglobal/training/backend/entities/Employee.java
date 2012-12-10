package com.tbitsglobal.training.backend.entities;

import java.io.Serializable;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Unique;

@PersistenceCapable(detachable = "true", table = "employee")
public class Employee implements Serializable
{	
	private static final long serialVersionUID = 1L;
	
	@Persistent(primaryKey = "true", valueStrategy = IdGeneratorStrategy.INCREMENT)
	int employeeId;
	
	@Column(name = "username", jdbcType = "VARCHAR", length = 100)
    @Unique(name = "unique_user")
	String name;

	@Column(name = "designation", jdbcType = "VARCHAR", length = 100)
	String designation;
	
	double salary;
	
	public Employee()
	{
	}

	public Employee(String name, String designation, double salary) {
		super();
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}	
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", designation=" + designation
				+ ", salary=" + salary + "]";
	}	
	
}
