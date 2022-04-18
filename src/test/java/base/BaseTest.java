package base;

import logger.TestLogger;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTest {

    @BeforeMethod
    public void beforeMethod(Method m) {

        TestLogger.INFO("STARTING TEST: " + m.getName());
        TestLogger.INFO("THREAD ID: " + Thread.currentThread().getId());

        // This line will print request response logs for every request to console
        // RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}
