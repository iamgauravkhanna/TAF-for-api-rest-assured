package api;

import io.restassured.response.Response;

import static api.SpecBuilder.*;

import static io.restassured.RestAssured.given;

public class RestOperations {

    public static Response post(String path, Object requestBody) {
        return given(getRequestSpec()).
                body(requestBody).
                when().
                post(path).
                then().
                spec(getResponseSpec()).
                extract().
                response();
    }

}
