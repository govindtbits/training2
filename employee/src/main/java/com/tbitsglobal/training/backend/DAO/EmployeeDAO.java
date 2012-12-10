package com.tbitsglobal.training.backend.DAO;

import javax.jdo.*;
import java.util.*;

import com.tbitsglobal.training.backend.entities.*;


public class EmployeeDAO {

	static PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	static PersistenceManager pm = pmf.getPersistenceManager();
	
	public static Employee createEmployee(Employee emp)
	{
		Transaction tx=pm.currentTransaction();
		try
		{
		    tx.begin();
		    emp = pm.detachCopy(pm.makePersistent(emp));
		    tx.commit();
		    
		}
		finally
		{
			if (tx.isActive())
		    {
		        tx.rollback();
		    }
		    //pm.close();
		}
		return emp;
	}
	
	public static ArrayList<Employee> readEmployee(Employee emp)
	{
		Transaction tx = pm.currentTransaction();
		ArrayList<Employee> t1 = new ArrayList();
		try
		{
			tx.begin();
			 Query q = pm.newQuery(Employee.class,"employeeId== " + emp.getEmployeeId());
			 System.out.println(emp.getEmployeeId());
			 List<Employee> e1 = (List<Employee>)pm.detachCopyAll((List<Employee>)q.execute());
			 Iterator<Employee> iter = e1.iterator();
			  while (iter.hasNext())
			    {
			        Employee e = iter.next();
			        System.out.println(e.toString());
			    }
			tx.commit();
		}
		finally
		{
			 if (tx.isActive())
			    {
			        tx.rollback();
			    }

			    pm.close();
		}
		return t1;
	}
	public static void deleteEmployee(Employee emp)
	{
		Transaction tx = pm.currentTransaction();
		try
		{
		    tx.begin();
		    Query q = pm.newQuery(Employee.class,"employeeId== " + emp.getEmployeeId() );
		    List<Employee> e1 = (List<Employee>) q.execute();
		    pm.deletePersistentAll(e1);
		    
		    tx.commit();
		}
		finally
		{
		    if (tx.isActive())
		    {
		        tx.rollback();
		    }

		    pm.close();
		}
	}
	public static void updateEmployee(Employee emp)
	{
		Transaction tx = pm.currentTransaction();
		try
		{
		    tx.begin();
		    Query q = pm.newQuery(Employee.class," employeeId== " + emp.getEmployeeId());
		    List<Employee> e1 = (List<Employee>) q.execute();
		    for(Employee e2:e1)
		    {
		    	e2.setName(emp.getName());
		    	e2.setDesignation(emp.getDesignation());
		    	e2.setSalary(emp.getSalary());
		    }
		    
		    tx.commit();
		}
		finally
		{
		    if (tx.isActive())
		    {
		        tx.rollback();
		    }

		    pm.close();
		}
	}
	public static Employee updateEmployeeJson (Employee emp)
	{
		Transaction tx=pm.currentTransaction();
		try
		{
		    tx.begin();
		    emp = pm.detachCopy(pm.makePersistent(emp));
		    tx.commit();
		    
		}
		finally
		{
			if (tx.isActive())
		    {
		        tx.rollback();
		    }
		    //pm.close();
		}
		return emp;
		
		
		/*Transaction tx = pm.currentTransaction();
		Employee e2;
		try
		{
		    tx.begin();
		    Query q = pm.newQuery(Employee.class,"employeeId== " + emp.getEmployeeId() );
		    List<Employee> e1 = (List<Employee>) q.execute();
		    e2=e1.get(0);
		    	e2.setName(emp.getName());
		    	e2.setDesignation(emp.getDesignation());
		    	e2.setSalary(emp.getSalary());
		    tx.commit();
		}
		finally
		{
		    if (tx.isActive())
		    {
		        tx.rollback();
		    }

		  //  pm.close();
		}
		return e2;*/
	}
	
	/**
	 * 
	 */
	public static Employee getEmployeeByPrimaryKey(int id){
		Transaction tx = pm.currentTransaction();
		Employee e = null;
		try
		{
		    tx.begin();
		    Query q;  
		    
		    	q = pm.newQuery(Employee.class, "employeeId ==" +  id);
		    
		    List<Employee> listOfEmployees = (List<Employee>)q.execute();
		    Iterator<Employee> iter = listOfEmployees.iterator();
		    
		    if(iter.hasNext())
		    {	
		    	e = iter.next();
		    	pm.detachCopy(e);
		    }
		    tx.commit();
		}
		finally
		{
		    if (tx.isActive())
		    {
		        tx.rollback();
		    }
		}
		return e;
	}
	public static void delete(int id)
	{
		Transaction tx = pm.currentTransaction();
		try
		{
		    tx.begin();
		    Query q = pm.newQuery(Employee.class,"employeeId== " + id ) ;
		    List<Employee> e1 = (List<Employee>) q.execute();
		    pm.deletePersistentAll(e1);
		    
		    tx.commit();
		}
		finally
		{
		    if (tx.isActive())
		    {
		        tx.rollback();
		    }

		   //pm.close();
		}
	}
}
