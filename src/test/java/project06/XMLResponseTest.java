package project06;

import base.BaseTest;
import constants.TestConstants;
import filters.RequestResponseFilter;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import logger.TestLogger;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import config.ConfigLoader;

import java.util.List;

import static constants.TestConstants.SCHEMA_PATH;
import static io.restassured.RestAssured.given;

import static io.restassured.matcher.RestAssuredMatchers.*;

public class XMLResponseTest extends BaseTest {

    @Test(description = "xml response verification")
    public void TestMethodA() {

        RequestSpecification requestSpecification = new RequestSpecBuilder().
                setBaseUri(ConfigLoader.getInstance().get(TestConstants.BASE_URL))
                .addFilter(new RequestResponseFilter())
                .build();

        Response response = given(requestSpecification)
                .when()
                .get(ConfigLoader.getInstance().get("base.path"));

        response
                .then()
                .assertThat()
                .body("courses.subject.name", Matchers.hasItems("Rest Assured", "Postman"))
                .and()
                .assertThat()
                .body("courses.subject.price", Matchers.hasItems("10", "6"));

        XmlPath xmlPath = response.xmlPath();
        List<String> list = xmlPath.getList("courses.subject.name",String.class);
        TestLogger.INFO(list.toString());

        response.then().body(matchesXsd(SCHEMA_PATH + "/courses.xsd"));
    }
}
