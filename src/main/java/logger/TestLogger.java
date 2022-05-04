package logger;

import com.aventstack.extentreports.markuputils.Markup;
import org.apache.log4j.Logger;
import reporting.ExtentTestManager;

import java.util.Objects;

public class TestLogger {

    private static Logger Log = Logger.getLogger("TestLogger");

    public static void INFO_STEP(String message) {
        INFO(message);
        if (Objects.nonNull(ExtentTestManager.getTest()))
            ExtentTestManager.getTest().info(message);
    }

    public static void INFO_STEP(Markup message) {
        ExtentTestManager.getTest().info(message);
    }

    public static void PASS(String message) {
        ExtentTestManager.getTest().pass(message);
    }

    public static void FAIL(String message) {
        ExtentTestManager.getTest().fail(message);
    }

    public static void INFO(String message) {
        Log.info(message);
        System.out.println(" *** INFO : " + message);
    }

    public static void ERROR(String message) {
        Log.error(message);
        System.out.println(" *** ERROR : " + message);
    }

}
