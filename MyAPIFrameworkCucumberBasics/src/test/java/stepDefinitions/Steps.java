/*
package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.APIResouces;
import resources.TestPlacePayLoad;
import resources.Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Steps extends Utils
{


    RequestSpecification req;
    ResponseSpecification resseq;
    Response response;
    RequestSpecification res;          //we have to build res for every given Scenario
    static String place_id;         //use same variable for all scenarios otherwise it become null when new scenarios get started

    //JsonPath js;
    //String placeid;

    TestPlacePayLoad data = new TestPlacePayLoad();

    @Given("Add Place Payload {string} {string} {string}")
    public void add_place_payload(String name, String language, String address) throws IOException {

        req = requestSpecification();

        res = given().spec(req).body(data.addPlacePayLoad(name, language, address));



    }

    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String resource, String method) {

        System.out.println("Inside user calls with method " + method);
        //constructor will be called with value of resource which you pass
        APIResouces resAPI = APIResouces.valueOf(resource);       // call the enum constructor with this value
        System.out.println(resAPI.getResource());

        resseq = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

        //response = res.when().post("/maps/api/place/add/json")
        if (method.equalsIgnoreCase("POST")) {           // instead of hardcode now it can accept any http request
            response = res.when().post(resAPI.getResource());
                    //.then().spec(resseq).extract().response();      we do it in another step

        }
        else if (method.equalsIgnoreCase("GET")) {
            response = res.when().post(resAPI.getResource());

        }
        //System.out.println("Exit user calls with method " + method);
    }
    @Then("the API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(Integer int1) {

        //System.out.println("Inside the API call got success with status code " + int1);
        //System.out.println(response);
        assertEquals(response.getStatusCode(),200);

        //String responseString=response.asString();

       // System.out.println(responseString);

        //System.out.println("Exit the API call got success with status code " + int1);

    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String expectedKey, String expectedValue) {

        // String resp = response.asString();        instead of calling the JsonPath multiple time we have make it generic (in util) so we can we it anywhere
        // JsonPath js = new JsonPath(resp);

        assertEquals(getJsonPath(response,expectedKey),expectedValue);

    }


    @And("verify place_Id created map to {string} using {string}")
    public void verifyPlace_IdCreatedMapToUsing(String expectedName, String resource) throws IOException {
        place_id = getJsonPath(response,"place_id");

        System.out.println("\nPlace ID : "+place_id+"\n");

        res = given().spec(requestSpecification()).queryParam("place_id", place_id);
        user_calls_with_http_request(resource,"GET");
        String actualName = getJsonPath(response,"name");

        //System.out.println(response.asString());

        assertEquals(actualName,expectedName);


    }

    @Given("DeletePlace Payload")
    public void delete_place_payload() throws IOException {

        System.out.println("inside delete_place_payload");

        res = given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
        System.out.println("Exit delete_place_payload");
    }

}
*/


package stepDefinitions;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Location;
import pojo.AddPlace;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Steps extends Utils {
    //String place_id;
    TestDataBuild data=new TestDataBuild();
    RequestSpecification res;
    Response response;
    ResponseSpecification resspec;
    static String place_id;
    JsonPath js;
    @Given("Add Place Payload with {string} {string} {string}")
    public void add_place_payload_with(String name,String language,String address) throws IOException {

        //Request specification
        res=given().spec(requestSpecification())
                .body(data.addPlacePayload(name,language,address));


    }
    @When("User calls {string} with {string} http request")
    public void user_calls_with_http_request(String resource, String method) {
        // Constructor will be called with value of resource which you pass
        APIResources resourceAPI = APIResources.valueOf(resource);
        System.out.println(resourceAPI.getResource());

        resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        if(method.equalsIgnoreCase("POST"))
            response = res.when().post(resourceAPI.getResource());
        else if(method.equalsIgnoreCase("GET"))
            response = res.when().get(resourceAPI.getResource());

    }
    @Then("the API call is success with status code {int}")
    public void the_api_call_is_success_with_status_code(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(response.getStatusCode(),200);
    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String Expectedvalue) {
        // Write code here that turns the phrase above into concrete actions

        assertEquals(getJsonPath(response,keyValue),Expectedvalue);

    }

    @Then("verify place_Id created maps to {string} using {string}")
    public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
        //requestSpec
        place_id= getJsonPath(response,"place_id");

        res=given().spec(requestSpecification()).queryParam("place_id",place_id);
        user_calls_with_http_request(resource,"GET");
        String actualName=getJsonPath(response,"name");
        assertEquals(actualName,expectedName);
    }

    @Given("DeletePlace payload")
    public void delete_place_payload() throws IOException {
        res= given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
    }



}
