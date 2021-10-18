package Rest_Api_Methods;



import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_001_Get_Request {

	@Test
	void get_Details() {

		RestAssured.baseURI ="https://reqres.in/api/users";

		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET, "/2");

		String responsebody = response.getBody().asString();
		System.out.println("The response body " + responsebody);

		int statusecode = response.statusCode();
		System.out.println("The status code is " + statusecode);


		String statusline = response.getStatusLine();
		System.out.println("The status line is "+ statusline);

	}



}
