package com.app.car.rental.backend.service.mapper;

import com.app.car.rental.backend.api.avis.model.location.Location;
import com.app.car.rental.backend.web.model.AvisModelLocationDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AvisModelLocationMapperTest {

    @Test
    void fromLocation() {
    //Given
        AvisModelLocationMapper avisModelLocationMapper = new AvisModelLocationMapper();
        Location location = new Location();
        //When
        AvisModelLocationDto avisModelLocationDto = avisModelLocationMapper.fromLocation(location);
        //Then
        assertNotNull(avisModelLocationDto);
    }
}