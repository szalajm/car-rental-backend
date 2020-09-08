package com.app.car.rental.backend.service.mapper.avis;

import com.app.car.rental.backend.api.avis.model.location.AvisApiLocation;
import com.app.car.rental.backend.api.avis.model.location.Location;
import com.app.car.rental.backend.api.avis.model.rate.AvisApiRate;
import com.app.car.rental.backend.api.avis.model.reservation.post.request.Address;
import com.app.car.rental.backend.api.avis.model.reservation.post.request.ArrivalFlight;
import com.app.car.rental.backend.api.avis.model.reservation.post.request.AvisApiReservationPostRequest;
import com.app.car.rental.backend.api.avis.model.reservation.post.request.Contact;
import com.app.car.rental.backend.api.avis.model.reservation.post.request.Discount;
import com.app.car.rental.backend.api.avis.model.reservation.post.request.Driver;
import com.app.car.rental.backend.api.avis.model.reservation.post.request.Extra;
import com.app.car.rental.backend.api.avis.model.reservation.post.request.Insurance;
import com.app.car.rental.backend.api.avis.model.reservation.post.request.Loyalty;
import com.app.car.rental.backend.api.avis.model.reservation.post.request.Membership;
import com.app.car.rental.backend.api.avis.model.reservation.post.request.Passenger;
import com.app.car.rental.backend.api.avis.model.reservation.post.request.Product;
import com.app.car.rental.backend.api.avis.model.reservation.post.request.Rate;
import com.app.car.rental.backend.api.avis.model.reservation.post.request.RateTotals;
import com.app.car.rental.backend.api.avis.model.reservation.post.request.Reservation;
import com.app.car.rental.backend.api.avis.model.vehicle.Vehicle;
import com.app.car.rental.backend.web.model.AvisModelSessionDto;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class AvisApiReservationPostRequestMapper {

    private AvisApiRateMapper avisApiRateMapper;
    private AvisApiVehicleMapper avisApiVehicleMapper;

    public AvisApiReservationPostRequestMapper(AvisApiRateMapper avisApiRateMapper, AvisApiVehicleMapper avisApiVehicleMapper) {
        this.avisApiRateMapper = avisApiRateMapper;
        this.avisApiVehicleMapper = avisApiVehicleMapper;
    }

    public AvisApiReservationPostRequest from(AvisModelSessionDto dto) {
        AvisApiReservationPostRequest reservationPostRequest = new AvisApiReservationPostRequest();

        Vehicle chosenAvisApiVehicle = dto.getChosenVehicle();


//        reservationPostRequest.set -> dto.get
        AvisApiLocation avisApiPickUpLocation = dto.getAvisApiPickUpLocation();
        String pickUpLocationCode = extractLocationCode(avisApiPickUpLocation);
        AvisApiLocation avisApiDropOffLocation = dto.getAvisApiDropOffLocation();
        String dropOffLocationCode = extractLocationCode(avisApiDropOffLocation);

//        Transaction transaction = new Transaction();
//        transaction.setTransactionId("24234234");
//        reservationPostRequest.setTransaction(transaction);

        // RESERVATION
        Reservation reservation = new Reservation();
        reservation.setEmailNotification(true);
        reservation.setDropoffDate("2020-10-20T12:00:00");
//        reservation.setDropoffDate(dto.getDropOffDate());
        reservation.setPickupDate("2020-10-18T12:00:00");
//        reservation.setPickupDate(dto.getPickUpDate());
        reservation.setPickupLocation("EWR");
//        reservation.setPickupLocation(pickUpLocationCode);
        reservation.setDropoffLocation("EWR");
//        reservation.setDropoffLocation(dropOffLocationCode);
//        reservation.setVehicleClassCode(dto.getVehicleClassCode());
        reservation.setVehicleClassCode("A");
        reservationPostRequest.setReservation(reservation);

        // PRODUCT
        // FIXME: implement Product Mapper! Added only to showcase saved Reservations!
        Product product = new Product();
        product.setBrand("Avis");
        reservationPostRequest.setProduct(product);

        // RATE
        AvisApiRate dtoAvisApiRate = dto.getAvisApiRate();
//        Rate rate = avisApiRateMapper.toReservationRate(dtoAvisApiRate);
        // FIXME: verify the below mapping!
        Rate rate = avisApiVehicleMapper.toReservationRate(chosenAvisApiVehicle);

        // DISCOUNT
        // FIXME: implement Discount Mapper! Added only to showcase saved Reservations!
        Discount discount = new Discount();
        discount.setCode("A442100");
        rate.setDiscount(discount);

        Loyalty loyalty = new Loyalty();
        rate.setLoyalty(loyalty);

        // MEMBERSHIP
        // FIXME: implement Membership Mapper! Added only to showcase saved Reservations!
        Membership membership = new Membership();
        membership.setCode("E7L15V");
        rate.setMembership(membership);

        RateTotals rateTotals = new RateTotals();
        rateTotals.setRate(rate);
        reservationPostRequest.setRateTotals(rateTotals);

        // PASSENGER
        // FIXME: implement Passenger Mapper! Added only to showcase saved Reservations!
        Passenger passenger = new Passenger();

        Contact contact = new Contact();
        contact.setTitle("MR");
        contact.setFirstName("BRADLEY");
        contact.setLastName("STEPHEN");
        contact.setTelephone("123456789900000");
        contact.setEmail("BRADLEY.STEPHEN@abgservices.com");
        contact.setAge(28);
        contact.setDateOfBirth("1991-12-31");
        passenger.setContact(contact);

        Address address = new Address();
        address.setAddressLine1("696 Block A");
        address.setAddressLine2("Ellis St");
        address.setAddressLine3("");
        address.setCity("San Francisco");
        address.setStateName("CA");
        address.setPostalCode("94110");
        address.setCountryCode("US");
        passenger.setAddress(address);

        Driver driver = new Driver();
        driver.setLicenseNumber("DI9000");
        driver.setStateCode("CA");
        driver.setCountryCode("US");
        passenger.setDriver(driver);

        reservationPostRequest.setPassenger(passenger);

        // Insurance
        // FIXME: implement Insurance Mapper! Added only to showcase saved Reservations!
        Insurance insurance = new Insurance();
        insurance.setCode("PEP");
        reservationPostRequest.setInsurance(Arrays.asList(insurance));

        // Extra
        // FIXME: implement Extra Mapper! Added only to showcase saved Reservations!
        Extra extra = new Extra();
        extra.setCode("GPS");
        extra.setQuantity(1);
        reservationPostRequest.setExtras(Arrays.asList(extra));

        // ArrivalFlight
        // FIXME: implement ArrivalFlight Mapper! Added only to showcase saved Reservations!
        ArrivalFlight arrivalFlight = new ArrivalFlight();
        arrivalFlight.setAirlineCode("BA");
        arrivalFlight.setAirlineNumber("349723");
        reservationPostRequest.setArrivalFlight(arrivalFlight);

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
