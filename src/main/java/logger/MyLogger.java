package logger;

import org.apache.log4j.Logger;
import reporting.ExtentTestManager;

public class MyLogger {

    private static Logger Log = Logger.getLogger("CustomLogger");

    public static void INFOSTEP(String message) {
        INFO(message);
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
