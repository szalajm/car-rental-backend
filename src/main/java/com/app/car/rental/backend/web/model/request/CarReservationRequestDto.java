package com.app.car.rental.backend.web.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarReservationRequestDto {
    private Long id;
    private String[] categoryName;
    private String categoryMake;
    private Integer chosen;
    private String vehicleClassCode;
    private String vehicleClassName;
//    private CarReservationVehicleRequestDto vehicle;

}
