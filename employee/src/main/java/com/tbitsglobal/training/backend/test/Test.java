package com.tbitsglobal.training.backend.test;

import com.tbitsglobal.training.backend.DAO.*;
import com.tbitsglobal.training.backend.entities.*;
import java.io.*;
import java.util.*;

public class Test {
	
	public static void main (String args[]) throws NumberFormatException, IOException
	{
		String name,type;
		Double pay;
		int i=0,id;
		
		 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Select the following :");
		System.out.println("\n1.create \n 2.read \n 3.update \n 4.delete ");
		
		System.out.println("Enter the choice :");
		i=Integer.parseInt(reader.readLine());
		
		Employee emp = new Employee();
		
		switch(i)
		{
		
		case 1: System.out.println("Enter record :");
				System.out.println("Enter the name : ");
		        name= reader.readLine();
		
		        System.out.println("Enter the designation : ");
		        type= reader.readLine();
		
		        System.out.println("Enter the salary : ");
		        pay= Double.parseDouble(reader.readLine());
		
		        emp = new Employee(name,type,pay);
		        EmployeeDAO.createEmployee(emp);
		        System.out.println("Created");
		        break;
		       
		case 2 : System.out.println("Enter the employee id you want to delete : ");
		 		 id=Integer.parseInt(reader.readLine());
		         emp.setEmployeeId(id);
				 EmployeeDAO.readEmployee(emp);
				 System.out.println("Employee read");
				 break;
				 
		case 3 :System.out.println("Enter the employee id you want to update : ");
		 		id=Integer.parseInt(reader.readLine());
		 		emp=new Employee("Parag","Employee",1000.00);
		 		emp.setEmployeeId(id);
				EmployeeDAO.updateEmployee(emp); 
				System.out.println("Updated Record");
				 break;
			
		case 4 : System.out.println("Enter the employee id you want to delete : ");
 				 id=Integer.parseInt(reader.readLine());
 				 emp.setEmployeeId(id);
			     EmployeeDAO.deleteEmployee(emp);
				 System.out.println("Employee deleted");
				 break;
				 
		}
	}

}
