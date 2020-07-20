package com.app.car.rental.backend.mapper.web;

import com.app.car.rental.backend.api.avis.model.reservation.post.request.AvisApiReservationPostRequest;
import com.app.car.rental.backend.domain.web.AvisModelSessionDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AvisModelSessionDtoMapperTest {

    @Test
    void givenSessionDto_whenMapperMap_thenPostRequestNotNull() {
        // given
        AvisModelSessionDtoMapper mapper = new AvisModelSessionDtoMapper();
        AvisModelSessionDto sessionDto = new AvisModelSessionDto();
        // when
        AvisApiReservationPostRequest reservationPostRequest = mapper.from(sessionDto);
        // then
        assertNotNull(reservationPostRequest, "Mapped Request object should not be null");
    }
}