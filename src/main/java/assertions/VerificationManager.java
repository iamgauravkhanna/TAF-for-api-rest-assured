package assertions;

import constants.TestConstants;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import logger.TestLogger;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class VerificationManager {

    public static void assertEquals(Object actual, Object expected, String message) {
        try {
            Assert.assertEquals(actual, expected, message);
            TestLogger.PASS(
                    message + "   |   <b><i>Actual: </i> </b>" + actual + " and <b><i> Expected: </i> </b>" + expected);
        } catch (AssertionError assertionError) {
            TestLogger.FAIL(
                    message + "   |   <b><i>Actual: </i> </b>" + actual + " and <b><i> Expected: </i> </b>" + expected);
            Assert.fail(message);
        }
    }

    public static void assertNotNull(Object id, String expected) {
        try {
            Assert.assertNotNull(id);
            TestLogger.PASS(
                    TestConstants.ASSERTION_FOR_NON_NULLABLE_FIELD + "   |   <b><i>Actual: </i> </b>" + "Object was not null" + " and <b><i> Expected: </i> </b>" + expected);
        } catch (AssertionError assertionError) {

            TestLogger.FAIL(
                    TestConstants.ASSERTION_FOR_NON_NULLABLE_FIELD + "   |   <b><i>Actual: </i> </b>" + "Object was null" + " and <b><i> Expected: </i> </b>" + expected);
            Assert.fail(expected);
        }
    }

    public static void assertResponse(ValidatableResponse validatableResponse, String schemaPath){
        try {
            validatableResponse.body(matchesJsonSchema(new File(schemaPath)));
            TestLogger.INFO_STEP("Scheme Verification was Successful");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
