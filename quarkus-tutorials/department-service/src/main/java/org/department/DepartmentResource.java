package org.department;

import java.util.List;
import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import io.smallrye.mutiny.Multi;

@Path("/api/departments")
@Tag(name = "Department REST endpoint")
public class DepartmentResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
    		summary = "returns departments")
    public Multi<Department> hello() {
        return  Multi.createFrom().items(
new Department("Finance", new Random().nextInt()),
new Department("HR",  new Random().nextInt()),
new Department("Software",  new Random().nextInt())
        		);
    }
}