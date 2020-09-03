package com.app.car.rental.backend.service;

import com.app.car.rental.backend.api.avis.model.rate.AvisApiRate;
import com.app.car.rental.backend.service.avis.AvisRateService;
import com.app.car.rental.backend.service.mapper.RateMapper;
import com.app.car.rental.backend.web.model.RateDto;
import com.app.car.rental.backend.web.model.request.RateRequestDto;
import org.springframework.stereotype.Service;

@Service
public class RateService {
    private AvisRateService avisRateService;
    private RateMapper rateMapper;

    public RateService(AvisRateService avisRateService, RateMapper rateMapper) {
        this.avisRateService = avisRateService;
        this.rateMapper = rateMapper;
    }

    public RateDto read(RateRequestDto rateRequestDto) {
        AvisApiRate avisApiRate = avisRateService.rates(rateRequestDto);
        return rateMapper.from(avisApiRate);
    }
}
