package core;

import com.github.javafaker.Faker;
import io.cucumber.java.Before;
import payloads.UserPOJO;

public class setupData {
    Faker faker = new Faker();
    UserPOJO userPayload = new UserPOJO();


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
