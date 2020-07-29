package com.app.car.rental.backend.service.mapper.avis;

import com.app.car.rental.backend.api.avis.model.location.AvisApiLocation;
import com.app.car.rental.backend.api.avis.model.location.Location;
import com.app.car.rental.backend.api.avis.model.rate.AvisApiRate;
import com.app.car.rental.backend.api.avis.model.reservation.post.request.*;
import com.app.car.rental.backend.web.model.AvisModelSessionDto;
import com.app.car.rental.backend.service.mapper.avis.AvisApiRateMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AvisApiReservationPostRequestMapper {

    private AvisApiRateMapper avisApiRateMapper;

    public AvisApiReservationPostRequestMapper(AvisApiRateMapper avisApiRateMapper) {
        this.avisApiRateMapper = avisApiRateMapper;
    }

    public AvisApiReservationPostRequest from(AvisModelSessionDto dto) {
        AvisApiReservationPostRequest reservationPostRequest = new AvisApiReservationPostRequest();

//        reservationPostRequest.set -> dto.get
        AvisApiLocation avisApiPickUpLocation = dto.getAvisApiPickUpLocation();
        String pickUpLocationCode = extractLocationCode(avisApiPickUpLocation);
        AvisApiLocation avisApiDropOffLocation = dto.getAvisApiDropOffLocation();
        String dropOffLocationCode = extractLocationCode(avisApiDropOffLocation);

        // RESERVATION
        Reservation reservation = new Reservation();
        reservation.setEmailNotification(true);
        reservation.setDropoffDate(dto.getDropOffDate());
        reservation.setPickupDate(dto.getPickUpDate());
        reservation.setPickupLocation(pickUpLocationCode);
        reservation.setDropoffLocation(dropOffLocationCode);
        reservation.setVehicleClassCode(dto.getVehicleClassCode());
        reservationPostRequest.setReservation(reservation);

        // RATE
        AvisApiRate dtoAvisApiRate = dto.getAvisApiRate();
        Rate rate = avisApiRateMapper.toReservationRate(dtoAvisApiRate);

        RateTotals rateTotals = new RateTotals();
        rateTotals.setRate(rate);
        reservationPostRequest.setRateTotals(rateTotals);

        //DISCOUNT
//        Discount discount = new Discount();
//        discount.setCode("A442100");
//        rate.setDiscount(discount);

//        Loyalty loyalty = new Loyalty();
        //rate.setLoyalty(loyalty);


        return reservationPostRequest;
    }

    String extractLocationCode(AvisApiLocation avisApiLocation) {
        if (avisApiLocation != null) {
            List<Location> locations = avisApiLocation.getLocations();
            if (locations != null && locations.size() > 0) {
                Location location = locations.get(0);
                if (location != null) {
                    return location.getCode();
                }
            }
        }

        return null;
    }
}
