package pojo.request.project01;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Builder
@Getter
@Setter
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDates {

    private String checkin;
    private String checkout;
}