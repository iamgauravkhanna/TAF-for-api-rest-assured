package api;

import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;
import logger.MyLogger;

import static api.SpecificationBuilder.*;

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

    public static Response get(String path){

        Response response = given().
                when().
                get(path).
                then().
                spec(getResponseSpec()).
                extract().
                response();

        printDetailsInExtentReport("NA",response);

        return response;
    }

    public static Response get(RequestSpecification requestSpecification,String path){
        Response response = requestSpecification.get(path);
        printDetailsInExtentReport(requestSpecification,response);
        return response;
    }

    private static void printDetailsInExtentReport(Object request, Response response) {
            MyLogger.INFO_STEP("<details><summary><i><font color=black> Request details: </font></i>" + "</summary>"
                    + "<pre>" + request.toString() + "</pre>" + "</details> \n");
        MyLogger.INFO_STEP("<details><summary><i><font color=black> Response details: </font></i>" + "</summary>"
                    + "<pre>" + response.asString() + "</pre>" + "</details> \n");
        //CustomLogger.INFO_STEP(MarkupHelper.createCodeBlock(pojo.response.asString(), CodeLanguage.JSON));
    }
}
