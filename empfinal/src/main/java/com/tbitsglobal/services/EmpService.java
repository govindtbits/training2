package com.tbitsglobal.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


//import com.tbitsglobal.Employee;
//import com.tbitsglobal.EmployeeDao;
import com.tbitsglobal.*;


@Path("/tbits")
public class EmpService {

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response viewEmployee() {

//		String output = "this is a test msg";		 
//		return Response.status(200).entity(output).build();
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ ");
		//Employee emp=new Employee();
		//Employee emp= EmployeeDao.getEmployeeByPrimaryKey(5);
		//Employee emp= EmployeeDao.createEmployee(new Employee("rdfg", "78988"));
		HelloWorld emp=new HelloWorld();
		return Response.status(Response.Status.OK).entity(emp).build();	
//		if(emp == null)
//		{
//			System.out.println("this is a test msg 2");
//			return Response.status(Response.Status.NO_CONTENT).entity(emp).build();	
//		}
//			else
//		{
//				System.out.println("employee:");
//			return Response.status(Response.Status.OK).entity(emp).build();		
//		}
	}
}