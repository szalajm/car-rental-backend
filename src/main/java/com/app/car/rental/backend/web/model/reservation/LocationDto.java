package com.app.car.rental.backend.web.model.reservation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationDto {
    private String code;
    private String name;
    private String telephone;
    private String hours;
    private Boolean airportLocation;
}
