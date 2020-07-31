package com.app.car.rental.backend.service.mapper;

import com.app.car.rental.backend.dao.entity.ReservationEntity;
import com.app.car.rental.backend.web.model.ReservationDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {
    public ReservationEntity from(ReservationDto reservationDto) {
        ReservationEntity reservationEntity = new ReservationEntity();

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(reservationDto, reservationEntity);

        return reservationEntity;
    }
}