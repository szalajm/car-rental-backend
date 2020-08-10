package com.app.car.rental.backend.service.mapper;

import com.app.car.rental.backend.dao.entity.ReservationEntity;
import com.app.car.rental.backend.web.model.ReservationDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReservationMapper {

    public List<ReservationDto> from(List<ReservationEntity> reservationEntities) {
        return reservationEntities.stream()
                .map(this::to)
                .collect(Collectors.toList());
    }

    public ReservationEntity from(ReservationDto reservationDto) {
        ReservationEntity reservationEntity = new ReservationEntity();

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(reservationDto, reservationEntity);

        return reservationEntity;
    }

    public ReservationDto to(ReservationEntity reservationEntity) {
        ReservationDto reservationDto = new ReservationDto();

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(reservationEntity, reservationDto);

        return reservationDto;
    }
}
