package com.app.car.rental.backend.service;

import com.app.car.rental.backend.domain.web.LocationSearchRequestDto;
import com.app.car.rental.backend.service.avis.AvisVehicleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AvisVehicleServiceTest {

    @Autowired
    private AvisVehicleService avisVehicleService;

    @Test
    public void vehicles() {
        //Given
        LocationSearchRequestDto locationSearchRequestDto = LocationSearchRequestDto.builder()
                .pickUpDate("2020-08-05T12:00:00")
                .pickUpLocation("GDN")
                .dropOffDate("2020-08-07T12:00:00")
                .dropOffLocation("GDN")
                .build();

        //When
        avisVehicleService.vehicles(locationSearchRequestDto);

        //Then


    }
}