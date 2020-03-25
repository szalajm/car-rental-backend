package com.app.car.rental.backend.mapper;

import com.app.car.rental.backend.api.avis.model.rate.Rate;
import com.app.car.rental.backend.domain.AvisModelRateDto;
import org.springframework.stereotype.Service;

@Service
public class AvisModelRateMapper {

    public AvisModelRateDto mapToAvisModelRateDto (Rate rate){
        return new AvisModelRateDto(rate.getCurrency(), rate.getRateCode(), rate.getDays(),
                rate.getAmount(), rate.getTaxesFees(), rate.getAdditionalProperties());
    }
}
