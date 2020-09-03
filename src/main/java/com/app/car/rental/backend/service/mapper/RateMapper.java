package com.app.car.rental.backend.service.mapper;

import com.app.car.rental.backend.api.avis.model.rate.AvisApiRate;
import com.app.car.rental.backend.web.model.RateDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RateMapper {
    public List<RateDto> from(List<AvisApiRate> avisApiRates) {
        return avisApiRates.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    public RateDto from(AvisApiRate avisApiRate) {
        return null;
    }
}
