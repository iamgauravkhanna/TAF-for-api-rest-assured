package project02;

import api.RestOperations;
import base.BaseTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import logger.TestLogger;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;

public class CountriesTest extends BaseTest {

    @Test(description = "Json Path Example", enabled = true)
    public void shouldBeAbleToGetCountryDetails() {
        Response response = RestOperations.get("https://restcountries.com/v2/alpha/in");
        String responseBody = response.getBody().print();

        JsonPath jsonPath = JsonPath.from(responseBody);
        TestLogger.INFO("name : " + jsonPath.get("name"));
        TestLogger.INFO("capital : " + jsonPath.get("capital"));

        JsonPath jsonPath1 = response.jsonPath();
        TestLogger.INFO("name : " + jsonPath1.get("name"));
        TestLogger.INFO("capital : " + jsonPath1.get("capital"));
    }

    @Test(description = "writing response body to file")
    public void writeResponseToFile() {

        Response response = RestOperations.get("https://restcountries.com/v2/alpha/in");

        try {
            String responseAsString = response.asString();
            byte[] responseAsStringByte = responseAsString.getBytes();
            File targetFileForString = new File(System.getProperty("logsDirectory") + "/targetFileForString.json");

            FileWriter fileWriter = new FileWriter(targetFileForString);
            fileWriter.write(new String(responseAsStringByte));
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
