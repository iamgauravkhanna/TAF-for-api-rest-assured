package listeners;

import constants.TestConstants;
import logger.TestLogger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.IExecutionListener;
import reporting.ExtentManager;
import utils.JavaUtil;

import java.io.File;

public class IExecutionListenerImpl implements IExecutionListener {

    @Override
    public void onExecutionStart() {

        String outputDirectory = System.getProperty("user.dir") + File.separator + "reports" + File.separator
                + "test-reports-" + JavaUtil.getCurrentTimeStamp();

        JavaUtil.createDirectory(outputDirectory);

        System.setProperty("logsDirectory", outputDirectory);

        ExtentManager.getInstance();

        PropertyConfigurator.configure(TestConstants.log4jPath);

        TestLogger.INFO("Execution Started");
    }

    @Override
    public void onExecutionFinish() {
        TestLogger.INFO("Execution has finished, took around");
        ExtentManager.getInstance().flush();
    }
}
