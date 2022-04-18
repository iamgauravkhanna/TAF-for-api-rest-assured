package project02;

import api.RestOperations;
import base.BaseTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import logger.TestLogger;
import org.testng.annotations.Test;

public class CountriesTest extends BaseTest {

    @Test
    public void shouldBeAbleToGetCountryDetails(){
        Response response = RestOperations.get("https://restcountries.com/v2/alpha/in");

        String responseBody = response.getBody().print();
        JsonPath jsonPath = JsonPath.from(responseBody);
        TestLogger.INFO("name : " + jsonPath.get("name"));
        TestLogger.INFO("capital : " + jsonPath.get("capital"));

        JsonPath jsonPath1 = response.jsonPath();
        TestLogger.INFO("name : " + jsonPath1.get("name"));
        TestLogger.INFO("capital : " + jsonPath1.get("capital"));
    }
}
