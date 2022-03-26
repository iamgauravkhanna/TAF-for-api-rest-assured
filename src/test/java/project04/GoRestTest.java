package project04;

import assertions.VerificationManager;
import constants.FrameworkConstants;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertNotNull;

public class GoRestTest {

    private static final String BASE_URI= "https://gorest.co.in/public/v2/users";

    @Test
    public void validateUserDetailsJsonSchema() {
        ValidatableResponse response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .baseUri(BASE_URI)
                .when()
                .get("/2539")
                .then();

        System.out.println("GET Response:\n" + response.extract().body().asString());

        // Verify the status code
        Assert.assertEquals(response.extract().statusCode(), 200);
        VerificationManager.assertEquals(response.extract().statusCode(), 200, FrameworkConstants.ASSERTION_FOR_RESPONSE_STATUS_CODE);

        VerificationManager.assertNotNull(response.extract().body().jsonPath().get("id1"),FrameworkConstants.ASSERTION_FOR_NON_NULLABLE_FIELD);
        // Verify the response attributes
       // assertNotNull("'id' should not be null", response.extract().body().jsonPath().get("id"));
        assertNotNull("'name' should not be null", response.extract().body().jsonPath().get("name"));
        assertNotNull("'email' should not be null", response.extract().body().jsonPath().get("email"));
    }

}
