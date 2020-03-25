package com.app.car.rental.backend.mapper;

import com.app.car.rental.backend.api.nbp.model.Rate;
import com.app.car.rental.backend.domain.NbpModelRateDto;
import org.springframework.stereotype.Service;

@Service
public class NbpModelRateMapper {

    public NbpModelRateDto mapToNbpModelRateDto(Rate rate){
        return new NbpModelRateDto(rate.getCurrency(), rate.getCode(), rate.getMid(),
                rate.getAdditionalProperties());
    }
}
