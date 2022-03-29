package constants;

import java.io.File;

public class TestConstants {

    public static final String DIRECTORY_ENV_CONFIG = "/src/main/resources/";

    public static final String RESOURCES_PATH = System.getProperty("user.dir") + DIRECTORY_ENV_CONFIG + System.getProperty("testEnvironment");

    public static final String SCHEMA_PATH = System.getProperty("user.dir") + "/src/test/resources/schema/" +  System.getProperty("testEnvironment");

    public static final String log4jPath = System.getProperty("user.dir") + File.separator + "log4j.properties";

    public static final String ASSERTION_FOR_RESPONSE_STATUS_CODE = "Assertion for Response Status Code";

    public static final String ASSERTION_FOR_RESPONSE_HEADER = "Assertion for Response Headers";

    public static final String ASSERTION_FOR_NON_NULLABLE_FIELD = "Assertion for Non Nullable Field";

    public static final String ASSERTION_FOR_RESPONSE_CUSTOM_FIELD = "Assertion for Response Custom Field";
}
