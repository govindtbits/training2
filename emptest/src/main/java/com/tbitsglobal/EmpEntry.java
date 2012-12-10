package com.tbitsglobal;

/**
 * Hello world!
 *
 */
public class EmpEntry 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        EmployeeDAO.createEmployee(new Employee("xyz", "jocker", 12345d));
    }
}
