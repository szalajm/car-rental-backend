package com.app.car.rental.backend.mapper;

import com.app.car.rental.backend.domain.Rate;
import com.app.car.rental.backend.domain.RateDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RateMapper {

    public Rate mapToRate(RateDto rateDto) {
        return new Rate(rateDto.getId(), rateDto.getName());
    }

    public RateDto mapToRateDto(Rate rate) {
        return new RateDto(rate.getId(), rate.getName());
    }

    public List<Rate> mapToListRate(List<RateDto> rateDtoList) {
        return rateDtoList.stream()
                .map(t -> new Rate(t.getId(), t.getName()))
                .collect(Collectors.toList());
    }

    public List<RateDto> mapToListRateDto(List<Rate>rateList){
        return rateList.stream()
                .map(t -> new RateDto(t.getId(), t.getName()))
                .collect(Collectors.toList());

    }

}

