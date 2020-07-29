package com.app.car.rental.backend.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarReservationVehicleCategoryRequestDto {
    private String name;
    private String make;
    private String model;
}
