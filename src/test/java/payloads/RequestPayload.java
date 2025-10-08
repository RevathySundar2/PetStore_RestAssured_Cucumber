package payloads;


import com.github.javafaker.Faker;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Random;

public class RequestPayload {
    public JSONObject buildPayload(){

        JSONObject data = new JSONObject();
        Faker faker;

        JSONArray users = new JSONArray();

        for(int i=0;i<6;i++) {
            faker = new Faker();
            JSONObject address = new JSONObject();
            address.put("city", faker.address().city());
            address.put("country", faker.address().country());
            address.put("zipcode", faker.address().buildingNumber());

            JSONObject user = new JSONObject();
            user.put("id", faker.idNumber().hashCode());
            user.put("name", faker.name().fullName());
            user.put("email", faker.internet().safeEmailAddress());
            user.put("address", address);
            user.put("phone", faker.phoneNumber().cellPhone());

            users.put(user);
        }

        data.put("data",users);

        return data;
    }
}
