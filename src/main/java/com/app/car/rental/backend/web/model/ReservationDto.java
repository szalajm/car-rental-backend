package com.app.car.rental.backend.web.model;

import com.app.car.rental.backend.web.model.reservation.ConfirmationDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
    private Long id;

    private ConfirmationDto confirmation;
    //    private DistanceDto distance;
//    private PickupLocationDto pickupLocation;
//    private DropoffLocationDto dropoffLocation;
//    private List<ExtraDto> extras = null;
//    private RateTotalsDto rateTotals;
//    private List<InsuranceDto> insurance = null;
    private VehicleDto vehicle;
    //    private List<TermDto> terms = null;
//    private Map<String, Object> additionalProperties = new HashMap<>();
}
