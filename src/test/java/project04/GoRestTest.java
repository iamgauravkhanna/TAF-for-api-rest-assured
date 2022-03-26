package project04;

import api.RestOperations;
import assertions.VerificationManager;
import base.BaseTest;
import constants.TestConstants;
import filters.RestAssuredRequestFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertNotNull;

public class GoRestTest extends BaseTest {

    private static final String BASE_URI = "https://gorest.co.in/public/v2/users";

    @Test(description = "Test to validate user details")
    public void validateUserDetailsJsonSchema() {

        RequestSpecification requestSpecification = given()
                .filter(new RestAssuredRequestFilter())
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .baseUri(BASE_URI).
                when();

        Response response = RestOperations.get(requestSpecification,"/2539");

        ValidatableResponse validatableResponse = response.then();

        VerificationManager.assertEquals(validatableResponse.extract().statusCode(), 200, TestConstants.ASSERTION_FOR_RESPONSE_STATUS_CODE);
        VerificationManager.assertNotNull(validatableResponse.extract().body().jsonPath().get("id"), "'id' should not be null");
        VerificationManager.assertNotNull(validatableResponse.extract().body().jsonPath().get("name"), "'name' should not be null");
        VerificationManager.assertNotNull(validatableResponse.extract().body().jsonPath().get("email1"), "'email' should not be null");
    }
}
