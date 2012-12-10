package com.tbitsglobal;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import javax.jdo.*;

import org.apache.taglibs.standard.lang.jstl.test.StaticFunctionTests;
import org.datanucleus.store.Extent;

public class EmployeeDao {
	
	public static PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	public static PersistenceManager pm = pmf.getPersistenceManager();

	public static void main(String[] args) {
//		Employee emp = new Employee("abc","12345");
//		 createEmployee(emp);
		// Employee empl=new Employee();
		// showEmployee();
		viewEmployee();
		// Employee empl=new Employee("bihar", "7677058027");
		//updateEmployee(emp);
		// deleteEmployee();
	}

	public static Employee createEmployee(Employee emp) {
		System.out.println("comes to create employyee  methodSS");
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			emp = pm.detachCopy(pm.makePersistent(emp));
			tx.commit();
		} 
		finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			// pm.close();
		}
		return emp;
	}

	/*public static Employee showEmployee() {
		Query query1 = pm.newQuery(Employee.class, "employeeId == 5");
		Employee e = null;
		List<Employee> e1 = (List<Employee>) query1.execute();
		if (e1 == null)
			System.out.println("Exception rises");
		Iterator<Employee> iter = e1.iterator();
		while (iter.hasNext()) {
			Employee e12 = iter.next();
			System.out.println("Employee id is : " + e12.getEmployeeId()
					+ " and  Employee adress : " + e12.getAddress());

		}
		return e;
	}
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
	
	public static Employee viewEmployee() {
		Transaction tx = pm.currentTransaction();
		Employee empl2=new Employee();
		try {
			tx.begin();
			Query q = pm.newQuery(Employee.class, "employeeId == 1");
			@SuppressWarnings("unchecked")
			Collection e = (Collection) q.execute();
			Iterator iter = e.iterator();
			while (iter.hasNext()) {
				empl2 = (Employee) iter.next();
				System.out.println("The details of employee is :Address is "
						+ empl2.getAddress() + " and mob no is : "
						+ empl2.getMob());
				}	
			tx.commit();
			}
		finally {
			if (tx.isActive()) {
				tx.rollback();
			}
		}
		return empl2;
	}

	public static Employee updateEmployee(Employee emp) {
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			javax.jdo.Query q = pm.newQuery(Employee.class, "employeeId == 1");
			List<Employee> e = (List<Employee>) q.execute();
			Iterator iter = e.iterator();
			for (Employee e2 : e) {
				e2.setAddress(emp.getAddress());
				e2.setMob(emp.getMob());
			}
			tx.commit();
		} 
		finally {
			if (tx.isActive()) {
				tx.rollback();
			}
		}
		return emp;
	}

	public static  void deleteEmployee(int id) {
		Transaction tx = pm.currentTransaction();
		try {
		tx.begin();
		 Query q = pm.newQuery(Employee.class, "employeeId == "+id);
		List<Employee> e1 = (List<Employee>) q.execute();
		pm.deletePersistentAll(e1);
		tx.commit();
		}
		finally {
			if (tx.isActive()) {
				tx.rollback();
			}
		}
		
	}
}
