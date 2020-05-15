package com.app.car.rental.backend.mapper;

import com.app.car.rental.backend.domain.LocationEntity;
import com.app.car.rental.backend.domain.LocationDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationMapper {

    public LocationEntity mapToLocation(final LocationDto locationDto){
        return new LocationEntity(locationDto.getId(), locationDto.getName());
    }

    public LocationDto mapToLocationDto(final LocationEntity locationEntity){
        return new LocationDto(locationEntity.getId(), locationEntity.getName());
    }

    public List<LocationEntity> mapToListLocation(final List<LocationDto> locationDtoList){
        return locationDtoList.stream()
                .map(t -> new LocationEntity(t.getId(), t.getName()))
                .collect(Collectors.toList());
    }

    public List<LocationDto> mapToListLocationDto(final List<LocationEntity> locationEntityList){
        return locationEntityList.stream()
                .map(t -> new LocationDto(t.getId(), t.getName()))
                .collect(Collectors.toList());
    }
}
