package stepDefinitions;

import core.ConfigManager;
import core.apiclient;
import core.testContextclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

public class getUserStepDefn {

    apiclient client = new apiclient();
    private String endpoint = null;
    Response response = null;
    testContextclass transferresponse = new testContextclass();

    @Given("Get the user from geturl")
    public void getTheUserFromGeturl() {
        this.endpoint = ConfigManager.FrameworkProperties().getProperty("getUserurl");
    }


    @When("Providing the user to be retrieved")
    public void providingTheUserToBeRetrieved() {

        int id = transferresponse.getTransferingResponse().jsonPath().getInt("id");
       response = client.get(endpoint,id);
    }

    @Then("return the user")
    public void returnTheUser() {
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
