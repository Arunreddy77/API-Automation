package files;

import io.restassured.path.json.JsonPath;

public class ReUseableMethods {

	public static JsonPath rawToJson(String Response) {
		JsonPath js1 = new JsonPath(Response);
		return js1;
	}
}
