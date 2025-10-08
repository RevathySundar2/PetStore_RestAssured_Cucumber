package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import payloads.RequestPayload;
import utility.DBUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class SampleForLearning {

    public static JSONObject userpayload;
    List<Map<String,String>> expectedUsers = new ArrayList<>();

    @Given("Read the sample request")
    public void readTheSampleRequest() {

        RequestPayload request = new RequestPayload();
        userpayload = request.buildPayload();

        System.out.println(userpayload.toString(2));// pretty print


    }

    @When("Parse the payload")
    public void parseThePayload() throws SQLException {

       JSONArray lstUsers = userpayload.getJSONArray("data");

       for (int i=0 ; i<lstUsers.length();i++){
          int userid = userpayload.getJSONArray("data").getJSONObject(i).getInt("id");
          String username = userpayload.getJSONArray("data").getJSONObject(i).getString("name");
          String phone = userpayload.getJSONArray("data").getJSONObject(i).getString("phone");
          String email = userpayload.getJSONArray("data").getJSONObject(i).getString("email");

          JSONObject address = (JSONObject) userpayload.getJSONArray("data").getJSONObject(i).get("address");

          String city = address.getString("city");
          String zipcode = address.getString("zipcode");
          String country = address.getString("country");

           Map<String,String> userRecord = new HashMap<>();

           userRecord.put("id", String.valueOf(userid));
           userRecord.put("name", username);
           userRecord.put("phone", String.valueOf(phone));
           userRecord.put("email", email);
           userRecord.put("city", city);
           userRecord.put("country", country);
           userRecord.put("zipcode", zipcode);

          System.out.println(userRecord);

           expectedUsers.add(userRecord);

           DBUtils db = new DBUtils();
           db.addUser(userRecord);
       }
    }

    @Then("Assert the userdetails with the database")
    public void assertTheUserdetailsWithTheDatabase() throws SQLException {
        List<Map<String,Object>> userDBTable = DBUtils.readUserData();
        List<Map<String, Object>> foundrecords = new ArrayList<>();

        for(Map<String, String> expecteduser : expectedUsers)
        {
            for(Map<String, Object> row : userDBTable)
            {
                if(rowMatchExpected(expecteduser, row))
                {
                    foundrecords.add(row);
                    break;
                }
            }
        }

        if(!foundrecords.isEmpty())
        {
            System.out.println("Rows found in the DB are : \n ");
            for (Map<String, Object> row : foundrecords)
            {
                System.out.println(row.entrySet());
            }
        }
    }

    private boolean rowMatchExpected(Map<String, String> expecteduser, Map<String, Object> row) {

        for(Map.Entry<String,String> entry: expecteduser.entrySet())
        {
            Object value = row.get(entry.getKey());
            if(value == null || !String.valueOf(value).equals(entry.getValue()))
            {
                return false;
            }
        }
        return true;
    }


}
