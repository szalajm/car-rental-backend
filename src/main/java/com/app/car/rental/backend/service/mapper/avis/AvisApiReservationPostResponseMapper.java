package com.app.car.rental.backend.service.mapper.avis;

import com.app.car.rental.backend.api.avis.model.reservation.post.response.AvisApiReservationPostResponse;
import com.app.car.rental.backend.api.avis.model.reservation.post.response.Category;
import com.app.car.rental.backend.api.avis.model.reservation.post.response.Reservation;
import com.app.car.rental.backend.api.avis.model.reservation.post.response.Vehicle;
import com.app.car.rental.backend.web.model.CategoryDto;
import com.app.car.rental.backend.web.model.ReservationDto;
import com.app.car.rental.backend.web.model.VehicleDto;
import org.springframework.stereotype.Component;

@Component
public class AvisApiReservationPostResponseMapper {
    public ReservationDto from(AvisApiReservationPostResponse avisApiReservationPostResponse) {
        if (avisApiReservationPostResponse != null) {
            Reservation avisReservation = avisApiReservationPostResponse.getReservation();
            if (avisReservation != null) {
                Vehicle avisVehicle = avisReservation.getVehicle();
                Category avisCategory = avisVehicle.getCategory();

                ReservationDto reservationDto = new ReservationDto();
                VehicleDto vehicleDto = new VehicleDto();
                CategoryDto categoryDto = new CategoryDto();

                categoryDto.setImageUrl(avisCategory.getImageUrl());
                categoryDto.setMake(avisCategory.getMake());
                categoryDto.setModel(avisCategory.getModel());
                categoryDto.setName(avisCategory.getName());
                categoryDto.setVehicleClassCode(avisCategory.getVehicleClassCode());
                categoryDto.setVehicleClassName(avisCategory.getVehicleClassName());

                vehicleDto.setCategory(categoryDto);
                reservationDto.setVehicle(vehicleDto);

                return reservationDto;
            }
        }

        // FIXME: return Optional!
        return null;
    }
}
