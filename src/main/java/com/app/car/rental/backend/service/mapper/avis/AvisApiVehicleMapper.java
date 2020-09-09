package com.app.car.rental.backend.service.mapper.avis;

import com.app.car.rental.backend.api.avis.model.vehicle.Rate;
import com.app.car.rental.backend.api.avis.model.vehicle.RateTotals;
import com.app.car.rental.backend.api.avis.model.vehicle.Vehicle;
import org.springframework.stereotype.Component;

import static com.app.car.rental.backend.web.controller.ControllerConstants.COUNTRY_CODE;

@Component
public class AvisApiVehicleMapper {
    public com.app.car.rental.backend.api.avis.model.reservation.post.request.Rate toReservationRate(Vehicle avisApiVehicle) {
        com.app.car.rental.backend.api.avis.model.reservation.post.request.Rate reservationRate =
                new com.app.car.rental.backend.api.avis.model.reservation.post.request.Rate();

        if (avisApiVehicle != null) {
            RateTotals avisApiRateTotals = avisApiVehicle.getRateTotals();
            if (avisApiRateTotals != null) {
                Rate avisApiRate = avisApiRateTotals.getRate();
                if (avisApiRate != null) {
                    String currency = avisApiRate.getCurrency();
                    String rateCode = avisApiRate.getRateCode();

                    // FIXME: check CountryCode!
                    reservationRate.setCountryCode(COUNTRY_CODE);
                    reservationRate.setRateCode(rateCode);
                }
            }
        }

        return reservationRate;
    }
}
