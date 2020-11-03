package com.app.car.rental.backend.service;

import com.app.car.rental.backend.service.avis.AvisTokenService;
import org.junit.Test;

public class AvisTokenServiceTest {

    @Test
    public void token(){
        AvisTokenService avisTokenService = new AvisTokenService();
        avisTokenService.token();
    }
}
