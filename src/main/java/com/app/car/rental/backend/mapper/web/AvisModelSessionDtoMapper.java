package com.app.car.rental.backend.mapper.web;

import com.app.car.rental.backend.api.avis.model.reservation.post.request.AvisApiReservationPostRequest;
import com.app.car.rental.backend.domain.web.AvisModelSessionDto;
import org.springframework.stereotype.Component;

@Component
public class AvisModelSessionDtoMapper {
    public AvisApiReservationPostRequest from(AvisModelSessionDto dto) {
        AvisApiReservationPostRequest request = new AvisApiReservationPostRequest();

//        request.set -> dto.get

        return request;
    }
}
