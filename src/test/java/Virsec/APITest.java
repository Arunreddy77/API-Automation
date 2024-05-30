package Virsec;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APITest {
    public static void main(String[] args) {
       
        // Set base URI
        RestAssured.baseURI = "https://dev-0gvtu4ju4gyvqf1l.us.auth0.com";

        // Send the request and capture the response
        Response response = 
            given()
                .log().all() // Log all request details
                .contentType("application/x-www-form-urlencoded")
                .header("Cookie", "auth0=s%3Av1.gadzZXNzaW9ugqZoYW5kbGXEQKm99B9s1nLYIth3Pkx8AOpCzBguYkuV5DOfoN_xRKBvQTCcB9BXgmgxWYC5yrlrl1KokZhr_7GQjCtanNA8v72mY29va2llg6dleHBpcmVz1_9yrekAZivk8a5vcmlnaW5hbE1heEFnZc4PcxQAqHNhbWVTaXRlpG5vbmU.hwhz%2BS9hCVUsOlWDbKdPlD7PzwUeTtKyE6uYAweEqUE; auth0_compat=s%3Av1.gadzZXNzaW9ugqZoYW5kbGXEQKm99B9s1nLYIth3Pkx8AOpCzBguYkuV5DOfoN_xRKBvQTCcB9BXgmgxWYC5yrlrl1KokZhr_7GQjCtanNA8v72mY29va2llg6dleHBpcmVz1_9yrekAZivk8a5vcmlnaW5hbE1heEFnZc4PcxQAqHNhbWVTaXRlpG5vbmU.hwhz%2BS9hCVUsOlWDbKdPlD7PzwUeTtKyE6uYAweEqUE; did=s%3Av0%3Abd518670-0013-11ef-be1a-130e83a63f36.p1DJLd%2F1w%2F7TAIcDgKsURtRGg%2BSB33egONXbFt7lFr8; did_compat=s%3Av0%3Abd518670-0013-11ef-be1a-130e83a63f36.p1DJLd%2F1w%2F7TAIcDgKsURtRGg%2BSB33egONXbFt7lFr8; did=s%3Av0%3A39da95a0-06d2-11ef-91c6-4d7a15f830eb.2LHGFUZrlFKsHufUUmovNynXv3X9RsnKnbMzzz4URBY; did_compat=s%3Av0%3A39da95a0-06d2-11ef-91c6-4d7a15f830eb.2LHGFUZrlFKsHufUUmovNynXv3X9RsnKnbMzzz4URBY")
                .formParam("grant_type", "client_credentials")
                .formParam("client_id", "Y2pc3Pv9fsyoCr0bA8lkgZZlFqHTlPP8")
                .formParam("client_secret", "Ja7gmaQRWWhNpR5W1xZCEhgarDdhwt9Kuo5NVx9f3bvHeMJJ961z4toDf4e5-wLk")
                .formParam("audience", "https://iyf04yly1b.execute-api.us-west-2.amazonaws.com/dev")
            .when()
                .post("/oauth/token")
            .then()
                .log().all() // Log all response details
                .extract().response();

        // Check for correct status code and non-null access token
        int statusCode = response.getStatusCode();
        String accessToken = response.jsonPath().getString("access_token");

        // Print the response status code and access token
        System.out.println("Status Code: " + statusCode);
        System.out.println("Access Token: " + accessToken);

        // Assertions
        assert statusCode == 200 : "Expected status code 200, but got " + statusCode;
        assert accessToken != null : "Access token is null";
    }
}
