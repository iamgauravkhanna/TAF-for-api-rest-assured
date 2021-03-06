package project04;

import api.RestOperations;
import api.RequestSpecificationBuilder;
import assertions.AssertionManager;
import base.BaseTest;
import constants.TestConstants;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static constants.TestConstants.SCHEMA_PATH;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.hasItems;
import static org.testng.AssertJUnit.assertNotNull;

public class GoRestJsonResponseTest extends BaseTest {

    @Test(description = "Test to validate user details schema", enabled = true)
    public void validateUserDetailsJsonSchema() {
        RequestSpecification requestSpecification = RequestSpecificationBuilder.getRequestSpecWithFilters();
        Response response = RestOperations.get(requestSpecification, "/users/2539");
        ValidatableResponse validatableResponse = response.then();

        AssertionManager.assertResponse(validatableResponse,SCHEMA_PATH + "/user-schema.json");
        AssertionManager.assertEquals(validatableResponse.extract().statusCode(), 200, TestConstants.ASSERTION_FOR_RESPONSE_STATUS_CODE);
        AssertionManager.assertNotNull(validatableResponse.extract().body().jsonPath().get("id"), "'id' should not be null");
        AssertionManager.assertNotNull(validatableResponse.extract().body().jsonPath().get("name"), "'name' should not be null");
        AssertionManager.assertNotNull(validatableResponse.extract().body().jsonPath().get("email"), "'email' should not be null");
    }

    @Test(description = "Test to validate user details schema for multiple users",enabled = true)
    public void validateUserDetailsJsonSchemaArray() {
        RequestSpecification requestSpecification = RequestSpecificationBuilder.getRequestSpecWithFilters();
        Response response = RestOperations.get(requestSpecification, "/users");
        ValidatableResponse validatableResponse = response.then();

        AssertionManager.assertResponse(validatableResponse,SCHEMA_PATH + "/user-schema-array.json");
        validatableResponse.body("findAll {gender='female'}.name", hasItems(" Geetanjali Trivedi"));
    }

}