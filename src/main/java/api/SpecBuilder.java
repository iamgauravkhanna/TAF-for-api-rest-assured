package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {

    public static RequestSpecification getRequestSpec(){
        return new RequestSpecBuilder().
                setBaseUri("https://restful-booker.herokuapp.com").
                //setBasePath(EndPoints.BOOKINGS).
                        setContentType(ContentType.JSON).
                        build();
    }

    public static ResponseSpecification getResponseSpec(){
        return new ResponseSpecBuilder().
                build();
    }
}
