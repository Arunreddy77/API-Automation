package Ecommerce;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class EcommerceAPI {


	@Test
	public void api() {
		//Login
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
				setContentType(ContentType.JSON).build();

		LoginRequest loginreq = new LoginRequest();
		loginreq.setUserEmail("arunreddy7444@gmail.com");
		loginreq.setUserPassword("Arun@742");

		RequestSpecification reqlogin = given().log().all().spec(req).body(loginreq);
		LoginResponse loginresponse = reqlogin.when().post("/api/ecom/auth/login").
				then().log().all().extract().response().as(LoginResponse.class);

		System.out.println(loginresponse.getToken());
		String token = loginresponse.getToken();
		System.out.println(loginresponse.getUserId());
		String id = loginresponse.getUserId();

		//Add Product
		RequestSpecification AddProd = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
				addHeader("Authorization", token).build();
		RequestSpecification reqAddProduct = given().log().all().spec(AddProd).param("productName", "Iron Man").
				param("productAddedBy", id).
				param("productCategory", "fashion").
				param("productSubCategory", "shirts").param("productDescription", "Marvels").param("productPrice", "7444")
				.param("productFor", "Men").multiPart("productImage",  new File("/home/arunkumar/Downloads/iron man.jpg"));

		String response = reqAddProduct.when().post("/api/ecom/product/add-product").then().log().all().
				extract().response().asString();
		JsonPath js = new JsonPath(response);
		String prodId = js.getString("productId");
		System.out.println(prodId);


		//Create Order
		RequestSpecification CreateOrder = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
				addHeader("Authorization", token).setContentType(ContentType.JSON).build();
		OrderDetails orderdetails = new OrderDetails();
		orderdetails.setCountry("India");
		orderdetails.setProductOrderedId(prodId);

		List<OrderDetails> 	orderdetailslist = new ArrayList<OrderDetails>();
		orderdetailslist.add(orderdetails);
		pojoOrder orders = new pojoOrder();
		orders.setOrders(orderdetailslist);

		RequestSpecification ordercreation =  given().log().all().spec(CreateOrder).body(orders);
		String response1 =  ordercreation.when().post("/api/ecom/order/create-order").
				then().log().all().extract().response().asString();

		//Delete Product
		RequestSpecification deleteprod = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
				addHeader("Authorization", token).setContentType(ContentType.JSON).build();
		
		RequestSpecification prodDelete = given().log().all().spec(deleteprod).pathParam("productId", prodId);
		String response2 =prodDelete.when().delete("/api/ecom/product/delete-product/{productId}").then().log().all().
		extract().response().asString();
		JsonPath js1 = new JsonPath(response2);
		System.out.println(js1.getString("message"));
	}
}

	


