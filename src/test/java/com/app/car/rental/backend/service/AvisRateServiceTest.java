package com.app.car.rental.backend.service;

import com.app.car.rental.backend.service.avis.AvisRateService;
import com.app.car.rental.backend.web.model.request.RateRequestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AvisRateServiceTest {

    @Autowired
    private AvisRateService avisRateService;

    @Test
    public void rates() {
        RateRequestDto rateRequestDto = new RateRequestDto();
        avisRateService.rates(rateRequestDto);
    }

}
