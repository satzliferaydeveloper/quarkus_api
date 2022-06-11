package org.satzdeveloper.quarkus.beginner;

import javax.json.bind.annotation.JsonbProperty;

public class Department {
	
	@JsonbProperty("depName")
	private String name;
	@Override
	public String toString() {
		return "Department [name=" +name+"]";
	}
	public Department(String name) {
		super();
		this.name = name;
	}
	
	public Department() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
