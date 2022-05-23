package api;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;

public class ResponseSpecificationBuilder {

    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder().
                build();
    }

    public static ResponseSpecification getResponseSpecStandard() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectStatusLine("HTTP/1.1 200 OK")
                .expectContentType(ContentType.JSON)
                .expectResponseTime(Matchers.lessThan(5000L))
                .build();
    }
}