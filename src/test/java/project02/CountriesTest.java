package project02;

import api.RestOperations;
import base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CountriesTest extends BaseTest {

    // https://restcountries.com/v2/alpha/in

    @Test
    public void shouldBeAbleToGetCountryDetails(){
        Response response = RestOperations.get("https://restcountries.com/v2/alpha/in");

    }
}
