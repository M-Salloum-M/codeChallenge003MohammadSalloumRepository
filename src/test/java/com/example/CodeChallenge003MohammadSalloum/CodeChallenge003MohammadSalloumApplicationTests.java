package com.example.CodeChallenge003MohammadSalloum;

import com.example.CodeChallenge003MohammadSalloum.model.Customer;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class CodeChallenge003MohammadSalloumApplicationTests {

	@Test
	void contextLoads() {

		Customer customer = new Customer();
		customer.setAddress("Beirut");
		customer.setMobileNumber("+96171307046");
		customer.setName("mohammad");


		assertEquals("Beirut", customer.getAddress());
		assertEquals("+96171307046", customer.getMobileNumber());
		assertEquals("mohammad", customer.getName());
	}
	@Test
	public void CheckValidationAPI()
	{
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://phonevalidation.abstractapi.com/v1/";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		Response response = httpRequest.request(Method.GET, "?api_key=398f411e54ce4c479a33f207c9ab57ac&phone=+96171307046");

		// Now let us print the body of the message to see what response
		// we have recieved from the server
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);

	}


}
