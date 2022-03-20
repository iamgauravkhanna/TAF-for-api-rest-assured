package api.project01;

import api.RestOperations;
import io.restassured.response.Response;
import pojo.request.project01.Booking;

public class BookingAPI {

    public static Response post(Booking bookingRequest){
        return RestOperations.post(EndPoints.BOOKINGS,bookingRequest);
    }
}