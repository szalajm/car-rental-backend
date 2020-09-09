package com.app.car.rental.backend.service;

import com.app.car.rental.backend.api.avis.model.reservation.post.request.AvisApiReservationPostRequest;
import com.app.car.rental.backend.api.avis.model.reservation.post.response.AvisApiReservationPostResponse;
import com.app.car.rental.backend.api.avis.model.vehicle.AvisApiVehicle;
import com.app.car.rental.backend.api.avis.model.vehicle.Vehicle;
import com.app.car.rental.backend.api.exception.VehicleNotFoundException;
import com.app.car.rental.backend.service.avis.AvisReservationService;
import com.app.car.rental.backend.service.mapper.avis.AvisApiReservationPostRequestMapper;
import com.app.car.rental.backend.service.mapper.avis.AvisApiReservationPostResponseMapper;
import com.app.car.rental.backend.service.util.AvisApiVehicleUtil;
import com.app.car.rental.backend.web.model.AvisModelSessionDto;
import com.app.car.rental.backend.web.model.ReservationDto;
import com.app.car.rental.backend.web.model.request.CarReservationRequestDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationManagerService {

    private AvisReservationService avisReservationService;
    private AvisApiReservationPostRequestMapper avisApiReservationPostRequestMapper;
    private AvisApiReservationPostResponseMapper avisApiReservationPostResponseMapper;

    public ReservationManagerService(AvisReservationService avisReservationService,
                                     AvisApiReservationPostRequestMapper avisApiReservationPostRequestMapper,
                                     AvisApiReservationPostResponseMapper avisApiReservationPostResponseMapper) {
        this.avisReservationService = avisReservationService;
        this.avisApiReservationPostRequestMapper = avisApiReservationPostRequestMapper;
        this.avisApiReservationPostResponseMapper = avisApiReservationPostResponseMapper;
    }

    public ReservationDto reserve(CarReservationRequestDto carReservationRequestDto,
                                  AvisModelSessionDto avisModelSessionDto) throws Exception {

        if (carReservationRequestDto != null) {
            String requestDtoVehicleId = avisModelSessionDto.getChosenVehicleId();
            if (avisModelSessionDto != null) {
                AvisApiVehicle avisApiVehicle = avisModelSessionDto.getAvisApiVehicle();
                Optional<Vehicle> optionalVehicle = AvisApiVehicleUtil.findVehicleById(requestDtoVehicleId, avisApiVehicle);
                Vehicle vehicle = optionalVehicle.orElseThrow(
                        () -> new VehicleNotFoundException("Vehicle with ID: " + requestDtoVehicleId + " not found."));

                avisModelSessionDto.setChosenVehicle(vehicle);

                AvisApiReservationPostRequest apiReservation = avisApiReservationPostRequestMapper.from(avisModelSessionDto);
                AvisApiReservationPostResponse reservations = avisReservationService.reservations(apiReservation);

                return avisApiReservationPostResponseMapper.from(reservations);
            }
        }

        return null;
    }
}
