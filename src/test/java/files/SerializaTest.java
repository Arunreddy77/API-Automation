package files;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import POJO.AddPlace;
import POJO.Location;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SerializaTest {


	@Test
	public void serialize() {

		AddPlace Ap = new AddPlace();
		Ap.setAccuracy(50);
		Ap.setAddress("29, side layout, cohen 09");
		Ap.setLanguage("French-IN");
		Ap.setName("Frontline house");
		Ap.setPhone_number("(+91) 983 893 3937");
		Ap.setWebsite("http://google.com");
		List<String> mylist = new ArrayList<String>();
		mylist.add("shop");
		mylist.add("shoe park");
		Ap.setTypes(mylist);
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		Ap.setLocation(l);

		RestAssured.baseURI="https://rahulshettyacademy.com";
		Response res =  given().queryParams("key", "qaclick123").headers("Content-Type","application/json")
				.body(Ap).when().post("maps/api/place/add/json")
				.then().log().all().assertThat().statusCode(200).extract().response();
		
	}
}
