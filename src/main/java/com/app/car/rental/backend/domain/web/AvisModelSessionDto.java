package com.app.car.rental.backend.domain.web;

import com.app.car.rental.backend.api.avis.model.location.AvisApiLocation;
import com.app.car.rental.backend.api.avis.model.rate.AvisApiRate;
import com.app.car.rental.backend.api.avis.model.vehicle.AvisApiVehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvisModelSessionDto {

    private AvisApiLocation avisApiPickUpLocation;
    private AvisApiLocation avisApiDropOffLocation;
    private AvisApiVehicle avisApiVehicle;
    private AvisApiRate avisApiRate;


}
