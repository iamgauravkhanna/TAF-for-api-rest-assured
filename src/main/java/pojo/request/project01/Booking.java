package pojo.request.project01;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Builder
@Getter
@Setter
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Booking {

    private String firstname;
    private String additionalneeds;
    private BookingDates bookingdates;
    private Integer totalprice;
    private Boolean depositpaid;
    private String lastname;

}