package project07;

import assertions.VerificationManager;
import base.BaseTest;
import constants.TestConstants;
import filters.RequestFilter;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import logger.TestLogger;
import org.hamcrest.Matchers;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CSVUtil;
import utils.ConfigLoader;

import java.util.List;

import static constants.TestConstants.RESOURCES_PATH;
import static constants.TestConstants.SCHEMA_PATH;
import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsd;
import static org.hamcrest.core.IsEqual.equalTo;

public class ParameterizeTest extends BaseTest {

    @Test(description = "parameterize test", dataProvider = "countryAndZipCode", enabled = false)
    public void TestMethodA(String countryCode, String zipCode) {

        given()
                .pathParam("countryCode", countryCode)
                .pathParam("zipCode", zipCode)
                .when()
                .get("https://api.zippopotam.us/{countryCode}/{zipCode}")
                .then()
                .assertThat();
    }

    @Test(description = "parameterize test", dataProvider = "csvDataProvider", enabled = false)
    public void TestMethodB(String countryCode, String zipCode, String place) {

        ValidatableResponse validatableResponse = given()
                .pathParam("countryCode", countryCode)
                .pathParam("zipCode", zipCode)
                .when()
                .get("https://api.zippopotam.us/{countryCode}/{zipCode}")
                .then();

        VerificationManager.assertEquals(validatableResponse.extract().body().jsonPath().get("places.'place name'[0]"), place, TestConstants.ASSERTION_FOR_RESPONSE_CUSTOM_FIELD);
    }

    @DataProvider(name = "countryAndZipCode")
    public Object[][] getData() {
        return new Object[][]
                {
                        {"us", "90210"},
                        {"us", "18017"}
                };
    }

    @DataProvider(name = "csvDataProvider")
    public Object[][] provider() throws InterruptedException {
        return new CSVUtil().getDataAsArray(RESOURCES_PATH + "/data.csv");
    }

    @Test(description = "parameterize test using Context", dataProvider = "csvDataProvider", enabled = true)
    public void TestMethodC(String countryCode, String zipCode, String place, ITestContext iTestContext) {

        ValidatableResponse validatableResponse = given()
                .pathParam("countryCode", countryCode)
                .pathParam("zipCode", zipCode)
                .when()
                .get("https://api.zippopotam.us/{countryCode}/{zipCode}")
                .then();

        iTestContext.setAttribute("place", validatableResponse.extract().body().jsonPath().get("places.'place name'[0]"));
    }

    @Test(description = "Method depedent on Another Method", dependsOnMethods = "TestMethodC")
    public void TestMethodD(ITestContext iTestContext) {
        TestLogger.INFO("Context : " + iTestContext.getAttribute("place"));
    }



}