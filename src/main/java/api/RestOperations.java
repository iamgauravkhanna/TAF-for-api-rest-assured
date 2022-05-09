package api;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;
import logger.TestLogger;

import static api.RequestSpecificationBuilder.*;

import static io.restassured.RestAssured.given;

public class RestOperations {

    public static Response post(String path, Object requestBody) {

        Response response = given(getRequestSpec())
                .contentType(ContentType.JSON)
                .body(requestBody).
                        when().
                        post(path).
                        then().
                        spec(getResponseSpec()).
                        extract().
                        response();

        printDetailsInExtentReport(requestBody, response);
        return response;
    }

    public static Response get(String path) {

        Response response = given(getRequestSpec())
                .when()
                .get(path)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();

        printDetailsInExtentReport("NA", response);
        return response;
    }

    public static Response get(RequestSpecification requestSpecification, String path) {
        Response response = given(requestSpecification).get(path);
        printDetailsInExtentReport(requestSpecification, response);
        return response;
    }

    private static void printDetailsInExtentReport(Object request, Response response) {
        TestLogger.INFO_STEP("<details><summary><i><font color=black> Request details: </font></i>" + "</summary>"
                + "<pre>" + request.toString() + "</pre>" + "</details> \n");

        TestLogger.INFO_STEP("<details><summary><i><font color=black> Response details: </font></i>" + "</summary>"
                + "<pre>" + response.asString() + "</pre>" + "</details> \n");

        //TestLogger.INFO_STEP(MarkupHelper.createCodeBlock(response.asString(), CodeLanguage.JSON));
    }
}