package com.tbitsglobal.training.backend.test;

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

import com.tbitsglobal.training.backend.DAO.EmployeeDAO;
import com.tbitsglobal.training.backend.entities.Employee;


@Path("/employee")
public class JSONService {
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployeeInJSON(@QueryParam("id") int id) {
		
		Employee emp= EmployeeDAO.getEmployeeByPrimaryKey(id);
		if(emp == null)
			return Response.status(Response.Status.NO_CONTENT).entity(emp).build();	
		else
			return Response.status(Response.Status.OK).entity(emp).build();		
	}
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createEmployeeInJSON(Employee emp) {
		emp = EmployeeDAO.createEmployee(emp);
		//String result = "Employee saved : " + emp.getName();
		return Response.status(201).entity(emp).build();
	}
	
	@PUT
	@Path("/put")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response UpdateEmployeeInJSON(Employee emp) {
		EmployeeDAO.updateEmployeeJson(emp);
		
		return Response.status(201).entity(emp).build();
	}
	
	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteEmployeeInJSON(@QueryParam("id") int id)
	{
		EmployeeDAO.delete(id);
		String deleteresult = "Employee deleted with id = " + id ;
		return Response.status(200).entity(deleteresult).build();

	}
}

