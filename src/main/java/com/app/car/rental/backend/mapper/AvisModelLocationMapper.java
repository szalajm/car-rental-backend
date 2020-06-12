package com.app.car.rental.backend.mapper;

import com.app.car.rental.backend.api.avis.model.location.Location;
import com.app.car.rental.backend.domain.web.AvisModelLocationDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AvisModelLocationMapper {

    public AvisModelLocationDto fromLocation(Location location){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(location, AvisModelLocationDto.class);
//        return new AvisModelLocationDto(location.getBrand(), location.getCode(), location.getCode(),
//                location.getTelephone(), location.getHours(), location.getAirportLocation(),
//                location.getAddress(), location.getAdditionalProperties());
        //return null;
    }
}
