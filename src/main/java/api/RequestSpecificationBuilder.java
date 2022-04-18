package api;

import filters.RequestFilter;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.DataLoader;

public class RequestSpecificationBuilder {

    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder().
                setBaseUri("https://restful-booker.herokuapp.com")
                .addFilter(new RequestFilter())
                .setContentType(ContentType.JSON).
                        build();
    }

    public static RequestSpecification getRequestSpecWithFilters() {
        return new RequestSpecBuilder()
                .addFilter(new RequestFilter())
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .setBaseUri(DataLoader.getInstance().getProperty("base.url"))
                .setBasePath(DataLoader.getInstance().getProperty("users"))
                .build();
    }

    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder().
                build();
    }
}
