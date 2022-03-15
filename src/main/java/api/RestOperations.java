package api;

import io.restassured.response.Response;

import logger.MyLogger;

import static api.SpecBuilder.*;

import static io.restassured.RestAssured.given;

public class RestOperations {

    public static Response post(String path, Object requestBody) {

        Response response = given(getRequestSpec()).
                body(requestBody).
                when().
                post(path).
                then().
                spec(getResponseSpec()).
                extract().
                response();

        printDetailsInExtentReport(requestBody,response);

        return response;
    }

    private static void printDetailsInExtentReport(Object request, Response response) {
            MyLogger.INFOSTEP("<details><summary><i><font color=black> Request details: </font></i>" + "</summary>"
                    + "<pre>" + request.toString() + "</pre>" + "</details> \n");
        MyLogger.INFOSTEP("<details><summary><i><font color=black> Response details: </font></i>" + "</summary>"
                    + "<pre>" + response.asString() + "</pre>" + "</details> \n");
        //CustomLogger.INFOSTEP(MarkupHelper.createCodeBlock(pojo.response.asString(), CodeLanguage.JSON));
    }
}
