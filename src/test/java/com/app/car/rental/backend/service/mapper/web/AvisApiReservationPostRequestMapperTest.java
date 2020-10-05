package com.app.car.rental.backend.service.mapper.web;

import com.app.car.rental.backend.api.avis.model.reservation.post.request.AvisApiReservationPostRequest;
import com.app.car.rental.backend.service.mapper.avis.AvisApiPassengerMapper;
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
    private AvisApiVehicleMapper avisApiVehicleMapper;
    @Autowired
    private AvisApiPassengerMapper avisApiPassengerMapper;

    @Test
    void givenSessionDto_whenMapperMap_thenPostRequestNotNull() {

        // given
        AvisApiReservationPostRequestMapper mapper = new AvisApiReservationPostRequestMapper(avisApiVehicleMapper, avisApiPassengerMapper);
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