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

    public Response get(String path, int id)
    {
        Response response = given()
                                .spec(requestSpecFactory.get())
                            .when()
                                 .get(path)
                            .then()
                                 .extract().response();

        return response;

    }
}

