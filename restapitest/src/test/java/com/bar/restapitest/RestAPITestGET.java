package com.bar.restapitest;

import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;


@Test
public class RestAPITestGET {
	
	@Test
	// Read .CSV file and iterate through test data - START
	public void testAPI() throws IOException, CsvException {

    	String urlString = "https://reqres.in/api/users";
    	
    	// Create a CSV reader to read the test data
        CSVReader reader = null;
        		
        	try {
        		reader=new CSVReader(new FileReader("C:\\Users\\sreed\\eclipse-workspace\\restapitest\\src\\test\\resources\\TestData.csv"));
                
        	     // Read the CSV data into a list of arrays
        	        List<String[]> data = reader.readAll();
        	        
        	     // Loop through each row of data and execute the test case
        	        for (String[] row : data) {
        	        	
        	            // Extract the test data from the row
        	            String id = row[0];
        	            String name = row[1];
        	            
        	            // Send a GET request to the API endpoint with the test data
        	            Response response = RestAssured.given()
        	            		.headers(httpHeaderManager())
        	                    .param("id", id)
        	                    .get(urlString);
        	            
        	            assertEquals(response.getStatusCode(),200);
        	            assertEquals(response.jsonPath().getString("data.first_name"), name);
        	            assertEquals(response.getHeaders().getValue("content-type"),"application/json; charset=utf-8");
        	            
        	            assertNotNull(response.jsonPath().getString("data.avatar"), "Avatar field is not null");
        	        }	
        	} finally {
        		if(reader!=null)
        			reader.close();
        	}
	}
	
	// Read .CSV file and iterate through test data - END

	
	// Using DataProvider START
	
	@DataProvider(name = "testData")
    public Object[] testData() {
        return new TestData[] {
                new TestData(1,"George"),
                new TestData(2,"Janet")   
        };
    }
	
	@Test(dataProvider = "testData")
    public void testWithDifferentUserIds(TestData testData) {
        RestAssured.baseURI = "https://reqres.in/api";

        Response response = RestAssured.
                given()
                    .pathParam("id", testData.id)
                .when()
                    .get("/users/{id}")
                .then()
                    .statusCode(200).extract().response();
        assertEquals(response.jsonPath().getString("data.first_name"), testData.name);
	}
	
	
	public static Headers httpHeaderManager(){
	    Header contentType = new Header("Content-Type","application/json");
	   // Header authorization = new Header("Authorization", "your token");
	    List<Header> headerList = new ArrayList<Header>();
	    headerList.add(contentType);
	   //// headerList.add(authorization);
	    Headers header = new Headers(headerList);
		return header;

	}
	
}

// this one is for DataProvider
	class TestData {
		int id;
		String name;
		
		public TestData(int id, String name) {
			this.id = id;
			this.name = name;
		}
	
	// Using DataProvider END
		
		

}
