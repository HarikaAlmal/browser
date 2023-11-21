package day3;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class ValidateJsonData {
	
	
	//@Test
	public void test1() {
		
		given()
		
			.contentType(ContentType.JSON)
			
		.when()
			.get("http://localhost:3000/students")
		.then()
			.statusCode(404)
			.log().body()
		;
		
	}
	

	
	@Test
	public void testJsonData1() {
	    Response res = given()
	        .contentType(ContentType.JSON)
	    .when()
	        .get("http://localhost:3000/students");
	    
	    // Get the response body as a string
	    String responseBody = res.getBody().asString();
	    System.out.println("Response Body: " + responseBody);

	    // Convert the response body string to a JSON array
	    JSONArray jsonArray = new JSONArray(res.asString());

	    // Iterate through the JSON array to extract student names
	    for (int i = 0; i < jsonArray.length(); i++) {
	        JSONObject student = jsonArray.getJSONObject(i);
	        String name = student.getString("name");
	        System.out.println("Student Name: " + name);
	    }
	}
	
	
		
	}



