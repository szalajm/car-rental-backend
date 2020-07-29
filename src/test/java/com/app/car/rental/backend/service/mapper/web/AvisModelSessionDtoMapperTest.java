package com.app.car.rental.backend.service.mapper.web;

import com.app.car.rental.backend.api.avis.model.reservation.post.request.AvisApiReservationPostRequest;
import com.app.car.rental.backend.web.model.AvisModelSessionDto;
import com.app.car.rental.backend.service.mapper.avis.AvisApiRateMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class AvisModelSessionDtoMapperTest {

    @Autowired
    private AvisApiRateMapper avisApiRateMapper;

    @Test
    void givenSessionDto_whenMapperMap_thenPostRequestNotNull() {
        // given
        AvisModelSessionDtoMapper mapper = new AvisModelSessionDtoMapper(avisApiRateMapper);
        AvisModelSessionDto sessionDto = new AvisModelSessionDto();
        // when
        AvisApiReservationPostRequest reservationPostRequest = mapper.from(sessionDto);
        // then
        assertNotNull(reservationPostRequest, "Mapped Request object should not be null");
    }

    @Test
    void extractLocationCode() {
        // FIXME: implement!
    }
}