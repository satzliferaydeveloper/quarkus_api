package org.satzdeveloper.quarkus.beginner;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.quarkus.test.Mock;

@Mock
@RestClient
public class DepartmentProxyMockImpl implements DepartmentProxy {

	@Override
	public List<Department> getDepartments() {
		// TODO Auto-generated method stub
		return List.of(new Department("HR"));
	}

}
