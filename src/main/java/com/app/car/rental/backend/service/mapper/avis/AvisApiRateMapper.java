package com.app.car.rental.backend.service.mapper.avis;

import com.app.car.rental.backend.api.avis.model.rate.AvisApiRate;
import com.app.car.rental.backend.api.avis.model.rate.RateTotals;
import com.app.car.rental.backend.api.avis.model.rate.Reservation;
import com.app.car.rental.backend.api.avis.model.reservation.post.request.Rate;
import org.springframework.stereotype.Component;

@Component
public class AvisApiRateMapper {
    public Rate toReservationRate(AvisApiRate avisApiRate) {
        Rate reservationRate = new Rate();

        if (avisApiRate != null) {
            Reservation reservation = avisApiRate.getReservation();
            if (reservation != null) {
                RateTotals reservationRateTotals = reservation.getRateTotals();
                if (reservationRateTotals != null) {
                    com.app.car.rental.backend.api.avis.model.rate.Rate rate = reservationRateTotals.getRate();
//                    reservationRate.setRateCode(rate.getRateCode());
//                    reservationRate.setCountryCode(rate.getRateCode());

                    // FIXME: remove!
                    reservationRate.setRateCode("DH");
                    reservationRate.setCountryCode("US");
                }
            }
        }

        // FIXME: remove!
        reservationRate.setRateCode("DH");
        reservationRate.setCountryCode("US");

        return reservationRate;
    }
}
