package com.app.car.rental.backend.service.mapper.avis;

import com.app.car.rental.backend.api.avis.model.reservation.post.response.Address;
import com.app.car.rental.backend.api.avis.model.reservation.post.response.Address_;
import com.app.car.rental.backend.api.avis.model.reservation.post.response.AvisApiReservationPostResponse;
import com.app.car.rental.backend.api.avis.model.reservation.post.response.Category;
import com.app.car.rental.backend.api.avis.model.reservation.post.response.Confirmation;
import com.app.car.rental.backend.api.avis.model.reservation.post.response.DropoffLocation;
import com.app.car.rental.backend.api.avis.model.reservation.post.response.Location;
import com.app.car.rental.backend.api.avis.model.reservation.post.response.Location_;
import com.app.car.rental.backend.api.avis.model.reservation.post.response.PickupLocation;
import com.app.car.rental.backend.api.avis.model.reservation.post.response.Reservation;
import com.app.car.rental.backend.api.avis.model.reservation.post.response.Vehicle;
import com.app.car.rental.backend.web.model.CategoryDto;
import com.app.car.rental.backend.web.model.ReservationDto;
import com.app.car.rental.backend.web.model.VehicleDto;
import com.app.car.rental.backend.web.model.reservation.AddressDto;
import com.app.car.rental.backend.web.model.reservation.ConfirmationDto;
import com.app.car.rental.backend.web.model.reservation.LocationAddressDto;
import com.app.car.rental.backend.web.model.reservation.LocationDto;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class AvisApiReservationPostResponseMapper {
    private static final Logger LOGGER = Logger.getLogger(AvisApiReservationPostResponseMapper.class.getName());

    public ReservationDto from(AvisApiReservationPostResponse avisApiReservationPostResponse) {
        LOGGER.info("from(" + avisApiReservationPostResponse + ")");
        if (avisApiReservationPostResponse != null) {
            Reservation avisReservation = avisApiReservationPostResponse.getReservation();
            if (avisReservation != null) {
                Confirmation avisConfirmation = avisReservation.getConfirmation();
                PickupLocation avisPickupLocation = avisReservation.getPickupLocation();
                DropoffLocation avisDropoffLocation = avisReservation.getDropoffLocation();
                Vehicle avisVehicle = avisReservation.getVehicle();
                Category avisCategory = avisVehicle.getCategory();

                ReservationDto reservationDto = new ReservationDto();
                ConfirmationDto confirmationDto = getConfirmationDto(avisConfirmation);
                LocationAddressDto pickUpLocationAddressDto = getPickUpLocation(avisPickupLocation);
                LocationAddressDto dropOffLocationAddressDto = getDropOffLocation(avisDropoffLocation);
                VehicleDto vehicleDto = new VehicleDto();
                CategoryDto categoryDto = getCategoryDto(avisCategory);

                reservationDto.setConfirmation(confirmationDto);
                reservationDto.setPickUpLocationAddressDto(pickUpLocationAddressDto);
                reservationDto.setDropOffLocationAddressDto(dropOffLocationAddressDto);
                vehicleDto.setCategory(categoryDto);
                reservationDto.setVehicle(vehicleDto);

                LOGGER.info("from(...) = " + reservationDto);
                return reservationDto;
            }
        }

        // FIXME: return Optional!
        return null;
    }

    ConfirmationDto getConfirmationDto(Confirmation avisConfirmation) {
        return ConfirmationDto.builder()
                .number(avisConfirmation.getNumber())
                .pickupDate(avisConfirmation.getPickupDate())
                .dropoffDate(avisConfirmation.getDropoffDate())
                .build();
    }

    // TODO: should I map Distance class?

    LocationAddressDto getPickUpLocation(PickupLocation avisPickupLocation) {
        Location location = avisPickupLocation.getLocation();
        Address address = avisPickupLocation.getAddress();

        return LocationAddressDto.builder()
                .locationDto(getPickUpLocation(location))
                .addressDto(getPickUpAddress(address))
                .build();
    }

    LocationDto getPickUpLocation(Location location) {
        return LocationDto.builder()
                // FIXME: implement!
                .build();
    }

    AddressDto getPickUpAddress(Address address) {
        return AddressDto.builder()
                // FIXME: implement!
                .build();
    }

    LocationAddressDto getDropOffLocation(DropoffLocation avisDropoffLocation) {
        Location_ location = avisDropoffLocation.getLocation();
        Address_ address = avisDropoffLocation.getAddress();

        return LocationAddressDto.builder()
                .locationDto(getDropOffLocation(location))
                .addressDto(getDropOffAddress(address))
                .build();
    }

    LocationDto getDropOffLocation(Location_ location) {
        return LocationDto.builder()
                // FIXME: implement!
                .build();
    }

    AddressDto getDropOffAddress(Address_ address) {
        return AddressDto.builder()
                // FIXME: implement!
                .build();
    }

    CategoryDto getCategoryDto(Category avisCategory) {
        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setImageUrl(avisCategory.getImageUrl());
        categoryDto.setMake(avisCategory.getMake());
        categoryDto.setModel(avisCategory.getModel());
        categoryDto.setName(avisCategory.getName());
        categoryDto.setVehicleClassCode(avisCategory.getVehicleClassCode());
        categoryDto.setVehicleClassName(avisCategory.getVehicleClassName());

        return categoryDto;
    }
}
