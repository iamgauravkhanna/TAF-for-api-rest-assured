package assertions;

import org.testng.Assert;
import logger.MyLogger;

public class VerificationManager {

    public static void assertEquals(Object actual, Object expected,String message){
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
}
