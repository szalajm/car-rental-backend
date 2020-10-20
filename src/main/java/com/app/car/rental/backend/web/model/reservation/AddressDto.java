package com.app.car.rental.backend.web.model.reservation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String stateName;
    private String postalCode;
    private String countryCode;
}
