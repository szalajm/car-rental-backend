package com.app.car.rental.backend.service.mapper.avis;

import com.app.car.rental.backend.api.avis.model.reservation.post.request.Address;
import com.app.car.rental.backend.api.avis.model.reservation.post.request.Contact;
import com.app.car.rental.backend.api.avis.model.reservation.post.request.Driver;
import com.app.car.rental.backend.api.avis.model.reservation.post.request.Passenger;
import com.app.car.rental.backend.web.model.PassengerDataDto;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class AvisApiPassengerMapper {
    private static final Logger LOGGER = Logger.getLogger(AvisApiPassengerMapper.class.getName());

    public Passenger toReservationPassenger(PassengerDataDto passengerDataDto) {
        LOGGER.info("toReservationPassenger(" + passengerDataDto + ")");
        Passenger passenger = new Passenger();

        if (passengerDataDto != null) {
            passenger.setAddress(passengerAddress(passengerDataDto));
            passenger.setContact(passengerContact(passengerDataDto));
            passenger.setDriver(passengerDriver(passengerDataDto));
        }

        LOGGER.info("toReservationPassenger(...) = " + passenger);
        return passenger;
    }

    Address passengerAddress(PassengerDataDto passengerDataDto) {
        Address address = new Address();

        address.setAddressLine1(passengerDataDto.getAddressLine1());
        address.setAddressLine2(passengerDataDto.getAddressLine2());
        address.setAddressLine3(passengerDataDto.getAddressLine3());
        address.setCity(passengerDataDto.getCity());
        address.setCountryCode(passengerDataDto.getAddressCountryCode());
        address.setPostalCode(passengerDataDto.getPostalCode());

        return address;
    }

    Contact passengerContact(PassengerDataDto passengerDataDto) {
        LOGGER.info("passengerContact(" + passengerDataDto + ")");
        Contact contact = new Contact();

        contact.setFirstName(passengerDataDto.getFirstName());
        contact.setLastName(passengerDataDto.getLastName());
        contact.setTitle(passengerDataDto.getTitle());
        contact.setDateOfBirth(passengerDataDto.getDateOfBirth());
        contact.setEmail(passengerDataDto.getEmail());
        contact.setTelephone(passengerDataDto.getTelephone());

        LOGGER.info("passengerContact(...) = " + contact);
        return contact;
    }

    Driver passengerDriver(PassengerDataDto passengerDataDto) {
        Driver driver = new Driver();

        driver.setLicenseNumber(passengerDataDto.getLicenseNumber());
        driver.setCountryCode(passengerDataDto.getDriverCountryCode());
        driver.setStateCode(passengerDataDto.getStateCode());

        return driver;
    }
}
