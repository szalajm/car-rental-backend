package com.app.car.rental.backend.service.mapper.avis;

import com.app.car.rental.backend.api.avis.model.reservation.post.request.Rate;
import com.app.car.rental.backend.api.avis.model.vehicle.RateTotals;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

import static com.app.car.rental.backend.web.controller.ControllerConstants.COUNTRY_CODE;

@Component
public class AvisApiRateTotalsMapper {
    private static final Logger LOGGER = Logger.getLogger(AvisApiRateTotalsMapper.class.getName());

    public Rate toReservationRate(RateTotals avisApiRateTotals) {
        LOGGER.info("toReservationRate(" + avisApiRateTotals + ")");
        Rate reservationRate = new Rate();

        if (avisApiRateTotals != null) {
            com.app.car.rental.backend.api.avis.model.vehicle.Rate avisApiRate = avisApiRateTotals.getRate();
            if (avisApiRate != null) {
                String currency = avisApiRate.getCurrency();
                String rateCode = avisApiRate.getRateCode();

                // FIXME: check CountryCode!
                reservationRate.setCountryCode(COUNTRY_CODE);
                reservationRate.setRateCode(rateCode);
            }
        }

        LOGGER.info("toReservationRate(...) = " + reservationRate);
        return reservationRate;
    }
}
