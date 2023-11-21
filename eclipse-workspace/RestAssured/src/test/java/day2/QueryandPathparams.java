package day2;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class QueryandPathparams {
	
	@Test
	public void queryPathParams() {

		//https://reqres.in/api/users?page=2&id=4
		
		given()
			.queryParam("page", "2")
			.queryParam("id", 4)
			.pathParam("mypath", "users")
		.when()
			.get("https://reqres.in/api/{mypath}")
		
		.then()
			.log().all();
		
	}
	
	
	
	
	

}
