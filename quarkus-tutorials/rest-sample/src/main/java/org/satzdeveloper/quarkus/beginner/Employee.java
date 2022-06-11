package org.satzdeveloper.quarkus.beginner;


public class Employee {
	
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

	public long id;
	public String name;
	public String depName;

	public Employee(long id, String name,String depName) {
		super();
		this.id = id;
		this.name = name;
		this.depName = depName;
	}
	
	
}
