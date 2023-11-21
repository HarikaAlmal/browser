package day2;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
import java.util.Set;

public class CookiesandHeaders {
	
	
	//@Test
	public void alllog() {
		
		given()
		 
		.when()
			.get("https://www.google.com/")
		
		.then()
			//.log().all()
			.log().headers()
			//.log().cookies()
			//.log().body()
			;
		
	}
	
	
	//@Test
	public void cookieslog() {
		
		Response res=given()  
		 
		.when()
			.get("https://www.google.com/");
		//get single cookie
		String cookievalue= res.getCookie("AEC");
		System.out.println(cookievalue+"---------cookie value");
		
		
		//get all cookies
		Map<String,String> cookiesvalues = res.getCookies();
		Set<String> s= cookiesvalues.keySet();
		for(String cookie:s) {
			System.out.println(cookie+" "+res.getCookie(cookie));
			
		}
	}
	
	
	@Test
	public void headerslog() {
		
		
		Response res = given()
		.when()
			.get("https://www.google.com/");
		
		System.out.println("content-type header value: "+ res.getHeader("Content-Type"));
	
	Headers headersvalues = res.getHeaders();
	for(Header h:headersvalues) {
		System.out.println(h.getName()+"  "+h.getValue());
		
	}
	
	}
	
	
	

}
