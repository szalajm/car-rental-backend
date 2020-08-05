package com.app.car.rental.backend.service;

import com.app.car.rental.backend.web.model.CategoryDto;
import com.app.car.rental.backend.web.model.ReservationDto;
import com.app.car.rental.backend.web.model.VehicleDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ReservationServiceIntegrationTest {

    @Autowired
    private ReservationService reservationService;

    @Test
    void given_when_then() {
        // given
        CategoryDto categoryDto = CategoryDto.builder()
                .name("Category A")
                .build();
        VehicleDto vehicleDto = VehicleDto.builder()
                .category(categoryDto)
                .build();
        ReservationDto reservationDto = ReservationDto.builder()
                .vehicle(vehicleDto)
                .build();

        // when
        ReservationDto createdReservationDto = reservationService.create(reservationDto);

        // then
        assertNotNull(createdReservationDto, "Created ReservationDto is null.");
    }
}