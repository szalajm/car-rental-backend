package com.app.car.rental.backend.service;

import com.app.car.rental.backend.dao.entity.ReservationEntity;
import com.app.car.rental.backend.dao.repository.ReservationRepository;
import com.app.car.rental.backend.service.mapper.ReservationMapper;
import com.app.car.rental.backend.web.model.ReservationDto;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    private ReservationRepository reservationRepository;
    private ReservationMapper reservationMapper;

    public ReservationService(ReservationRepository reservationRepository, ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }

    public ReservationDto create(ReservationDto reservationDto) {
        ReservationEntity reservationEntity = reservationMapper.from(reservationDto);
        ReservationEntity savedReservationEntity = reservationRepository.save(reservationEntity);

        return reservationMapper.to(savedReservationEntity);
    }
}
