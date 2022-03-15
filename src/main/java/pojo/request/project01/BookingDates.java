package pojo.request.project01;

import lombok.*;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@Builder
@Data
public class BookingDates {

    private String checkin;
    private String checkout;
}