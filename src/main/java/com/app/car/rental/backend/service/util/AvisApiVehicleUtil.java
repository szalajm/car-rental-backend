package com.app.car.rental.backend.service.util;

import com.app.car.rental.backend.api.avis.model.vehicle.AvisApiVehicle;
import com.app.car.rental.backend.api.avis.model.vehicle.Vehicle;

import java.util.List;
import java.util.UUID;

public class AvisApiVehicleUtil {
    public static void fillWithUniqueId(AvisApiVehicle avisApiVehicle) {
        if (avisApiVehicle != null) {
            List<Vehicle> vehicles = avisApiVehicle.getVehicles();
            if (vehicles != null) {
                vehicles.forEach(vehicle -> vehicle.setId(UUID.randomUUID().toString()));
            }
        }
    }
}
