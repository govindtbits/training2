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



@Path("/tbits1")
public class EmployeeService {

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)

	public Response getEmployeeDetails()
	{
		 //Employee emp=EmployeeDao.createEmployee(new Employee("rftf","66786"));
		Employee emp=EmployeeDao.viewEmployee();
		//Employee emp=new Employee("rftf","66786");
		// Test test=new Test();
		//String str="Mukesh rawat";
		return Response.status(201).entity(emp).build();
	}
	
	@POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Response createEmployeeDetails(Employee emp) {
           // Employee emp=new Employee("rajesh","1234");
            emp = EmployeeDao.createEmployee(emp);
            //String result = "Employee saved : " + emp.getName();
            return Response.status(201).entity(emp).build();
    }
	
	@PUT
	@Path("/put")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response UpdateEmployeeInJSON(Employee emp) {
		EmployeeDao.updateEmployee(emp);
		
		return Response.status(201).entity(emp).build();
	}
	
	@DELETE
	@Path("/delete")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteEmployeeInJSON(@QueryParam("id") int id)
	{
		EmployeeDao.deleteEmployee(id);
		String deleteresult = "Employee deleted with id = " + id ;
		return Response.status(200).entity(deleteresult).build();

	}
}

