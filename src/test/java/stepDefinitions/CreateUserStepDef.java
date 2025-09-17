package stepDefinitions;

import core.ConfigManager;
import core.apiclient;
import core.testContextclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Assert;
import payloads.UserPOJO;
import core.setupData;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class CreateUserStepDef {

    private String endpoint;
    apiclient client = new apiclient();
   // testContextclass transferresponse = new testContextclass();

    Response response = null;
    @Given("Creating a new user")
    public void creating_a_new_user() {
       this.endpoint=ConfigManager.FrameworkProperties().getProperty("createuserurl");
    }
    @When("Entering new user details")
    public void entering_new_user_details() {

        setupData userdata = new setupData();
        UserPOJO user = userdata.setupUserData();
        response = client.post(endpoint, user);
       // transferresponse.setTransferingResponse(response);
    }
    @Then("User created with status {int}")
    public void user_created_with_status(Integer int1) {
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }

}
