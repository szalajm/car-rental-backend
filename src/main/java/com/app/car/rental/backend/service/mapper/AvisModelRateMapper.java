package com.app.car.rental.backend.service.mapper;

import com.app.car.rental.backend.api.avis.model.rate.Rate;
import com.app.car.rental.backend.web.model.AvisModelRateDto;
import org.springframework.stereotype.Service;

@Service
public class AvisModelRateMapper {

    public AvisModelRateDto mapToAvisModelRateDto (Rate rate){
        return new AvisModelRateDto(rate.getCurrency(), rate.getRateCode(), rate.getDays(),
                rate.getAmount(), rate.getTaxesFees(), rate.getAdditionalProperties());
    }
}
