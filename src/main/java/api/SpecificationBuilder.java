package api;

import filters.RestAssuredRequestFilter;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.DataLoader;
import utils.PropertyUtil;

public class SpecificationBuilder {

    public static RequestSpecification getRequestSpec(){
        return new RequestSpecBuilder().
                setBaseUri("https://restful-booker.herokuapp.com").
                //setBasePath(EndPoints.BOOKINGS).
                        setContentType(ContentType.JSON).
                        build();
    }

    public static RequestSpecification getRequestSpecWithFilters(){
        return new RequestSpecBuilder()
                .addFilter(new RestAssuredRequestFilter())
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .setBaseUri(DataLoader.getInstance().getProperty("base.url"))
                .setBasePath(DataLoader.getInstance().getProperty("users"))
                .build();
    }

    public static ResponseSpecification getResponseSpec(){
        return new ResponseSpecBuilder().
                build();
    }
}
