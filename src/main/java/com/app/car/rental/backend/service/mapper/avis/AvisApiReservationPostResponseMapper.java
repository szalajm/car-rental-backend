package com.app.car.rental.backend.service.mapper.avis;

import com.app.car.rental.backend.api.avis.model.reservation.post.response.Address;
import com.app.car.rental.backend.api.avis.model.reservation.post.response.Address_;
import com.app.car.rental.backend.api.avis.model.reservation.post.response.AvisApiReservationPostResponse;
import com.app.car.rental.backend.api.avis.model.reservation.post.response.Category;
import com.app.car.rental.backend.api.avis.model.reservation.post.response.Confirmation;
import com.app.car.rental.backend.api.avis.model.reservation.post.response.Distance;
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
import com.app.car.rental.backend.web.model.reservation.DistanceDto;
import com.app.car.rental.backend.web.model.reservation.LocationAddressDto;
import com.app.car.rental.backend.web.model.reservation.LocationDto;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.logging.Logger;

@Component
public class AvisApiReservationPostResponseMapper {
    private static final Logger LOGGER = Logger.getLogger(AvisApiReservationPostResponseMapper.class.getName());

    public Optional<ReservationDto> from(AvisApiReservationPostResponse avisApiReservationPostResponse) {
        LOGGER.info("from(" + avisApiReservationPostResponse + ")");
        if (avisApiReservationPostResponse != null) {
            Reservation avisReservation = avisApiReservationPostResponse.getReservation();
            if (avisReservation != null) {
                Confirmation avisConfirmation = avisReservation.getConfirmation();
                Distance avisDistance = avisReservation.getDistance();
                PickupLocation avisPickupLocation = avisReservation.getPickupLocation();
                DropoffLocation avisDropoffLocation = avisReservation.getDropoffLocation();
                Vehicle avisVehicle = avisReservation.getVehicle();
                Category avisCategory = avisVehicle.getCategory();

                ReservationDto reservationDto = new ReservationDto();
                ConfirmationDto confirmationDto = getConfirmationDto(avisConfirmation);
                DistanceDto distanceDto = getDistanceDto(avisDistance);
                LocationAddressDto pickUpLocationAddressDto = getPickUpLocation(avisPickupLocation);
                LocationAddressDto dropOffLocationAddressDto = getDropOffLocation(avisDropoffLocation);
                VehicleDto vehicleDto = new VehicleDto();
                CategoryDto categoryDto = getCategoryDto(avisCategory);

                reservationDto.setConfirmation(confirmationDto);
                reservationDto.setDistance(distanceDto);
                reservationDto.setPickUpLocationAddressDto(pickUpLocationAddressDto);
                reservationDto.setDropOffLocationAddressDto(dropOffLocationAddressDto);
                vehicleDto.setCategory(categoryDto);
                reservationDto.setVehicle(vehicleDto);

                LOGGER.info("from(...) = " + reservationDto);
                return Optional.of(reservationDto);
            }
        }

        return Optional.empty();
    }

    ConfirmationDto getConfirmationDto(Confirmation avisConfirmation) {
        return ConfirmationDto.builder()
                .number(avisConfirmation.getNumber())
                .pickupDate(avisConfirmation.getPickupDate())
                .dropoffDate(avisConfirmation.getDropoffDate())
                .build();
    }

    DistanceDto getDistanceDto(Distance avisDistance) {
        return DistanceDto.builder()
                .distanceUnit(avisDistance.getDistanceUnit())
                .unlimitedDistance(avisDistance.getUnlimitedDistance())
                .build();
    }

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
                .airportLocation(location.getAirportLocation())
                .code(location.getCode())
                .hours(location.getHours())
                .name(location.getName())
                .telephone(location.getTelephone())
                .build();
    }

    AddressDto getPickUpAddress(Address address) {
        return AddressDto.builder()
                .addressLine1(address.getAddressLine1())
                .addressLine2(address.getAddressLine2())
                .city(address.getCity())
                .countryCode(address.getCountryCode())
                .postalCode(address.getPostalCode())
                .stateName(address.getStateName())
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
                .airportLocation(location.getAirportLocation())
                .code(location.getCode())
                .hours(location.getHours())
                .name(location.getName())
                .telephone(location.getTelephone())
                .build();
    }

    AddressDto getDropOffAddress(Address_ address) {
        return AddressDto.builder()
                .addressLine1(address.getAddressLine1())
                .addressLine2(address.getAddressLine2())
                .city(address.getCity())
                .countryCode(address.getCountryCode())
                .postalCode(address.getPostalCode())
                .stateName(address.getStateName())
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
