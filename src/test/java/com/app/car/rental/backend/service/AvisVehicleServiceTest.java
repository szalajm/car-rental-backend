package com.app.car.rental.backend.service;

import com.app.car.rental.backend.api.exception.AvisApiException;
import com.app.car.rental.backend.service.avis.AvisVehicleOkHttpService;
import com.app.car.rental.backend.service.util.RequestDateUtil;
import com.app.car.rental.backend.web.model.request.LocationSearchRequestDto;
import com.app.car.rental.backend.service.avis.AvisVehicleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AvisVehicleServiceTest {

    @Autowired
    private AvisVehicleOkHttpService avisVehicleService;

    @Test
    public void vehicles() throws IOException, AvisApiException {
        //Given
        LocationSearchRequestDto locationSearchRequestDto = LocationSearchRequestDto.builder()
                .pickUpDate("2021-12-15")
                .pickUpLocation("GDN")
                .dropOffDate("2021-12-17")
                .dropOffLocation("GDN")
                .build();

        //When
        avisVehicleService.vehicles(locationSearchRequestDto);

        //Then
    }
}