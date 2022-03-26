package assertions;

import constants.TestConstants;
import org.testng.Assert;
import logger.MyLogger;

public class VerificationManager {

    public static void assertEquals(Object actual, Object expected, String message) {
        try {
            Assert.assertEquals(actual, expected, message);
            MyLogger.PASS(
                    message + "   |   <b><i>Actual: </i> </b>" + actual + " and <b><i> Expected: </i> </b>" + expected);
        } catch (AssertionError assertionError) {
            MyLogger.FAIL(
                    message + "   |   <b><i>Actual: </i> </b>" + actual + " and <b><i> Expected: </i> </b>" + expected);
            Assert.fail(message);
        }
    }

    public static void assertNotNull(Object id, String expected) {
        try {
            Assert.assertNotNull(id);
            MyLogger.PASS(
                    TestConstants.ASSERTION_FOR_NON_NULLABLE_FIELD + "   |   <b><i>Actual: </i> </b>" + "Object was not null" + " and <b><i> Expected: </i> </b>" + expected);
        } catch (AssertionError assertionError) {

            MyLogger.FAIL(
                    TestConstants.ASSERTION_FOR_NON_NULLABLE_FIELD + "   |   <b><i>Actual: </i> </b>" + "Object was null" + " and <b><i> Expected: </i> </b>" + expected);
            Assert.fail(expected);
        }
    }
}
