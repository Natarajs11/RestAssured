package Rest_Api_Methods;



import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_002_Post_Request {
	
	@Test
	void get_post_data() {
		
		RestAssured.baseURI= "https://reqres.in/api/users";
		
		RequestSpecification httprequest = RestAssured.given();
		
		JSONObject requestparams = new JSONObject();
		requestparams.put("name", "morpheus");
		requestparams.put("Job", "Leader");
		requestparams.put("id", 174);
		
		httprequest.header("content-type","application/json");
		
		httprequest.body(requestparams.toJSONString());
		
		Response response = httprequest.request(Method.POST,"/register");
		
		String responsebody = response.getBody().asString();
		System.out.println("The response body " + responsebody);

		int statusecode = response.statusCode();
		System.out.println("The status code is " + statusecode);
		Assert.assertEquals(201, 201);


		String statusline = response.getStatusLine();
		System.out.println("The status line is "+ statusline);
		
		//capture the header inforamtion
		String content = response.header("Content-Type");
		System.out.println(content);
		
		String date = response.header("Date");
		System.out.println(date);
		
		
		System.out.println(response.getHeaders());
		
		
		
		
		
	}

}
