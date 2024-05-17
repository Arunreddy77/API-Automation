package files;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class DynamicJSON {

	
	@Test(dataProvider = "booksdata")
	public void addbook(String isbn, String aisle) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response =  given().log().all().header("Content-Type", "application/json").
		body(payload.AddBook(isbn,aisle)).
		when().post("/Library/Addbook.php").
		then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		//System.out.println(response);
		
		JsonPath js = ReUseableMethods.rawToJson(response);
		String id = js.get("ID");
		System.out.println(id);
	}
	
	@DataProvider(name = "booksdata")
	public Object[][] getdata() {
		
		return new Object[][] {{"uhfi","4964"},{"eefwr","6845"},{"okfh","8253"},{"olth","2357"}};
		
	}
}





