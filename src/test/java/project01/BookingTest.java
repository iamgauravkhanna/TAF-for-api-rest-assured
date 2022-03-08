package project01;

import api.project01.BookingAPI;
import api.project01.StatusCode;
import base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import request.pojo.project01.Booking;
import request.pojo.project01.BookingDates;
import response.project01.BookingResponse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class BookingTest extends BaseTest {

    @Test
    public void shouldBeAbleToCreateBooking(){

        Booking bookingRequest = bookingRequestBuilder();

        System.out.println("Request Body :" + bookingRequest.toString());

        Response response = BookingAPI.post(bookingRequest);

        System.out.println("Response Body :" + response.getBody().prettyPrint());

        assertStatusCode(response.statusCode(),StatusCode.CODE_200);

        assertBookingResponse(response.as(BookingResponse.class),bookingRequest);
    }

    private Booking bookingRequestBuilder() {
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

    private void assertStatusCode(int actualStatusCode, StatusCode statusCode){
        assertThat(actualStatusCode, equalTo(statusCode.code));
    }

    private void assertBookingResponse(BookingResponse response, Booking request) {
        assertThat(response.getBooking().getFirstname(),equalTo(request.getFirstname()));
    }
}
