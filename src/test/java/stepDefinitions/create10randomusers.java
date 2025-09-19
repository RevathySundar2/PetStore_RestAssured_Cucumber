package stepDefinitions;

import com.google.gson.JsonObject;
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
import utility.OutputFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class create10randomusers {

        private String endpoint;
        apiclient client = new apiclient();
        Response response;
       Map<Integer, String> userdetails = new HashMap<Integer, String>();

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

             int userid = Integer.parseInt(response.jsonPath().getString("message"));

             userdetails.put(userid, user.getUserName());
             response.then().log().all();
             Assert.assertEquals(200, response.getStatusCode());
         }
      }

    @Then("{int} random users created successfully")
    public void randomUsersCreatedSuccessfully(int arg0) {
        for (Map.Entry<Integer, String> entry : userdetails.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
          OutputFile.saveToCSV(userdetails);
    }

}
