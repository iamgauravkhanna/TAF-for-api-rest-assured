package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reporting.ExtentTestManager;
import logger.MyLogger;


public class ITestListenerImpl implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {

        MyLogger.INFO(("Running Test Method " + result.getMethod().getMethodName() + "..."));
        ExtentTestManager.startTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        MyLogger.PASS(result.getMethod().getMethodName() + " executed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTestManager.getTest().fail("Test Case Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().skip("Test Case Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

}
