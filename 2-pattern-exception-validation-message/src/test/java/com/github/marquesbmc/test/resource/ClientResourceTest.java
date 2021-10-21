package com.github.marquesbmc.test.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.github.marquesbmc.model.Client;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.response.*;

@QuarkusTest
public class ClientResourceTest {

	/*
	 * @Test
	 * 
	 * @Order(1) public void testHelloEndpoint() { given() .when() .get("/client")
	 * .then() .statusCode(200) .body("name", hasItems("Bruno", "onurB")); }
	 */

	
	  @Test
	  @Order(2) 
	  public void updateById(){ 
		  Client client = new Client();
	  	  client.setName("Cavalo"); 
	  	  given() 
	  	  	.contentType(ContentType.JSON)
	  	  	.pathParam("id",1) 
	  	  	.body(client) 
	  	  	.when().put("/client/1")
	  	  	.then()
	  	  	.statusCode(200);}
	  	  //.body("name", is("Cavalo")); //, "balance", anything());}
	 

	/*private static String requestBody = "{\n" +
			 	"  \"id\": \"1\", 		\n" +   
			 	"  \"name\": \"Cavalo\",\n" +
	            "  \"birthDate\": \"\", \n" +
	            "  \"balance\": \"\",   \n" +
	            "  }";

	@Test
	public void putRequest() {
		io.restassured.response.Response response = given().header("Content-type", "application/json").and()
				.body(requestBody).when().put("/posts/1").then().extract().response();

		Assertions.assertEquals(200, response.statusCode());
		Assertions.assertEquals("Cavalo", response.jsonPath().getString("name"));
		Assertions.assertEquals("1", response.jsonPath().getString("id"));
	}*/

}
