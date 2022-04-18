package api.project01.services;

import api.RestOperations;
import api.project01.EndPoints;
import io.restassured.response.Response;
import pojo.request.project01.Booking;
import pojo.request.project01.BookingDates;

public class BookingAPI {

    public static Response post(Booking bookingRequest){
        return RestOperations.post(EndPoints.BOOKINGS,bookingRequest);
    }

    public static Booking bookingRequestBuilder() {
        return Booking.builder().
                firstname("Gaurav").
                lastname("Khanna").
                totalprice(100).
                depositpaid(true).
                bookingdates(BookingDates.builder().
                        checkin("2013-02-23").
                        checkout("2013-03-23").
                        build()).
                additionalneeds("Lunch").build();
    }
}
