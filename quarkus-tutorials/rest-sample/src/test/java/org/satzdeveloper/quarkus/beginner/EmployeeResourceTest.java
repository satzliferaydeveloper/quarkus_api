package org.satzdeveloper.quarkus.beginner;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class EmployeeResourceTest {

	/*
	 * @Test public void testHelloEndpoint() { given() .when().get("/employees")
	 * .then() .statusCode(200) .body(is("Hello from RESTEasy Reactive 3")); }
	 */
	 

		
		@Test
		public void testHelloEndpoint() {
			given().when().get("/employees").then().statusCode(200).body("size()",is(2));
		}
		
		@Test
		public void testEmployee() {
			given().when().get("/employees/employee/9").then().statusCode(200).body("name",is("Ramesh"),
					("depName"),is("HR"));
		}
}