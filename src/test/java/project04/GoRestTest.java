package project04;

import api.RestOperations;
import api.SpecificationBuilder;
import assertions.VerificationManager;
import base.BaseTest;
import constants.TestConstants;
import filters.RestAssuredRequestFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import logger.MyLogger;
import org.testng.annotations.Test;

import java.io.File;

import static constants.TestConstants.SCHEMA_PATH;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.testng.AssertJUnit.assertNotNull;

public class GoRestTest extends BaseTest {

    @Test(description = "Test to validate user details")
    public void validateUserDetailsJsonSchema() {

        RequestSpecification requestSpecification = SpecificationBuilder.getRequestSpecWithFilters();
        Response response = RestOperations.get(requestSpecification,"/2539");
        ValidatableResponse validatableResponse = response.then();
        //String userSchemaPath = SCHEMA_PATH + "/user-schema.json" ;
        validatableResponse.body(matchesJsonSchemaInClasspath("user-schema.json"));

        VerificationManager.assertEquals(validatableResponse.extract().statusCode(), 200, TestConstants.ASSERTION_FOR_RESPONSE_STATUS_CODE);
        VerificationManager.assertNotNull(validatableResponse.extract().body().jsonPath().get("id"), "'id' should not be null");
        VerificationManager.assertNotNull(validatableResponse.extract().body().jsonPath().get("name"), "'name' should not be null");
        VerificationManager.assertNotNull(validatableResponse.extract().body().jsonPath().get("email1"), "'email' should not be null");
    }
}
