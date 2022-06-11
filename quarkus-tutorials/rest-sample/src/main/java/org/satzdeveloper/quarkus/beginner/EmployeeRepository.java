package org.satzdeveloper.quarkus.beginner;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.PathParam;

@ApplicationScoped
public class EmployeeRepository {
	
	
	    public List<Employee> getEmployees() {
	        return List.of(new Employee(123L, "Ramesh",""),
	        		new Employee(124L, "Sathish","")
	        		);
	    }
	    
	    
	     public Optional<Employee> getEmployee(@PathParam("id") int id) {
	         return  getEmployees().stream().filter(emp->emp.id==id).findFirst();
	     }

	
	
}
