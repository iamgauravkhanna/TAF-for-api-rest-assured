package pojo.response.project01;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.extern.jackson.Jacksonized;
import pojo.request.project01.Booking;

@Builder
@Getter
@Jacksonized
public class BookingResponse {

    private Integer bookingid;
    private Booking booking;
}