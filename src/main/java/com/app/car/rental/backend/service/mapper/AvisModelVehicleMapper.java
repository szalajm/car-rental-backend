package com.app.car.rental.backend.service.mapper;

import com.app.car.rental.backend.api.avis.model.vehicle.Vehicle;
import com.app.car.rental.backend.web.model.AvisModelVehicleDto;

public class AvisModelVehicleMapper {

    public AvisModelVehicleDto mapToAvisModelVehicleDto (Vehicle vehicle){
    return new AvisModelVehicleDto(vehicle.getCategory(), vehicle.getFeatures(),vehicle.getCapacity(),
            vehicle.getRateTotals(), vehicle.getAdditionalProperties());
    }
}
