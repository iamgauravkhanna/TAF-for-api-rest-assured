package base;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import logger.MyLogger;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTest {

    @BeforeMethod
    public void beforeMethod(Method m) {

        MyLogger.INFO("STARTING TEST: " + m.getName());
        MyLogger.INFO("THREAD ID: " + Thread.currentThread().getId());

        // This line will print request response logs for every request to console
        // RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}
