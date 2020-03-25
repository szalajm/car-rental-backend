package com.app.car.rental.backend.mapper;

import com.app.car.rental.backend.domain.Location;
import com.app.car.rental.backend.domain.LocationDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationMapper {

    public Location mapToLocation(final LocationDto locationDto){
        return new Location(locationDto.getId(), locationDto.getName());
    }

    public LocationDto mapToLocationDto(final Location location){
        return new LocationDto(location.getId(), location.getName());
    }

    public List<Location> mapToListLocation(final List<LocationDto> locationDtoList){
        return locationDtoList.stream()
                .map(t -> new Location(t.getId(), t.getName()))
                .collect(Collectors.toList());
    }

    public List<LocationDto> mapToListLocationDto(final List<Location> locationList){
        return locationList.stream()
                .map(t -> new LocationDto(t.getId(), t.getName()))
                .collect(Collectors.toList());
    }
}
