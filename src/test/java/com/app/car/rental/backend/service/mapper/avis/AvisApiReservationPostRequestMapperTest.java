package com.app.car.rental.backend.service.mapper.avis;

import com.app.car.rental.backend.api.avis.model.reservation.post.request.AvisApiReservationPostRequest;
import com.app.car.rental.backend.api.avis.model.reservation.post.request.Rate;
import com.app.car.rental.backend.api.avis.model.reservation.post.request.RateTotals;
import com.app.car.rental.backend.api.avis.model.vehicle.Vehicle;
import com.app.car.rental.backend.web.model.AvisModelSessionDto;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AvisApiReservationPostRequestMapperTest {

    public static final String RATE_CODE_AA = "AA";

    @Test
    public void givenAvisApiReservationPostRequest_whenFromAvisModelSessionDto_thenPostRequestEqauls() {

        //Given

        AvisApiRateTotalsMapper avisApiRateTotalsMapper = new AvisApiRateTotalsMapper();
        AvisApiVehicleMapper avisApiVehicleMapper = new AvisApiVehicleMapper(avisApiRateTotalsMapper);
        AvisApiPassengerMapper avisApiPassengerMapper = new AvisApiPassengerMapper();

        AvisApiReservationPostRequestMapper avisApiReservationPostRequestMapper =
                new AvisApiReservationPostRequestMapper(avisApiVehicleMapper, avisApiPassengerMapper);


        //When
        AvisModelSessionDto dto = new AvisModelSessionDto();
        Vehicle chosenVehicle = new Vehicle();

        com.app.car.rental.backend.api.avis.model.vehicle.RateTotals rateTotalsModel =
                new com.app.car.rental.backend.api.avis.model.vehicle.RateTotals();

        com.app.car.rental.backend.api.avis.model.vehicle.Rate rateModel =
                new com.app.car.rental.backend.api.avis.model.vehicle.Rate();
        rateModel.setRateCode(RATE_CODE_AA);

        rateTotalsModel.setRate(rateModel);
        chosenVehicle.setRateTotals(rateTotalsModel);
        dto.setChosenVehicle(chosenVehicle);
        AvisApiReservationPostRequest from = avisApiReservationPostRequestMapper.from(dto);

        RateTotals rateTotals = from.getRateTotals();

        Rate rate = rateTotals.getRate();

        String rateCode = rate.getRateCode();

        //Then

        assertAll(
                () -> assertNotNull(rateTotals, "rateTotals is null"),
                () -> assertNotNull(rate, "rate is null"),
                () -> assertNotNull(rateCode, "rateCode is null")
        );
    }
}