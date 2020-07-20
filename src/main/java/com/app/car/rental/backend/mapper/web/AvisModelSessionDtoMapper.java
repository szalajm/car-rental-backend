package com.app.car.rental.backend.mapper.web;

import com.app.car.rental.backend.api.avis.model.rate.AvisApiRate;
import com.app.car.rental.backend.api.avis.model.reservation.post.request.AvisApiReservationPostRequest;
import com.app.car.rental.backend.api.avis.model.reservation.post.request.Rate;
import com.app.car.rental.backend.api.avis.model.reservation.post.request.RateTotals;
import com.app.car.rental.backend.domain.web.AvisModelSessionDto;
import org.springframework.stereotype.Component;

@Component
public class AvisModelSessionDtoMapper {
    public AvisApiReservationPostRequest from(AvisModelSessionDto dto) {
        AvisApiReservationPostRequest reservationPostRequest = new AvisApiReservationPostRequest();

//        reservationPostRequest.set -> dto.get

        // AVIS RATE
        AvisApiRate dtoAvisApiRate = dto.getAvisApiRate();
        RateTotals rateTotals = new RateTotals();
        Rate rate = new Rate();
        rateTotals.setRate(rate);
        reservationPostRequest.setRateTotals(rateTotals);

        return reservationPostRequest;
    }
}
