package com.tbitsglobal.training.backend.DAO;

import com.tbitsglobal.training.backend.entities.Employee;

public class TestDao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	System.out.println("well come");
	EmployeeDAO.createEmployee(new Employee("govind", "proj eng", 25000d));
	
	System.out.println("done");
	}

}
