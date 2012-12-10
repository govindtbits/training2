package com.tbitsglobal;

import java.io.Serializable;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Unique;

@PersistenceCapable(detachable = "false", table = "employee2")
public class Employee implements Serializable{

	private static final long serialVersionUID = 1L;

	@Persistent(primaryKey = "true", valueStrategy = IdGeneratorStrategy.INCREMENT)
	int employeeId;
	
	@Column(name = "address",jdbcType = "VARCHAR")
	String address;

	@Column(name = "mob", jdbcType = "VARCHAR")
	String mob;

	public int getEmployeeId() {
		return employeeId;
	}

	public String getAddress() {
		return address;
	}

	public String getMob() {
		return mob;
	}
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public Employee(String address, String mob) {
		super();
		this.address = address;
		this.mob = mob;
	}

	/*public Employee() {
		super();
		this.employeeId = employeeId;
	}*/

	public Employee() {

	}

}
