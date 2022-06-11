package org.satzdeveloper.quarkus.beginner;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.json.JsonBuilderFactory;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {

	@Inject
	EmployeeRepository employeeRepository;
	
	@Inject
	Logger logger;
	
	@ConfigProperty(name = "emp.id",defaultValue="123")
	String empId;
	
	
    @GET
    public List<Employee> getEmployees() {
        return employeeRepository.getEmployees();
    }
    
    @RestClient
    DepartmentProxy depProxy;
    
    
    @GET
    @Path("/employee/{id}")
    @Produces(MediaType.APPLICATION_JSON)
     public Employee getEmployee(@PathParam("id") int id) {
    	logger.info("return my employee"+empId);
    	Employee emp=employeeRepository.getEmployee(Integer.parseInt(empId)).get();
    	
         return emp;
     }
    
    
    @POST
    @Path("/employee")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Fallback(fallbackMethod = "createEmpMock"
    		)
    @Retry(delay = 1000,maxRetries = 10)
     public Response createEmp(@FormParam("id")int id,@FormParam("name")String name) {
    	Employee employee=new Employee(id, name,"name to be received by invoking department microservice");
    	logger.info("emp dep received from dep service list"+depProxy.getDepartments());
    	employee.depName=depProxy.getDepartments().get(0).getName();
         return Response.status(201).entity(employee).build();
     }
    
    public Response createEmpMock(int id,String name) {
    	Employee employee=new Employee(id, name,"name to be received by invoking department microservice");
    	logger.warn("proxy unavailable");
    	logger.warn("saving to disc ");
    	saveOnDisk(employee);
         return Response.status(201).entity(employee).build();
    }


	private void saveOnDisk(Employee employee)  {
		String empJson=JsonbBuilder.create().toJson(employee);
		try(PrintWriter out= new PrintWriter("employee"+Instant.now().toEpochMilli()+".json")){
			out.print(empJson);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}