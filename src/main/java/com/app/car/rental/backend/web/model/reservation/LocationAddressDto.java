package com.app.car.rental.backend.web.model.reservation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationAddressDto {
    private LocationDto locationDto;
    private AddressDto addressDto;
}
