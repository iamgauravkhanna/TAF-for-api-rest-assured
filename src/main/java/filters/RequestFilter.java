package filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import logger.TestLogger;

public class RequestFilter implements Filter {

    @Override
    public Response filter(FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification, FilterContext filterContext) {
        Response response = filterContext.next(filterableRequestSpecification, filterableResponseSpecification);

        if (response.statusCode() != 200) {
            TestLogger.ERROR(filterableRequestSpecification.getMethod() + " " + filterableRequestSpecification.getURI() + " => " +
                    response.getStatusCode() + " " + response.getStatusLine());
        }

        TestLogger.INFO(filterableRequestSpecification.getMethod() + " " + filterableRequestSpecification.getURI() +
                " \n Request Body => " + filterableRequestSpecification.getBody() + "\n Response Status => " +
                response.getStatusCode() + " " + response.getStatusLine() + " \n Response Body => " + response.getBody().prettyPrint());

        return response;
    }
}