package com.app.car.rental.backend.service;

import com.app.car.rental.backend.api.avis.model.reservation.post.request.AvisApiReservationPostRequest;
import com.app.car.rental.backend.api.avis.model.reservation.post.response.AvisApiReservationPostResponse;
import com.app.car.rental.backend.api.avis.model.vehicle.AvisApiVehicle;
import com.app.car.rental.backend.api.avis.model.vehicle.Vehicle;
import com.app.car.rental.backend.api.exception.VehicleNotFoundException;
import com.app.car.rental.backend.service.avis.AvisReservationOkHttpService;
import com.app.car.rental.backend.service.mapper.avis.AvisApiReservationPostRequestMapper;
import com.app.car.rental.backend.service.mapper.avis.AvisApiReservationPostResponseMapper;
import com.app.car.rental.backend.service.util.AvisApiVehicleUtil;
import com.app.car.rental.backend.web.model.AvisModelSessionDto;
import com.app.car.rental.backend.web.model.ReservationDto;
import com.app.car.rental.backend.web.model.request.CarReservationRequestDto;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ReservationManagerService {

    private static final Logger LOGGER = Logger.getLogger(ReservationManagerService.class.getName());

    private AvisReservationOkHttpService avisReservationOkHttpService;
    private AvisApiReservationPostRequestMapper avisApiReservationPostRequestMapper;
    private AvisApiReservationPostResponseMapper avisApiReservationPostResponseMapper;

    public ReservationManagerService(AvisReservationOkHttpService avisReservationOkHttpService,
                                     AvisApiReservationPostRequestMapper avisApiReservationPostRequestMapper,
                                     AvisApiReservationPostResponseMapper avisApiReservationPostResponseMapper) {
        this.avisReservationOkHttpService = avisReservationOkHttpService;
        this.avisApiReservationPostRequestMapper = avisApiReservationPostRequestMapper;
        this.avisApiReservationPostResponseMapper = avisApiReservationPostResponseMapper;
    }

    public Optional<ReservationDto> reserve(CarReservationRequestDto carReservationRequestDto,
                                            AvisModelSessionDto avisModelSessionDto) throws Exception {
        LOGGER.info("reserve()");
        LOGGER.info("carReservationRequestDto: " + carReservationRequestDto);
        LOGGER.info("avisModelSessionDto: " + avisModelSessionDto);

        if (carReservationRequestDto != null) {
            String requestDtoVehicleId = avisModelSessionDto.getChosenVehicleId();
            if (avisModelSessionDto != null) {
                AvisApiVehicle avisApiVehicle = avisModelSessionDto.getAvisApiVehicle();
                Optional<Vehicle> optionalVehicle = AvisApiVehicleUtil.findVehicleById(requestDtoVehicleId, avisApiVehicle);
                Vehicle vehicle = optionalVehicle.orElseThrow(
                        () -> new VehicleNotFoundException("Vehicle with ID: " + requestDtoVehicleId + " not found."));

                avisModelSessionDto.setChosenVehicle(vehicle);

                AvisApiReservationPostRequest apiReservation = avisApiReservationPostRequestMapper.from(avisModelSessionDto);
                AvisApiReservationPostResponse avisApiReservationPostResponse = avisReservationOkHttpService.reservations(apiReservation);

                Optional<ReservationDto> reservationDtoOptional = avisApiReservationPostResponseMapper.from(avisApiReservationPostResponse);
//                return reservationDtoOptional.orElseThrow(() -> new ReservationNotMappedException("AvisApiReservationPostResponse not mapped"));
                return reservationDtoOptional;
            }
        }

        return Optional.empty();
    }
}
