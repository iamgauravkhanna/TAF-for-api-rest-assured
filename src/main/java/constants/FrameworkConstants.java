package constants;

import java.io.File;

public class FrameworkConstants {

    public static final String DIRECTORY_ENV_CONFIG = "/src/main/resources/";

    public static final String log4jPath = System.getProperty("user.dir") + File.separator + "log4j.properties";

    public static final String ASSERTION_FOR_RESPONSE_STATUS_CODE = "Assertion for Response Status Code";

    public static final String ASSERTION_FOR_RESPONSE_HEADER = "Assertion for Response Headers";

    public static final String ASSERTION_FOR_RESPONSE_CUSTOM_FIELD = "Assertion for Response Custom Field";
}
