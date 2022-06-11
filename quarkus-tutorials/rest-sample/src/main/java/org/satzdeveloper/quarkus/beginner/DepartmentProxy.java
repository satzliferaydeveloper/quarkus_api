package org.satzdeveloper.quarkus.beginner;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "depProxy")
@Path("/api/departments")
public interface DepartmentProxy {
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Department> getDepartments();
	

}


