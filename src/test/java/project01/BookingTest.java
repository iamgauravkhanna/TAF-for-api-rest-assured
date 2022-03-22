package project01;

import api.project01.BookingAPI;
import api.project01.StatusCode;
import assertions.VerificationManager;
import base.BaseTest;
import constants.FrameworkConstants;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import logger.MyLogger;
import org.testng.annotations.Test;
import pojo.request.project01.Booking;
import pojo.request.project01.BookingDates;
import pojo.response.project01.BookingResponse;

import static org.hamcrest.MatcherAssert.assertThat;

public class BookingTest extends BaseTest {

    @Test(groups = {"SMOKE","SANITY","REGRESSION"}, description = "I should be able to create booking")
    public void shouldBeAbleToCreateBooking(){

        Booking bookingRequest = bookingRequestBuilder();
        Response response = BookingAPI.post(bookingRequest);
        VerificationManager.assertEquals(response.statusCode(),StatusCode.CODE_200.code, FrameworkConstants.ASSERTION_FOR_RESPONSE_STATUS_CODE);
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

    private void assertBookingResponse(BookingResponse response, Booking request) {
        VerificationManager.assertEquals(response.getBooking().getFirstname(),request.getFirstname(),FrameworkConstants.ASSERTION_FOR_RESPONSE_CUSTOM_FIELD);
        VerificationManager.assertEquals(response.getBooking().getBookingdates().getCheckin(),request.getBookingdates().getCheckin(),FrameworkConstants.ASSERTION_FOR_RESPONSE_CUSTOM_FIELD);
    }
}
