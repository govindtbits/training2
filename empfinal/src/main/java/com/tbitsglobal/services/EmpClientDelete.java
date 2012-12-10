package com.tbitsglobal.services;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.tbitsglobal.Employee;

 
public class EmpClientDelete{
		
	 public void deleteEmployee(Employee emp) {
			try {
					ClientConfig clientConfig = new DefaultClientConfig();
					clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
				
					Client client = Client.create(clientConfig);
					
					BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
					
					WebResource webResource = client.resource("http://localhost:8080/empfinal/rest/tbits1/delete?id=" + emp.getEmployeeId());
					//WebResource webResource = client.resource("http://localhost:8080/empfinal/rest/tbits1/delete");
					
					ClientResponse response = webResource.accept("APPLICATION/JSON").delete(ClientResponse.class);
				
					if (response.getStatus() != 200) {
						   throw new RuntimeException("Failed : HTTP error code : "
							+ response.getStatus());
						}
					
			//		Employee output = response.getEntity(Employee.class);
					System.out.println("Output from Server .... \n");
			//		System.out.println(output);
			}
			 catch (Exception e) {
				 
					e.printStackTrace();
			 
				  }
			 
			
	 }
		 
				

}

