package Virsec;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import files.ReUseableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Apis {

	@Test
	public void Auth() {

		String cookie = "auth0=s%3Av1.gadzZXNzaW9ugqZoYW5kbGXEQKm99B9s1nLYIth3Pkx8AOpCzBguYkuV5DOfoN_xRKBvQTCcB9BXgmgxWYC5yrlrl1KokZhr_7GQjCtanNA8v72mY29va2llg6dleHBpcmVz1_9yrekAZivk8a5vcmlnaW5hbE1heEFnZc4PcxQAqHNhbWVTaXRlpG5vbmU.hwhz%2BS9hCVUsOlWDbKdPlD7PzwUeTtKyE6uYAweEqUE; auth0_compat=s%3Av1.gadzZXNzaW9ugqZoYW5kbGXEQKm99B9s1nLYIth3Pkx8AOpCzBguYkuV5DOfoN_xRKBvQTCcB9BXgmgxWYC5yrlrl1KokZhr_7GQjCtanNA8v72mY29va2llg6dleHBpcmVz1_9yrekAZivk8a5vcmlnaW5hbE1heEFnZc4PcxQAqHNhbWVTaXRlpG5vbmU.hwhz%2BS9hCVUsOlWDbKdPlD7PzwUeTtKyE6uYAweEqUE; did=s%3Av0%3Abd518670-0013-11ef-be1a-130e83a63f36.p1DJLd%2F1w%2F7TAIcDgKsURtRGg%2BSB33egONXbFt7lFr8; did_compat=s%3Av0%3Abd518670-0013-11ef-be1a-130e83a63f36.p1DJLd%2F1w%2F7TAIcDgKsURtRGg%2BSB33egONXbFt7lFr8";

		RestAssured.baseURI  = "https://dev-0gvtu4ju4gyvqf1l.us.auth0.com";
		String response =  given().log().all().header("content-type", "application/x-www-form-urlencoded").header("Cookie", cookie).
				param("grant_type", "client_credentials").
				param("client_id", "Y2pc3Pv9fsyoCr0bA8lkgZZlFqHTlPP8").
				param("client_secret", "Ja7gmaQRWWhNpR5W1xZCEhgarDdhwt9Kuo5NVx9f3bvHeMJJ961z4toDf4e5-wLk").
				param("audience", "https://iyf04yly1b.execute-api.us-west-2.amazonaws.com/dev").
				when().post("/oauth/token").asString();

		System.out.println(response);



	}

	@Test
	public void Role() {
		String cook ="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Im9maklFalZ1UXp2T0xyTjgwRzlrXyJ9.eyJpc3MiOiJodHRwczovL2Rldi0wZ3Z0dTRqdTRneXZxZjFsLnVzLmF1dGgwLmNvbS8iLCJzdWIiOiJZMnBjM1B2OWZzeW9DcjBiQThsa2daWmxGcUhUbFBQOEBjbGllbnRzIiwiYXVkIjoiaHR0cHM6Ly9peWYwNHlseTFiLmV4ZWN1dGUtYXBpLnVzLXdlc3QtMi5hbWF6b25hd3MuY29tL2RldiIsImlhdCI6MTcxNTgzODIzMSwiZXhwIjoxNzE1OTI0NjMxLCJndHkiOiJjbGllbnQtY3JlZGVudGlhbHMiLCJhenAiOiJZMnBjM1B2OWZzeW9DcjBiQThsa2daWmxGcUhUbFBQOCJ9.U-cuSmpcki6GaRbelc6CLytPkaJObwrwrOeJuwmxKe1qi-3-v9kxaPGDtsj6m5UmUhYMCf_6R5SWG9lZC3hl17iaFf4WGT7KS-ylxfwuTJf2Ytf1LFge9Zn440_UF6wvOWZQM7hj7oOEmU2VJT3Ae3J5SVOy-Eqy2GxXgHh-HzFvwMJ-Ah53wjQiWZ7Lc_7BBQp3YYjPjfUIHyHAZYfJrHGaE2BZGE03isZnjrzyH1JR6BvRpyuNHEW5I7sNx_1BlBjZ2KXZT1n6oHm25hTt0P66nkPK-vdnn3zRJe437YP2v65OhLORo89rBm8k2RgvQswCXVjgIIM5JcCYR745KQ";

		RestAssured.baseURI = "https://iyf04yly1b.execute-api.us-west-2.amazonaws.com";
		String respons = given().header("Content-Type","application/json").header("Authorization",cook).
				body("{\n"
						+ "    \"tenant_domain\":\"cognitivzen.com\",\n"
						+ "    \"roles\": [\"IT Systems Operations\"]\n"
						+ "}").when().post("/dev/roles").then().log().all().extract().response().asString();
		System.out.println(respons);
	}

}
