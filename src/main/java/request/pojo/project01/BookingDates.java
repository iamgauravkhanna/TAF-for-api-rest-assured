package request.pojo.project01;

import lombok.*;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookingDates {

    private String checkin;
    private String checkout;

}