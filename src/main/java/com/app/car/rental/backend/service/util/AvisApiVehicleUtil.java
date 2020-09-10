package com.app.car.rental.backend.service.util;

import com.app.car.rental.backend.api.avis.model.vehicle.AvisApiVehicle;
import com.app.car.rental.backend.api.avis.model.vehicle.Category;
import com.app.car.rental.backend.api.avis.model.vehicle.Vehicle;

import java.util.List;
import java.util.Optional;
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

    public static Optional<Vehicle> findVehicleById(String id, AvisApiVehicle avisApiVehicle) {
        if (avisApiVehicle != null) {
            List<Vehicle> vehicles = avisApiVehicle.getVehicles();
            if (vehicles != null) {
                return vehicles.stream()
                        .filter(vehicle -> id.equals(vehicle.getId()))
                        .findFirst();
            }
        }

        return Optional.empty();
    }

    public static String extractVehicleClassCode(Vehicle vehicle) {
        if (vehicle != null) {
            Category category = vehicle.getCategory();
            if (category != null) {
                return category.getVehicleClassCode();
            }
        }

        return null;
    }
}
