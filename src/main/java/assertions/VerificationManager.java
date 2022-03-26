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

    public static void assertNotNull(Object id, String message) {
        try{
            Assert.assertNotNull(id);
            MyLogger.PASS(
                    message + "   |   <b><i>Actual: </i> </b>" + "Object was not null" + " and <b><i> Expected: </i> </b>" + "Object should not be null");
        }        catch (Exception exception ){
            MyLogger.FAIL(
                    message + "   |   <b><i>Actual: </i> </b>" + "Object was not null" + " and <b><i> Expected: </i> </b>" + "Object should not be null");
            Assert.fail(message);
        }
    }
}
