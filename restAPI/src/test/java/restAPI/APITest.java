package restAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;



public class APITest {

   
    @Test
    public void testAPI() {
    	
    	Response response = get("https://reqres.in/api/users/");
    	
    	System.out.println(response.getStatusCode());
    	System.out.println(response.getHeader("content-type"));
    	System.out.println(response.getBody().asString());

    	
    	int StatusCode = response.getStatusCode();
    	Assert.assertEquals(StatusCode, 200);
    	
    	

    }
    
    @Test
    void testAPI_02() {
    	
    	given()
    		.get("https://reqres.in/api/users/").then().statusCode(200).log().all();
    	
    	given().get("https://reqres.in/api/users/").then().body("data.first_name", hasItems("George", "Eve"));

    }
}
