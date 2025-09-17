package core;

import com.github.javafaker.Faker;
import io.cucumber.java.Before;
import payloads.UserPOJO;

import java.util.ArrayList;
import java.util.List;

public class setupData {

    UserPOJO userPayload = new UserPOJO();
    Faker faker = new Faker();

    public UserPOJO setupUserData()
    {
        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUserName(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password());
        userPayload.setPhone(faker.phoneNumber().cellPhone());

        return userPayload;
    }


}
