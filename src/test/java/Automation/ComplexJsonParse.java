package Automation;

import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	
	public static void main(String[] args) {
		JsonPath js = new JsonPath(payload.courseprice());
		
	int num =	js.getInt("courses.size()");
	System.out.println(num);
	
	int num1 = js.getInt("dashboard.purchaseAmount");
	System.out.println(num1);
	
	String course = js.getString("courses[2].title");
	System.out.println(course);
	
	//`(//input[@type='checkbox'])[${i}]`
	for(int i=0; i<3; i++) {
	String coursetitle = js.getString("courses[" + i + "].title");
	System.out.println(coursetitle);
	}
	for(int i=0; i<3; i++) {
	String num2 = js.getString("courses[" + i + "].title");
	if(num2.equalsIgnoreCase("RPA")) {
		int count =  js.get("courses["+i+"].copies");
		System.out.println(count);
	}
	}
	
	}
	
	
}
