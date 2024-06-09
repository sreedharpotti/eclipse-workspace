package com.auth.token;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Main {
    public static void main(String[] args) {
        // Step 1: Authenticate and get the bearer token
        String token = getBearerToken();
        
        // Step 2: Use the token in the header of another API request
        String apiUrl = "https://api.example.com/resource";
        callApiWithBearerToken(apiUrl, token);
    }
    
    // Method to get the bearer token from the authentication API
    private static String getBearerToken() {
        String username = "your_username";
        String password = "your_password";
        
        // Authentication API endpoint
        String authUrl = "https://auth.example.com/token";
        
        // Forming the request
        RequestSpecification request = RestAssured.given();
        request.auth().preemptive().basic(username, password);
        
        // Sending the request and extracting the token
        Response response = request.post(authUrl);
        if (response.getStatusCode() == 200) {
            return response.getBody().asString();
        } else {
            throw new RuntimeException("Failed to retrieve bearer token: " + response.getStatusCode());
        }
    }
    
    // Method to call another API with the bearer token
    private static void callApiWithBearerToken(String apiUrl, String token) {
        // Forming the request
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + token);
        
        // Sending the request and handling the response
        Response response = request.get(apiUrl);
        if (response.getStatusCode() == 200) {
            String responseBody = response.getBody().asString();
            System.out.println("API Response: " + responseBody);
        } else {
            throw new RuntimeException("API call failed: " + response.getStatusCode());
        }
    }
}
