package com.app.car.rental.backend.service;

import com.app.car.rental.backend.domain.CarSearchRequestDto;
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
        CarSearchRequestDto carSearchRequestDto = CarSearchRequestDto.builder()
                .pickUpDate("2020-08-05T12:00:00")
                .pickUpLocation("WW1")
                .dropOffDate("2020-08-07T12:00:00")
                .dropOffLocation("WMI")
                .build();

        //When
        avisVehicleService.vehicles(carSearchRequestDto);

        //Then


    }
}