package day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class Httpreq {
	int id;
	
	@Test(priority=2)
	public void getusers() {
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.log().all();
			
	}
	
	
	@Test(priority=1)
	public void createUser() {
		
		HashMap data = new HashMap();
		data.put("name", "hary");
		data.put("job", "student");
		
		id=given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id")
		//.then()
		//	.statusCode(201)
		//	.log().all()
			;
	}
	
	
	@Test(dependsOnMethods={"createUser"})
	public void updateuser() {
		
		HashMap data = new HashMap();
		data.put("name", "hari");
		data.put("job", "techie");
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.patch("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(200)
		;
	}
	
	@Test
	public void delete() {
		given()
		.when()
			.delete("https://reqres.in/api/users/"+id)
		.then()
		.statusCode(204)
		
		;
	}
	
	
	
	
	
}






