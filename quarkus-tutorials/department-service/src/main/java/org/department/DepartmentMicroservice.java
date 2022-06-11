package org.department;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;


@ApplicationPath("/")
@OpenAPIDefinition(
		info = @Info(title="This service gives the department",
					version="1.0",
					contact = @Contact(name = "sathish",email="satzliferaydeveloper@gmail.com")
				),
		externalDocs = @ExternalDocumentation(description = "external documentation is quarkus"),
		tags ={
				@Tag(name = "API",description = "access this for reactive api"),
				@Tag(name="Department", description="the API that needs to be accessed")
		}
		
		
		)
public class DepartmentMicroservice extends Application{

	
	
}
