package api.project01.service;

import api.RestOperations;
import api.project01.EndPoints;
import io.restassured.response.Response;

public class PingService {

    public Response ping() {
        return RestOperations.get(EndPoints.PING);
    }
}