package day1;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class Postreqbodyways {
	
	//4 ways
	//1.hashmap
	//2.org.json
	//3.pojo class
	//4.external json file
	
	
	//@Test
	public void externalJsonFile() throws FileNotFoundException {
		
		File src = new File(".\\data.json");
		
		FileReader fr = new FileReader(src);
		
		JSONTokener jt=new JSONTokener(fr);
		
		JSONObject data = new JSONObject(jt);
		
		given()
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name", equalTo("harika"))
			
		;
		
	}
	
	
	//@Test
	public void JsonObject()  {
		
		
		
		JSONObject data = new JSONObject();
		
		data.put("name", "raj");
		data.put("phone", "1233");
		String coursesarr[]= {"abc","defg"};
		data.put("courses",coursesarr);
		
		given()
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name", equalTo("raj"))
			.body("courses[0]",equalTo("abc"))
			
		;
		
	}
	
	//@Test
		public void hashMap()  {
			
			
			HashMap data = new HashMap();
			
			data.put("name", "raj");
			data.put("phonen", "1233");
			String coursesarr[]= {"abc","defg"};
			data.put("courses",coursesarr);
			
			given()
				.contentType("application/json")
				.body(data)
			.when()
				.post("http://localhost:3000/students")
			.then()
				.statusCode(201)
				.body("name", equalTo("raj"))
				.body("courses[0]",equalTo("abc"))
				
			;
			
		}
		
		
		@Test
		public void pojoclass()  {
			
			
			
			PojoClass data = new PojoClass();
			
			data.setName("mani");
			data.setPhone("3456");
			String coursesarr[]= {"math","bio"};
			data.setCourses(coursesarr);
			
			given()
				.contentType("application/json") 
				.body(data)
			.when()
				.post("http://localhost:3000/students")
			.then()
				.statusCode(201)
				.body("name", equalTo("mani"))
				.body("courses[1]",equalTo("bio"))
				
			;
			
		}
	
	
	
	

}
