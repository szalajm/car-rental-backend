package com.app.car.rental.backend.service;

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
import com.app.car.rental.backend.api.avis.model.reservation.post.request.Transaction;
import com.app.car.rental.backend.api.avis.model.reservation.post.response.AvisApiReservationPostResponse;
import com.app.car.rental.backend.service.avis.AvisReservationOkHttpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AvisReservationRequestServiceTest {
    @Autowired
    private AvisReservationOkHttpService avisReservationOkHttpService;
//    private AvisReservationService avisReservationService;

    @Test
    public void reservations() throws Exception{
        //Given
        AvisApiReservationPostRequest apiReservation = new AvisApiReservationPostRequest();

        Product product = new Product();
        product.setBrand("Avis");
        apiReservation.setProduct(product);

        Transaction transaction = new Transaction();
        transaction.setTransactionId("24234234");
        apiReservation.setTransaction(transaction);

        Reservation reservation = new Reservation();
        reservation.setEmailNotification(true);
        reservation.setDropoffDate("2020-11-20T12:00:00");
        reservation.setPickupDate("2020-11-15T12:00:00");
        reservation.setPickupLocation("EWR");
        reservation.setDropoffLocation("EWR");
        reservation.setVehicleClassCode("A");
        apiReservation.setReservation(reservation);

        RateTotals rateTotals = new RateTotals();

        Rate rate = new Rate();
        rate.setRateCode("DH");
        rate.setCountryCode("US");

        Discount discount = new Discount();
        discount.setCode("A442100");
        //rate.setDiscount(discount);

        Loyalty loyalty = new Loyalty();
        //rate.setLoyalty(loyalty);

        Membership membership = new Membership();
        membership.setCode("E7L15V");
        //rate.setMembership(membership);

        rateTotals.setRate(rate);
        apiReservation.setRateTotals(rateTotals);

        Passenger passenger = new Passenger();

        Contact contact = new Contact();
        //contact.setTitle("MR");
        contact.setFirstName("BRADLEY");
        contact.setLastName("STEPHEN");
        //contact.setTelephone("123456789900000");
        //contact.setEmail("BRADLEY.STEPHEN@abgservices.com");
        //contact.setAge(28);
        //contact.setDateOfBirth("1991-12-31");
        passenger.setContact(contact);

        Address address = new Address();
        address.setAddressLine1("696 Block A");
        address.setAddressLine2("Ellis St");
        address.setAddressLine3("");
        address.setCity("San Francisco");
        address.setStateName("CA");
        address.setPostalCode("94110");
        address.setCountryCode("US");
        //passenger.setAddress(address);

        Driver driver = new Driver();
        driver.setLicenseNumber("DI9000");
        driver.setStateCode("CA");
        driver.setCountryCode("US");
        //passenger.setDriver(driver);

        apiReservation.setPassenger(passenger);

        Insurance insurance = new Insurance();
        insurance.setCode("PEP");
        //apiReservation.setInsurance(Arrays.asList(insurance));

        Extra extra = new Extra();
        extra.setCode("GPS");
        extra.setQuantity(1);
        //apiReservation.setExtras(Arrays.asList(extra));

        ArrivalFlight arrivalFlight = new ArrivalFlight();
        arrivalFlight.setAirlineCode("BA");
        arrivalFlight.setAirlineNumber("349723");
        //apiReservation.setArrivalFlight(arrivalFlight);


        //apiReservation.set

        //When
        AvisApiReservationPostResponse reservations = avisReservationOkHttpService.reservations(apiReservation);
        System.out.println(reservations);

        //Then


    }

}