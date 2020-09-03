package com.app.car.rental.backend.service;

import com.app.car.rental.backend.dao.entity.ReservationEntity;
import com.app.car.rental.backend.dao.repository.ReservationRepository;
import com.app.car.rental.backend.service.mapper.ReservationMapper;
import com.app.car.rental.backend.web.model.ReservationDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ReservationService {
    private static final Logger LOGGER = Logger.getLogger(ReservationService.class.getName());

    private ReservationRepository reservationRepository;
    private ReservationMapper reservationMapper;
    private RateService rateService;

    public ReservationService(ReservationRepository reservationRepository, ReservationMapper reservationMapper,
                              RateService rateService) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
        this.rateService = rateService;
    }

    public List<ReservationDto> list() {
        List<ReservationEntity> reservationEntities = reservationRepository.findAll();
        return reservationMapper.from(reservationEntities);
    }

    public ReservationDto create(ReservationDto reservationDto) {
        LOGGER.info("create(" + reservationDto + ")");
        ReservationEntity reservationEntity = reservationMapper.from(reservationDto);
        ReservationEntity savedReservationEntity = reservationRepository.save(reservationEntity);

        return reservationMapper.to(savedReservationEntity);
    }
}
