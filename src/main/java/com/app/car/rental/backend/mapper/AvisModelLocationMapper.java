package com.app.car.rental.backend.mapper;

import com.app.car.rental.backend.api.avis.model.location.Location;
import com.app.car.rental.backend.domain.AvisModelLocationDto;
import org.springframework.stereotype.Service;

@Service
public class AvisModelLocationMapper {

    public AvisModelLocationDto mapToAvisModelLocationDto(Location location){
        return new AvisModelLocationDto(location.getBrand(), location.getCode(), location.getCode(),
                location.getTelephone(), location.getHours(), location.getAirportLocation(),
                location.getAddress(), location.getAdditionalProperties());
    }
}
