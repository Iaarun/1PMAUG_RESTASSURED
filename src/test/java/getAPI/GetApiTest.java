package getAPI;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class GetApiTest {

	@Test
	public void testSingleUserAPI() {
		RestAssured.baseURI = "https://reqres.in";

		
	Response response=	given()
		.when()
		.get("/api/users/2")
		.then()
		.extract()
		.response();
	
	 System.out.println(response.getStatusCode());
	 System.out.println(response.getStatusLine());
	 System.out.println(response.getTime());
	 
	 System.out.println(response.asPrettyString());
	  JsonPath jp =   response.jsonPath(); 
	  String fname= jp.get("data.first_name");
	  
	  System.out.println(fname);
	  
	 System.out.println(response.getContentType());
	 
	 System.out.println(response.getHeader("Server"));
	 
	 System.out.println("All headers");
	   Headers headers=  response.headers();
	   
	   for(Header x: headers) {
		   System.out.println(x.getName()+"|"+x.getValue());
	   }
	}

}
