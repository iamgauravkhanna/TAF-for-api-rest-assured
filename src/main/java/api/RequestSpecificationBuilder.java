package api;

import constants.TestConstants;
import filters.RequestFilter;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.ConfigLoader;

public class RequestSpecificationBuilder {

    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder().
                setBaseUri(ConfigLoader.getInstance().get(TestConstants.BASE_URL))
                .addFilter(new RequestFilter())
                .setContentType(ContentType.JSON).
                        build();
    }

    public static RequestSpecification getRequestSpecWithFilters() {
        return new RequestSpecBuilder()
                .addFilter(new RequestFilter())
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .setBaseUri(ConfigLoader.getInstance().get(TestConstants.BASE_URL))
                .build();
    }

    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder().
                build();
    }
}
