package core;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class apiclient {
    public Response post(String path, Object body)
    {
        return given()
                    .spec(requestSpecFactory.get())
                    .body(body)
                .when()
                    .post(path)
                .then()
                    .extract().response();
    }

    public Response get(String path, String username)
    {
        Response response = given()
                                .spec(requestSpecFactory.get())
                                .pathParam("username", username)
                                .log().all()
                            .when()
                                 .get(path+"{username}")
                            .then()
                                 .log().all()
                                 .extract().response();

        return response;

    }
}

