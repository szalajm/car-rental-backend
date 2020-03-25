package com.app.car.rental.backend.mapper;

import com.app.car.rental.backend.domain.Vehicle;
import com.app.car.rental.backend.domain.VehicleDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VehicleMapper {

    public List<VehicleDto> mapToVehicleDto(final List<Vehicle> vehicleList){
        return vehicleList.stream()
                //.map(t -> new VehicleDto(t.getCategory(),t.getFeatures(),t.getCapacity(), t.getRateTotals(),t.getAdditionalProperties()))
                .map(t -> new VehicleDto())
                .collect(Collectors.toList());
    }

    public List<Vehicle> mapToVehicleList(final List<VehicleDto> vehicleDtoList){
        return vehicleDtoList.stream()
                .map(t -> new Vehicle(t.getId(), t.getName()))
                .collect(Collectors.toList());
    }

    public VehicleDto mapToVehicleDto(final Vehicle vehicle){
        return new VehicleDto(vehicle.getId(), vehicle.getName()); }

    public Vehicle mapToVehicle(final VehicleDto vehicleDto){
        return new Vehicle(vehicleDto.getId(), vehicleDto.getName());
    }

    }
