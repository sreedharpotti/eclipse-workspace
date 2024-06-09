package restAPI;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class APITest_POST {
	
	@Test
	public void post() {
	
		JSONObject request = new JSONObject();
		
		request.put("name","SREE");
		request.put("job","QA");
		
		given().
			body(request.toString()).
		when().post("https://reqres.in/api/users").
		then().statusCode(201).log().all();
			

	}
	
	@Test
	public void put() {
	
		JSONObject request = new JSONObject();
		
		request.put("name","SREE");
		request.put("job","QA");
		
		given().
			body(request.toString()).
		when().put("https://reqres.in/api/users/2").
		then().statusCode(200).log().all();
			

	}
	

}
