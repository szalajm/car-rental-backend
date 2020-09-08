package com.app.car.rental.backend.service.mapper.web;

import com.app.car.rental.backend.api.avis.model.reservation.post.request.AvisApiReservationPostRequest;
import com.app.car.rental.backend.service.mapper.avis.AvisApiRateMapper;
import com.app.car.rental.backend.service.mapper.avis.AvisApiReservationPostRequestMapper;
import com.app.car.rental.backend.service.mapper.avis.AvisApiVehicleMapper;
import com.app.car.rental.backend.web.model.AvisModelSessionDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class AvisApiReservationPostRequestMapperTest {

    @Autowired
    private AvisApiRateMapper avisApiRateMapper;
    @Autowired
    private AvisApiVehicleMapper avisApiVehicleMapper;

    @Test
    void givenSessionDto_whenMapperMap_thenPostRequestNotNull() {
        // given
        AvisApiReservationPostRequestMapper mapper = new AvisApiReservationPostRequestMapper(avisApiRateMapper, avisApiVehicleMapper);
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