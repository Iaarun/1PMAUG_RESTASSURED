package getAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PostAPITest {
	
	public String reqBody() {
		return "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
	}
	
	@Test
	public void createUser() {
		RestAssured.baseURI="https://reqres.in";
		
	Response response=	given()
		.contentType(ContentType.JSON)
		.body(reqBody())
		.when()
		.post("/api/users")
		.then()
		.extract()
		.response();
	
	System.out.println(response.asPrettyString());
	
	Assert.assertEquals(response.getStatusCode(),201);
			
		
		
	}

}
