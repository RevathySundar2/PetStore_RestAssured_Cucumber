package stepDefinitions;

import core.ConfigManager;
import core.apiclient;
import core.testContextclass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import utility.OutputFile;

import java.util.HashMap;
import java.util.Map;

public class getUserStepDefn {

    apiclient client = new apiclient();
    private String endpoint = null;
    Response response = null;

    Map<Integer, String> user = new HashMap<>();


    @Given("Read the userid from the csv file")
    public void readTheUseridFromTheCsvFile() {
        OutputFile out = new OutputFile();
        user = out.readFromCSV();
    }

    @When("Retrieve the user details")
    public void retrieveTheUserDetails() {
        this.endpoint=ConfigManager.FrameworkProperties().getProperty("getUserurl");
        for(Map.Entry us : user.entrySet()) {
            response = client.get(endpoint, (String) us.getValue());

        }

    }

    @Then("Display the user details")
    public void displayTheUserDetails() {
        response.then().log().all();
    }

    @And("Response code is {int}")
    public void responseCodeIs(int arg0) {
        Assert.assertEquals(200,response.getStatusCode());
    }
}
