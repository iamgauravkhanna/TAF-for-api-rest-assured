package response.project01;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.extern.jackson.Jacksonized;
import request.pojo.project01.Booking;

@ToString
@AllArgsConstructor
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