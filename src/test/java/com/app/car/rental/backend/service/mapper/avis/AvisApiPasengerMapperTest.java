package com.app.car.rental.backend.service.mapper.avis;

import com.app.car.rental.backend.api.avis.model.reservation.post.request.Passenger;
import com.app.car.rental.backend.web.model.PassengerDataDto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AvisApiPasengerMapperTest {
    private static final String CITY_WARSAW = "Warsaw";

    @Test
    public void givenPassengerModel_whenToReservationPasenger_ThenPassengerDataDtoEquals() {

        //Given
        AvisApiPassengerMapper avisApiPassengerMapper = new AvisApiPassengerMapper();

        PassengerDataDto passengerDataDto = new PassengerDataDto();
        passengerDataDto.setCity(CITY_WARSAW);
        //When

        Passenger avisApiPassenger = avisApiPassengerMapper.toReservationPassenger(passengerDataDto);

        //Then
        assertAll(
                () -> assertNotNull(avisApiPassenger),
                () -> assertEquals(avisApiPassenger.getAddress().getCity(), CITY_WARSAW, "Cities aren't equal")

        );

    }


}
