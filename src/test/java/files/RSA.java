package files;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import POJO.Api;
import POJO.GetCourse;
import POJO.WebAutomation;
import files.ReUseableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RSA {

	@Test
	public void token() {

		//RestAssured.baseURI = "https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token";

		String response = 	given().log().all().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W").
				formParam("grant_type", "client_credentials").
				formParam("scope", "trust").
				when().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();

		System.out.println(response);
		JsonPath js = new JsonPath(response);
		String token = js.getString("access_token");
		System.out.println(token);
		
		GetCourse  gc =  given().queryParam("access_token", token).
		when().log().all().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetCourse.class);
		
		System.out.println(gc.getLinkedIn());
		System.out.println(gc.getInstructor());
		System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
		System.out.println(gc.getCourses().getApi().get(1).getPrice());
		
		List<Api> apicourses = gc.getCourses().getApi();
		for(int i=0; i<apicourses.size(); i++) {
			if(apicourses.get(i).getCourseTitle().equalsIgnoreCase("Rest Assured Automation using Java"))
			System.out.println(apicourses.get(i).getPrice());
		}
		
		String[] courseList = {"Selenium Webdriver Java","Cypress", "Protractor"};
		
		ArrayList<String> actual = new ArrayList<String>();
		List<WebAutomation> b = gc.getCourses().getWebAutomation();
		for(int j=0; j<b.size(); j++) {
			actual.add(gc.getCourses().getWebAutomation().get(j).getCourseTitle());
		}
		List<String> expected = Arrays.asList(courseList);  //courselist id is Array, so converting to list.
		
		Assert.assertTrue(actual.equals(expected));
	}
}








