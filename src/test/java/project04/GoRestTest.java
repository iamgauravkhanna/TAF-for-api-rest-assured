package project04;

import api.RestOperations;
import api.RequestSpecificationBuilder;
import assertions.VerificationManager;
import base.BaseTest;
import constants.TestConstants;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.hasItems;
import static org.testng.AssertJUnit.assertNotNull;

public class GoRestTest extends BaseTest {

    @Test(description = "Test to validate user details", enabled = true)
    public void validateUserDetailsJsonSchema() {
        RequestSpecification requestSpecification = RequestSpecificationBuilder.getRequestSpecWithFilters();
        Response response = RestOperations.get(requestSpecification, "/2539");
        ValidatableResponse validatableResponse = response.then();
//        String userSchemaPath = SCHEMA_PATH + "/user-schema.json" ;
//        MyLogger.INFO(userSchemaPath);
        validatableResponse.body(matchesJsonSchemaInClasspath("user-schema.json"));

        VerificationManager.assertEquals(validatableResponse.extract().statusCode(), 200, TestConstants.ASSERTION_FOR_RESPONSE_STATUS_CODE);
        VerificationManager.assertNotNull(validatableResponse.extract().body().jsonPath().get("id"), "'id' should not be null");
        VerificationManager.assertNotNull(validatableResponse.extract().body().jsonPath().get("name"), "'name' should not be null");
        VerificationManager.assertNotNull(validatableResponse.extract().body().jsonPath().get("email"), "'email' should not be null");
    }

    @Test(description = "Test to validate user details for multiple users",enabled = true)
    public void validateUserDetailsJsonSchemaArray() {
        RequestSpecification requestSpecification = RequestSpecificationBuilder.getRequestSpecWithFilters();
        Response response = RestOperations.get(requestSpecification, "/");
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.body(matchesJsonSchemaInClasspath("user-schema-array.json"));
        validatableResponse.body("findAll {gender='female'}.name", hasItems("Niro Ahuja"));
    }

    // TODO
    // File Upload Tests

}
