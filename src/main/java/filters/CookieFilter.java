package filters;


import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

import java.util.HashMap;
import java.util.Map;

public class CookieFilter implements Filter {

    private Map<String, String> cookies = new HashMap<String, String>();

    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext context) {

        for (Map.Entry<String, String> cookie : cookies.entrySet()) {
            if (!requestSpec.getCookies().hasCookieWithName(cookie.getKey())) {
                requestSpec.cookie(cookie.getKey(), cookie.getValue());
            }
        }
        final Response response = context.next(requestSpec, responseSpec);
        cookies.putAll(response.getCookies());
        return response;
    }
}