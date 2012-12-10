package com.tbitsglobal.training.backend.entities;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import com.tbitsglobal.training.backend.test.JerseyClientDelete;
import com.tbitsglobal.training.backend.test.JerseyClientget;
import com.tbitsglobal.training.backend.test.JerseyClientpost;
import com.tbitsglobal.training.backend.test.JerseyClientput;


@ManagedBean
@SessionScoped
public class EmployeeBean implements Serializable{
	
	int employeeId;
	String name;
	String designation;
	double salary;
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Employee assignvalues(Employee emp)
	{
		emp.setEmployeeId(this.getEmployeeId());
		emp.setName(this.getName());
		emp.setDesignation(this.getDesignation());
		emp.setSalary(this.getSalary());	
		return emp;		
	}
	
	public void updatedEmployee(Employee emp)
	{
		this.setEmployeeId(emp.getEmployeeId());
		this.setName(emp.getName());
		this.setDesignation(emp.getDesignation());
		this.setSalary(emp.getSalary());
		
	}
	
	public String addConfirmedEmployee() 
	{
		Employee emp = new Employee();
		emp=assignvalues(emp);
		JerseyClientpost jcp = new JerseyClientpost();
		emp=jcp.post(emp);
		
		FacesMessage doneMessage = null;
		String outcome = null;
		if (emp==null)
		{
			doneMessage = new FacesMessage("Failed to add new user");
			outcome = "display";
			emp.setEmployeeId(0);
			emp.setName(null);
			emp.setDesignation(null);
			emp.setSalary(0.0);	
		}
		else
		{
			doneMessage = new FacesMessage("Successfully added new user");
			outcome = "done";
			this.updatedEmployee(emp);
		}
		FacesContext.getCurrentInstance().addMessage(null, doneMessage);
		return outcome;
	}
	@Override
	public String toString() {
		return "EmployeeBean [employeeId=" + employeeId + ", name=" + name
				+ ", designation=" + designation + ", salary=" + salary + "]";
	}
	
	public String getEmployeedone()
	{
		Employee emp= new Employee();
		emp=assignvalues(emp);
		JerseyClientget jcg = new JerseyClientget();
		emp=jcg.getEmployee(emp);
		
		FacesMessage doneMessage = null;
		String outcome = null;
		if (emp==null)
		{
			doneMessage = new FacesMessage("Retrieve Failure");
			outcome = "display";
			emp.setEmployeeId(0);
			emp.setName(null);
			emp.setDesignation(null);
			emp.setSalary(0.0);	
		}
		else
		{
			doneMessage = new FacesMessage("Successfully Retreived Employee");
			outcome = "done1";
			this.updatedEmployee(emp);
		}
		FacesContext.getCurrentInstance().addMessage(null, doneMessage);
		return outcome;
	}
	
	public String deleteEmployeedata()
	{
		Employee emp= new Employee();
		emp=assignvalues(emp);
		JerseyClientDelete jcd = new JerseyClientDelete();
		jcd.deleteEmployee(emp);
		
		FacesMessage doneMessage = null;
		String outcome=null;
		if (emp==null)
		{
			doneMessage = new FacesMessage("Delete Failure");
			outcome = "display";	
		}
		else
		{
			doneMessage = new FacesMessage("Successfully Deleted Employee");
			//outcome = "done";
			this.updatedEmployee(emp);
		}
		FacesContext.getCurrentInstance().addMessage(null, doneMessage);
		return outcome;
		
	}
	public String updateEmployeedone() 
	{
		Employee emp = new Employee();
		emp=assignvalues(emp);
		JerseyClientput jcpu = new JerseyClientput();
		emp=jcpu.updateEmployee(emp);
		
		FacesMessage doneMessage = null;
		String outcome = null;
		if (emp==null)
		{
			doneMessage = new FacesMessage("Failed to Update user");
			outcome = "display";
			emp.setEmployeeId(0);
			emp.setName(null);
			emp.setDesignation(null);
			emp.setSalary(0.0);	
		}
		else
		{
			doneMessage = new FacesMessage("Successfully Updated the user");
			outcome = "done3";
			this.updatedEmployee(emp);
		}
		FacesContext.getCurrentInstance().addMessage(null, doneMessage);
		return outcome;
	}
	
	public void printHello(){
		try {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
		PrintWriter pw = response.getWriter();
		pw.write("<html>");
		pw.write("<h2>Hello World</h2>");
		pw.write("</html>");
		FacesContext.getCurrentInstance().responseComplete(); 
		} catch (IOException e) {
		FacesContext.getCurrentInstance().addMessage(
		"helloWorldButtonId",
		new FacesMessage("Error:" + e.getMessage())
		);
		}
		}
	
	
}
