package com.app.car.rental.backend.service.mapper.avis;

import com.app.car.rental.backend.api.avis.model.reservation.post.request.Rate;
import com.app.car.rental.backend.api.avis.model.vehicle.RateTotals;
import com.app.car.rental.backend.api.avis.model.vehicle.Vehicle;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class AvisApiVehicleMapper {
    private static final Logger LOGGER = Logger.getLogger(AvisApiVehicleMapper.class.getName());

    private AvisApiRateTotalsMapper avisApiRateTotalsMapper;

    public AvisApiVehicleMapper(AvisApiRateTotalsMapper avisApiRateTotalsMapper) {
        this.avisApiRateTotalsMapper = avisApiRateTotalsMapper;
    }

    public Rate extractReservationRate(Vehicle avisApiVehicle) {
        LOGGER.info("extractReservationRate(" + avisApiVehicle + ")");
        RateTotals rateTotals = avisApiVehicle.getRateTotals();
        Rate rate = avisApiRateTotalsMapper.toReservationRate(rateTotals);
        LOGGER.info("extractReservationRate(...) = " + rate);
        return rate;
    }
}
