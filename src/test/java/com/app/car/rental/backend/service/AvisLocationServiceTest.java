package com.app.car.rental.backend.service;

import com.app.car.rental.backend.api.exception.AvisApiException;
import com.app.car.rental.backend.service.avis.AvisLocationOkHttpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AvisLocationServiceTest {
    @Autowired
    private AvisLocationOkHttpService avisLocationOkHttpService;

    @Test
    public void locations() throws IOException, AvisApiException {
        avisLocationOkHttpService.locations("warszawa");
    }

    @Test
    public void givenLocationNull_whenServiceLocations_thenStatusError() throws IOException, AvisApiException {
        avisLocationOkHttpService.locations(null);
    }
}