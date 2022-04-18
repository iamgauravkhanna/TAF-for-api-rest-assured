package project05;

import base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class FileUploadTest extends BaseTest {

    @Test(description = "File Upload Test")
    public void shouldBeAbleToUploadFiles(){

        File filetoUpload = new File("/Users/gaurav.khanna/Downloads/dummy.png");

        Response response = given()
                .when()
                .multiPart("file",filetoUpload, "multipart/form-data")
                .post("https://the-internet.herokuapp.com/upload")
                .thenReturn();
        response.prettyPrint();
    }

    @Test(description = "Download File Test")
    public void shouldBeAbleToDownloadFiles(){
        byte[] response = given()
                .get("https://avatars.githubusercontent.com/u/14772120")
                .asByteArray();
        System.out.println("Content Length : " + response.length);
    }
}
