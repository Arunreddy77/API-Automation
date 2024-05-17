package Automation;

import org.testng.Assert;
import org.testng.reporters.jq.Main;

import files.ReUseableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostAPI {

	
	public static void main(String[] args) {
		
		
		// given - all input details 
		//when - submit the API- resource, http method
		//then - validate the response
		
		
		//Post API
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response =  given().log().all().queryParams("key", "qaclick123").headers("Content-Type","application/json")
		.body(payload.addplace()).when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js = new JsonPath(response);
		String placeid = js.getString("place_id");
		System.out.println(placeid);
		
		//PUT API
		String newAddress = "Summer Walk, Rajasthan";
		String s1 = given().log().all().queryParam("key", "qaclick123").headers("Content-Type","application/json")
		.body("{\n"
				+ "    \"place_id\": \""+placeid+"\",\n"
				+ "    \"address\": \""+newAddress+"\",\n"
				+ "    \"phone_number\": \"(+91) 984 802 2338\",\n"
				+ "    \"key\": \"qaclick123\"\n"
				+ "}").
		when().put("maps/api/place/update/json")
		.then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"))
		.extract().response().asString();
		System.out.println(s1);
		
		
		//GET API
		String GetResponse =  given().log().all().queryParam("key", "qaclick123")
		.queryParam("place_id", placeid).when().get("maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
		
		JsonPath js1 = ReUseableMethods.rawToJson(GetResponse);
		String updatedAddress = js1.getString("address");
		System.out.println(updatedAddress);
		Assert.assertEquals(newAddress, updatedAddress);
}
}








