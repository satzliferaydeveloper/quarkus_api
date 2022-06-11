package org.department;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;

import org.eclipse.microprofile.openapi.annotations.media.Schema;


@Schema(description="holds the departments information")
public class Department {
	
	@Schema(required=true)
	@JsonbProperty("depName")
	private String name;
	@JsonbTransient
	private long id;
	
	public Department(String name, long id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	

}
