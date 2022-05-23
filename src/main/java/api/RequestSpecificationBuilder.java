package api;

import constants.TestConstants;
import filters.RequestResponseFilter;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.ConfigLoader;

public class RequestSpecificationBuilder {

    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder().
                setBaseUri(ConfigLoader.getInstance().get(TestConstants.BASE_URL))
                .build();
    }

    public static RequestSpecification getRequestSpecWithFilters() {
        return new RequestSpecBuilder()
                .addFilter(new RequestResponseFilter())
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .setBaseUri(ConfigLoader.getInstance().get(TestConstants.BASE_URL))
                .build();
    }
}
