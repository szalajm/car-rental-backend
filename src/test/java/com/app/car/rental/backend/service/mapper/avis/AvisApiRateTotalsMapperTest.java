package com.app.car.rental.backend.service.mapper.avis;

import com.app.car.rental.backend.api.avis.model.vehicle.Rate;
import com.app.car.rental.backend.api.avis.model.vehicle.RateTotals;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AvisApiRateTotalsMapperTest {

    private static final String RATE_CODE_7JI = "7JI";
    private static final String CURRENCY_PL = "PL";

    @Test
    void givenTotalRatesModel_whenToReservationRate_thenTotalRatesEquals() {
        // given
        AvisApiRateTotalsMapper avisApiRateTotalsMapper = new AvisApiRateTotalsMapper();

        Rate rate = new Rate();
        rate.setRateCode(RATE_CODE_7JI);
        rate.setCurrency(CURRENCY_PL);

        RateTotals rateTotals = new RateTotals();
        rateTotals.setRate(rate);

        // when
        com.app.car.rental.backend.api.avis.model.reservation.post.request.Rate avisApiRate =
                avisApiRateTotalsMapper.toReservationRate(rateTotals);

        // then
        assertAll(
                () -> assertNotNull(avisApiRate),
                () -> assertEquals(avisApiRate.getRateCode(), RATE_CODE_7JI, "Rate codes aren't equals.")
        );
    }
}