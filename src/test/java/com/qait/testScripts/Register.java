package com.qait.testScripts;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Register {
	@SuppressWarnings({ "unchecked" })
	@Test
	public void enterCorrectInformation() {
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject formData = new JSONObject();
		formData.put("FirstName", "Abhishek");
		formData.put("LastName", "Tiwari");
		formData.put("UserName", "abhishbubyari");
		formData.put("Password", "jjj");
		formData.put("Email", "abhishj7h7hektiwari@gmail.com");
		httpRequest.body(formData);
		// Make a request to the server by specifying the method Type and the method
		// URL.
		// This will return the Response from the server. Store the response in a
		// variable.
		
		// Now let us print the body of the message to see what response
		// we have recieved from the server
		Response response = httpRequest.post("/register");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	@SuppressWarnings({ "unchecked" })
	@Test
	public void sendIncompleteInformation() {
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject formData = new JSONObject();
		formData.put("FirstName", "mkmkmkmkmk");
		formData.put("LastName", "vffokofk");
		System.out.println(formData);
		httpRequest.body(formData);
		// Make a request to the server by specifying the method Type and the method
		// URL.
		// This will return the Response from the server. Store the response in a
		// variable.
		
		// Now let us print the body of the message to see what response
		// we have recieved from the server
		Response response = httpRequest.post("/register");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 400);
	}
	@SuppressWarnings({ "unchecked" })
	@Test
	public void usingWrongBodyParametersInformation() {
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject formData = new JSONObject();
		formData.put("firstName", "mkmkmkmkmk");
		formData.put("lastName", "vffokofk");
		formData.put("userName", "kj8j09ko");
		formData.put("password", "uj9j98j9");
		formData.put("email", "90k000k@gmail.com");
		System.out.println(formData);
		httpRequest.body(formData);
		// Make a request to the server by specifying the method Type and the method
		// URL.
		// This will return the Response from the server. Store the response in a
		// variable.
		
		// Now let us print the body of the message to see what response
		// we have recieved from the server
		Response response = httpRequest.post("/register");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 400);
	}
}
