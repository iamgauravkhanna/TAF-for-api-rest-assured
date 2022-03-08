package utils;

import org.testng.internal.PropertyUtils;

import java.util.Properties;

public class DataLoader {

    private static final String RESOURCES_PATH = System.getProperty("user.dir") + "/src/test/resources/";
    private Properties properties;
    private static DataLoader dataLoader;

    private DataLoader() {
        properties = PropertyUtil.propertyLoader(RESOURCES_PATH + "data.properties");
    }

    public static DataLoader getInstance() {
        if (dataLoader == null) {
            dataLoader = new DataLoader();
        }
        return dataLoader;
    }
}
