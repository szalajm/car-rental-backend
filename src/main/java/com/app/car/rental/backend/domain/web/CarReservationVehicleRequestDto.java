package com.app.car.rental.backend.domain.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarReservationVehicleRequestDto {
    private CarReservationVehicleCategoryRequestDto category;
}
