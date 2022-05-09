package project03;

import base.BaseTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserTest extends BaseTest {

    @Test
    public void shouldBeAbleToGetUserDetails() {
        given().
                when().
                get("http://jsonplaceholder.typicode.com/users/1").
                then().
                assertThat().
                body("name", equalTo("Leanne Graham"));
    }

    @Test
    public void logAllRequestData() {

        given().
                log().
                all().
                when().
                get("http://jsonplaceholder.typicode.com/users/1");
    }

    @Test
    public void logAllResponseData() {

        given().
                when().
                get("http://jsonplaceholder.typicode.com/users/1").
                then().
                log().
                all();
    }

    @Test
    public void verifyStatusCodeAndContentType() {

        given().
                when().
                get("http://jsonplaceholder.typicode.com/users/1").
                then().
                assertThat().
                statusCode(200).
                and().
                contentType(ContentType.JSON);
    }

    @Test
    public void usingQueryParameter() {

        given().
                queryParam("ISBN", "9781449325862").
                when().
                get("https://demoqa.com/BookStore/v1/Book").
                then().
                assertThat().
                body("isbn", equalTo("9781449325862"));
    }

    @Test
    public void usingPathParameter() {

        given().
                pathParam("userId", 1).
                when().
                get("http://jsonplaceholder.typicode.com/users/{userId}").
                then().
                assertThat().
                body("name", equalTo("Leanne Graham"));
    }

}