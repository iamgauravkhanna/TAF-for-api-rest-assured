package utils;

import java.util.Properties;

import static constants.TestConstants.RESOURCES_PATH;

public class ConfigLoader {

    private Properties properties;
    private static ConfigLoader dataLoader;

    private ConfigLoader() {
        properties = PropertyUtil.propertyLoader(RESOURCES_PATH + "/config.properties");
    }

    public static ConfigLoader getInstance() {
        if (dataLoader == null) {
            dataLoader = new ConfigLoader();
        }
        return dataLoader;
    }

    public String get(String key){
        return properties.getProperty(key);
    }
}
