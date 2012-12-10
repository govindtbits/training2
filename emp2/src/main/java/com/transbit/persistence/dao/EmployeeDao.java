package com.transbit.persistence.dao;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import com.transbit.persistence.entities.Employee;

public class EmployeeDao {


	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		Employee emp=new Employee("govind");
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm =pmf.getPersistenceManager();
		// Transaction tx=pm.currentTransaction();
		Transaction tx=pm.currentTransaction();
		try
		{	tx.begin();
			System.out.println("hello");
			System.out.print(emp);
			emp = pm.detachCopy(pm.makePersistent(emp));
			System.out.print(emp);
			tx.commit();
		}catch(Exception e){
			System.out.print(e.getMessage());
		}

		finally
		{
			if(tx.isActive())

			{
				tx.rollback();
			}
			
		}
		System.out.println("hello");
	}

		
}
	
