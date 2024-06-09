package com.bar.restapitest;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

@Test
public class RestAPITestPOST {
	
	@Test
	public void postTest() {
		
    	String urlString = "https://reqres.in/api/users";
		
		JSONObject request = new JSONObject();
		
		request.put("name","SREE");
		request.put("job","QA");
		
		Response response = RestAssured.given().
			body(request.toString()).
		when().post(urlString);
		
        assertEquals(response.getStatusCode(),201);
        String id = response.jsonPath().getString("id");
	    
        given().param("id",1).get(urlString).then().statusCode(200).log().all();	
	}

}