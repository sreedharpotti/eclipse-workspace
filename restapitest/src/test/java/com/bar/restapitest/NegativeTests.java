package com.bar.restapitest;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NegativeTests {
	
// Negative testing
		@Test
		public void NegativeTests() {
			// provide wrong context path
	    	String urlString = "https://www.anapioficeandfire.com/apis/houses?region=The Vale";
	    	given().get(urlString).then().statusCode(404).log().all();
	    	
			// provide wrong URI(Uniform Resource Identifier)
	    	urlString = "https://www.anapioficeandfire.com/api/house?region=The Vale";
	    	given().get(urlString).then().statusCode(404).log().all();
	    	
	    	// provide wrong wrong input with special characters
	    	urlString = "http://www.anapioficeandfire.com/api/houses?region=The Vale@@@";
	    	given().get(urlString).then().statusCode(200).body("", Matchers.hasSize(0));
	    	
	    	
		}
	

}
