package com.transbit.persistence.entities;

import java.io.Serializable;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Discriminator;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.DiscriminatorStrategy;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@PersistenceCapable(detachable = "true", table = "employee")
//@Discriminator(strategy = DiscriminatorStrategy.CLASS_NAME, column = "class")
//@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	@Persistent(primaryKey = "true", valueStrategy = IdGeneratorStrategy.INCREMENT)
	int empId;
	
	@Persistent
	@Column(jdbcType = "VARCHAR", length = 100)
	String name;
	
	 public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", Name=" + name + "]";
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}


