package filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import logger.TestLogger;

public class RequestFilter implements Filter {

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
        Response response = ctx.next(requestSpec, responseSpec);
        if (response.statusCode() != 200) {
            TestLogger.ERROR(requestSpec.getMethod() + " " + requestSpec.getURI() + " => " +
                    response.getStatusCode() + " " + response.getStatusLine());
        }
        TestLogger.INFO(requestSpec.getMethod() + " " + requestSpec.getURI() + " \n Request Body => " + requestSpec.getBody() + "\n Response Status => " +
                response.getStatusCode() + " " + response.getStatusLine() + " \n Response Body => " + response.getBody().prettyPrint());
        return response;
    }
}