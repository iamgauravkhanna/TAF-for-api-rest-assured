package constants;

import java.io.File;

public class TestConstants {

    public static final String USER_DIR = System.getProperty("user.dir");

    public static final String DIRECTORY_ENV_CONFIG = "/src/main/resources/";

    public static final String RESOURCES_PATH = USER_DIR + DIRECTORY_ENV_CONFIG + System.getProperty("testEnvironment");

    public static final String SCHEMA_PATH = USER_DIR + "/src/test/resources/schema/" + System.getProperty("testEnvironment");

    public static final String log4jPath = USER_DIR + File.separator + "log4j.properties";

    public static final String ASSERTION_FOR_RESPONSE_STATUS_CODE = "Assertion for Response Status Code";
    public static final String ASSERTION_FOR_RESPONSE_HEADER = "Assertion for Response Headers";
    public static final String ASSERTION_FOR_NON_NULLABLE_FIELD = "Assertion for Non Nullable Field";
    public static final String ASSERTION_FOR_RESPONSE_CUSTOM_FIELD = "Assertion for Response Custom Field";

    public static final String BASE_URL = "base.url";
}
