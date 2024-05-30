package Virsec;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import files.ReUseableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class Apis {
	public String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Im9maklFalZ1UXp2T0xyTjgwRzlrXyJ9.eyJURU5BTlRfSU5GTyI6eyJvYmpfYWNjZXNzIjpbIm9iajp2dWxuZXJhYmlsaXR5OndyaXRlIiwib2JqOnZ1bG5lcmFiaWxpdHk6cmVhZCJdLCJyb2xlcyI6eyJTWVNBZG1pbiI6InN1cGVyIn0sInRlbmFudF9pZCI6IlNFQ181ZmQ1MmEiLCJ0ZW5hbnRfbmFtZSI6IkNvZ25pdGl2WmVuIiwidGVuYW50X3NjaGVtYSI6IlNFQ181RkQ1MkEifSwiVEVTVF9EQVRBIjoib2JqOnZ1bG5lcmFiaWxpdHk6d3JpdGUgb2JqOnZ1bG5lcmFiaWxpdHk6cmVhZCIsImlzcyI6Imh0dHBzOi8vZGV2LTBndnR1NGp1NGd5dnFmMWwudXMuYXV0aDAuY29tLyIsInN1YiI6IndhYWR8QlZoc0xHU1Z5RjROTjhOQ2xJdWxWMEZsNkYzOTllZnJJZWFpaEJ1RkU4MCIsImF1ZCI6WyJodHRwczovL2l5ZjA0eWx5MWIuZXhlY3V0ZS1hcGkudXMtd2VzdC0yLmFtYXpvbmF3cy5jb20vZGV2IiwiaHR0cHM6Ly9kZXYtMGd2dHU0anU0Z3l2cWYxbC51cy5hdXRoMC5jb20vdXNlcmluZm8iXSwiaWF0IjoxNzE2MzcwMjYxLCJleHAiOjE3MTY0NTY2NjEsInNjb3BlIjoib3BlbmlkIHByb2ZpbGUgZW1haWwgb2JqOnZ1bG5lcmFiaWxpdHk6cmVhZCBvYmo6dnVsbmVyYWJpbGl0eTp3cml0ZSIsImF6cCI6IlkycGMzUHY5ZnN5b0NyMGJBOGxrZ1pabEZxSFRsUFA4IiwicGVybWlzc2lvbnMiOltdfQ.apPOS7d8_W2DQx9FMbELTfq_BPTLM4hIKCTo4Q4zHQLtMzsTsvq2colxnOAUyh22cAFdOz-X6oWfwUnnsTv2z49Nyx6AxsFXBjy423D3o50iOlLYyE9Xp6bQYxnK30lSumnn9ZP7AQwPPbF4JVRVA9WR6xoZ7063fp9ykEunpN9ArL-3WgABTqzZTEdAG4sfMadt4WkuSQWX3U8s4GxBdRIMFGUL8Oq5u97ShNUvPIQ1Ve2kyL3onvgtjXwTh5XsU1PN1YspckkRzAHM9621juUUFqCduCrWFcbw-Xdy10aOKsBm-iidC98edUQ5tT1SWoyXPYj6nsj3coiEoKQcLg";
	@Test
	public void Auth() {

		String cookie = "auth0=s%3Av1.gadzZXNzaW9ugqZoYW5kbGXEQKm99B9s1nLYIth3Pkx8AOpCzBguYkuV5DOfoN_xRKBvQTCcB9BXgmgxWYC5yrlrl1KokZhr_7GQjCtanNA8v72mY29va2llg6dleHBpcmVz1_9yrekAZivk8a5vcmlnaW5hbE1heEFnZc4PcxQAqHNhbWVTaXRlpG5vbmU.hwhz%2BS9hCVUsOlWDbKdPlD7PzwUeTtKyE6uYAweEqUE; auth0_compat=s%3Av1.gadzZXNzaW9ugqZoYW5kbGXEQKm99B9s1nLYIth3Pkx8AOpCzBguYkuV5DOfoN_xRKBvQTCcB9BXgmgxWYC5yrlrl1KokZhr_7GQjCtanNA8v72mY29va2llg6dleHBpcmVz1_9yrekAZivk8a5vcmlnaW5hbE1heEFnZc4PcxQAqHNhbWVTaXRlpG5vbmU.hwhz%2BS9hCVUsOlWDbKdPlD7PzwUeTtKyE6uYAweEqUE; did=s%3Av0%3Abd518670-0013-11ef-be1a-130e83a63f36.p1DJLd%2F1w%2F7TAIcDgKsURtRGg%2BSB33egONXbFt7lFr8; did_compat=s%3Av0%3Abd518670-0013-11ef-be1a-130e83a63f36.p1DJLd%2F1w%2F7TAIcDgKsURtRGg%2BSB33egONXbFt7lFr8";

		RestAssured.baseURI  = "https://dev-0gvtu4ju4gyvqf1l.us.auth0.com";
		String response =  given().log().all().contentType("application/x-www-form-urlencoded").header("Cookie", cookie).
				formParam("grant_type", "client_credentials").
				formParam("client_id", "Y2pc3Pv9fsyoCr0bA8lkgZZlFqHTlPP8").
				formParam("client_secret", "Ja7gmaQRWWhNpR5W1xZCEhgarDdhwt9Kuo5NVx9f3bvHeMJJ961z4toDf4e5-wLk").
				formParam("audience", "https://iyf04yly1b.execute-api.us-west-2.amazonaws.com/dev").
				when().post("/oauth/token").then().log().all().extract().response().asString();

		System.out.println("ddd "+response);



	}

	@Test
	public void Role() {
		String cook ="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Im9maklFalZ1UXp2T0xyTjgwRzlrXyJ9.eyJpc3MiOiJodHRwczovL2Rldi0wZ3Z0dTRqdTRneXZxZjFsLnVzLmF1dGgwLmNvbS8iLCJzdWIiOiJZMnBjM1B2OWZzeW9DcjBiQThsa2daWmxGcUhUbFBQOEBjbGllbnRzIiwiYXVkIjoiaHR0cHM6Ly9peWYwNHlseTFiLmV4ZWN1dGUtYXBpLnVzLXdlc3QtMi5hbWF6b25hd3MuY29tL2RldiIsImlhdCI6MTcxNjI5MTQyMSwiZXhwIjoxNzE2Mzc3ODIxLCJndHkiOiJjbGllbnQtY3JlZGVudGlhbHMiLCJhenAiOiJZMnBjM1B2OWZzeW9DcjBiQThsa2daWmxGcUhUbFBQOCJ9.NQBJMSz9zveJGewFSWMx3wrbJX5SsbTcB6Xb4_VpkOkYZ4jLpPQcXJLL9ZlMYZSZ9hFl2YClCNyNurzFw6ggtGvUWh5dxGy68iCE6I2Ozs3lmhRTZ6wKKYp7AOC69TyKSynVswkkmXKmKGh-auk-BeW4dqbqboIidVk09RriRXg1hXmGLX3BHortpbZv2g4f8ODGCpACepv9rC9u_l8X3tC3-8AtOHOu9gLXuRgCokOvoZPfygE-iQAKqGZaSicyIS6HDcXZJyds2Of5xah42NK3WYzyjgWt-xw1PXlsjW33SZBnEz2bdAVK2X-r26mOtFlPr8CP6064y1B7-ZT6wQ";

		RestAssured.baseURI = "https://iyf04yly1b.execute-api.us-west-2.amazonaws.com";
		String respons = given().header("Content-Type","application/json").header("Authorization",cook).
				body("{\n"
						+ "    \"tenant_domain\":\"cognitivzen.com\",\n"
						+ "    \"roles\": [\"IT Systems Operations\"]\n"
						+ "}").when().post("/dev/roles").then().log().all().extract().response().asString();
		System.out.println(respons);
	}
	
	String j1;
	@Test
	public void fileupload() {
		RequestSpecification AddFile = new RequestSpecBuilder().setBaseUri("https://3bpbr61qb1.execute-api.us-west-2.amazonaws.com").
				addHeader("Authorization", token).build();
		RequestSpecification reqAddFile = given().log().all().spec(AddFile).
				multiPart("file", new File("/home/arunkumar/Downloads/Snowflake_nessus_report 1.csv"));
		
		String response = reqAddFile.when().post("/tenable/upload").then().log().all().extract().response().asString();
		JsonPath js = new JsonPath(response);
		String JobId = js.get("status_url");
		 j1 = JobId.split("s/")[1];
		System.out.println(j1);
		//System.out.println(response);
	
	
	
		//Job Status
		RequestSpecification jobstatus = new RequestSpecBuilder().setBaseUri("https://iyf04yly1b.execute-api.us-west-2.amazonaws.com").
				addHeader("Authorization", token).build();
		RequestSpecification reqJobStatus = given().log().all().spec(jobstatus);
		reqJobStatus.when().get("/dev/job_status/"+j1).then().log().all().extract().response().asString();
		
		
	}	
	

}
