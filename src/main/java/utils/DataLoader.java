package utils;

import java.util.Properties;

import static constants.TestConstants.RESOURCES_PATH;

public class DataLoader {

    private Properties properties;
    private static DataLoader dataLoader;

    private DataLoader() {
        properties = PropertyUtil.propertyLoader(RESOURCES_PATH + "/config.properties");
    }

    public static DataLoader getInstance() {
        if (dataLoader == null) {
            dataLoader = new DataLoader();
        }
        return dataLoader;
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }
}
