package pojo.response.project01;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.extern.jackson.Jacksonized;
import pojo.request.project01.Booking;

@ToString
@Getter
@Setter
@Value
@Jacksonized
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingResponse {

    private Integer bookingid;
    private Booking booking;
}