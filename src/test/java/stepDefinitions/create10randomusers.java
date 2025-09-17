package stepDefinitions;

import core.ConfigManager;
import core.apiclient;

import core.setupData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import payloads.UserPOJO;
import payloads.createMultipleUsers;

import java.util.List;

public class create10randomusers {

        private String endpoint;
        apiclient client = new apiclient();
        Response response;

        @Given("^I hit the create user url$")
        public void creating_a_new_user() {
            this.endpoint=ConfigManager.FrameworkProperties().getProperty("createuserurl");
        }


      @When("I want to create {int} random users")
      public void iWantToCreateRandomUsers(int n) {

         createMultipleUsers userdata = new createMultipleUsers();
         List<UserPOJO> usersList = userdata.generatemultipleusers(n);

         for(UserPOJO user : usersList)
         {
             response = client.post(endpoint, user);
             response.then().log().all();
             Assert.assertEquals(200, response.getStatusCode());

         }
      }

    @Then("{int} random users created successfully")
    public void randomUsersCreatedSuccessfully(int arg0) {

    }
}
