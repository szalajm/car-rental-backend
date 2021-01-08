package com.app.car.rental.backend.service;

import com.app.car.rental.backend.api.avis.model.location.AvisApiLocation;
import com.app.car.rental.backend.api.avis.model.vehicle.AvisApiVehicle;
import com.app.car.rental.backend.api.exception.AvisApiException;
import com.app.car.rental.backend.service.avis.AvisVehicleOkHttpService;
import com.app.car.rental.backend.service.util.AvisApiVehicleUtil;
import com.app.car.rental.backend.web.model.request.LocationSearchRequestDto;
import com.app.car.rental.backend.service.avis.AvisLocationService;
import com.app.car.rental.backend.service.avis.AvisVehicleService;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CarRentalService {

    private AvisLocationService avisLocationService;
    private AvisVehicleOkHttpService avisVehicleService;

    public CarRentalService(AvisLocationService avisLocationService,
                            AvisVehicleOkHttpService avisVehicleService) {
        this.avisLocationService = avisLocationService;
        this.avisVehicleService = avisVehicleService;
    }

    public AvisApiLocation locationSearch(String location) {
        return avisLocationService.locations(location);
    }

    public AvisApiVehicle carSearch(LocationSearchRequestDto locationSearchRequestDto) throws IOException, AvisApiException {
        AvisApiVehicle avisApiVehicle = avisVehicleService.vehicles(locationSearchRequestDto);
        AvisApiVehicleUtil.fillWithUniqueId(avisApiVehicle);

        return avisApiVehicle;
    }
}
