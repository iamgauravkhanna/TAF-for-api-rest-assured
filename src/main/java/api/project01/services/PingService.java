package api.project01.services;

import api.RestOperations;
import io.restassured.response.Response;

public class PingService {

    public Response ping() {
        return RestOperations.get("https://restful-booker.herokuapp.com/ping");
    }
}