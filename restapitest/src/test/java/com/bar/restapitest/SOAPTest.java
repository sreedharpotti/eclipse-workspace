package com.bar.restapitest;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@Test
public class SOAPTest {
	
	@Test
	public void SoapReq() {
		
		try {
			String filePath = "C:\\Users\\sreed\\eclipse-workspace\\restapitest\\src\\test\\resources\\soapRequest.xml";
			String soapRequest = new String(Files.readAllBytes(Paths.get(filePath)));
			
			Response response = RestAssured.given().contentType("text/xml")
	                .body(soapRequest)
	            .when()
	                .post("http://www.dneonline.com/calculator.asmx?WSDL"); // Replace with your SOAP endpoint

            assertEquals(response.getStatusCode(),200);


	        // Print the SOAP response
	        System.out.println(response.getBody().asString());
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
