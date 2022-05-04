package project01;

import api.project01.service.BookingService;
import api.StatusCode;
import api.project01.service.PingService;
import assertions.AssertionManager;
import base.BaseTest;
import constants.TestConstants;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import logger.TestLogger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.request.project01.Booking;
import pojo.response.project01.BookingResponse;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;

public class BookingTest extends BaseTest {

    @BeforeMethod
    public void checkIfServiceIsRunning(){
        Response response = new PingService().ping();
        Assert.assertEquals(response.statusCode(), StatusCode.CODE_201.code);
    }

    @Test(groups = {"SMOKE", "SANITY", "REGRESSION"}, description = "I should be able to create booking", enabled = false)
    public void shouldBeAbleToCreateBooking() {

        Booking request = BookingService.bookingRequestBuilder();
        Response response = BookingService.createBooking(request);

        AssertionManager.assertEquals(response.statusCode(), StatusCode.CODE_200.code, TestConstants.ASSERTION_FOR_RESPONSE_STATUS_CODE);
        BookingResponse bookingResponse = response.as(BookingResponse.class);
        AssertionManager.assertEquals(bookingResponse.getBooking().getFirstname(), request.getFirstname(), TestConstants.ASSERTION_FOR_RESPONSE_CUSTOM_FIELD);
        AssertionManager.assertEquals(bookingResponse.getBooking().getBookingdates().getCheckin(), request.getBookingdates().getCheckin(), TestConstants.ASSERTION_FOR_RESPONSE_CUSTOM_FIELD);

        TestLogger.INFO_STEP("Response Time : " + response.getTimeIn(TimeUnit.MILLISECONDS));
        TestLogger.INFO_STEP("Status Line :" + response.statusLine());

        Headers allHeaders = response.getHeaders();
        for (Header header : allHeaders) {
            TestLogger.INFO("Key: " + header.getName() + " Value: " + header.getValue());
        }

        Map<String, Object> responseBody = null;
        responseBody = response.as(new TypeRef<Map<String, Object>>() {
        });
        Set<String> key = responseBody.keySet();
        for (String keySet : key) {
            System.out.println(keySet + " ==> " + responseBody.get(keySet));
        }
    }

    @Test(description = "I should be able to get booking by id", enabled = true)
    public void shouldBeAbleToGetBookingByID() {

        Response response = BookingService.getBooking(21);

        AssertionManager.assertEquals(response.statusCode(), StatusCode.CODE_200.code, TestConstants.ASSERTION_FOR_RESPONSE_STATUS_CODE);

        Booking booking = response.as(Booking.class);

        System.out.println(booking.toString());
    }
}