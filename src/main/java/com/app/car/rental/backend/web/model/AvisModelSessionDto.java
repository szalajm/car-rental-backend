package com.app.car.rental.backend.web.model;

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
    private String vehicleId;

    private String pickUpDate;
    private String dropOffDate;

    private AvisApiLocation avisApiPickUpLocation;
    private AvisApiLocation avisApiDropOffLocation;
    private AvisApiVehicle avisApiVehicle;
    private AvisApiRate avisApiRate;

    private PassengerDataDto passengerDataDto;
}
