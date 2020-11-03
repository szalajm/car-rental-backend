package com.app.car.rental.backend.service.mapper.avis;

import com.app.car.rental.backend.api.avis.model.location.AvisApiLocation;
import com.app.car.rental.backend.api.avis.model.location.Location;
import com.app.car.rental.backend.api.avis.model.reservation.post.request.ArrivalFlight;
import com.app.car.rental.backend.api.avis.model.reservation.post.request.AvisApiReservationPostRequest;
import com.app.car.rental.backend.api.avis.model.reservation.post.request.Discount;
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
import com.app.car.rental.backend.service.util.AvisApiVehicleUtil;
import com.app.car.rental.backend.service.util.RequestDateUtil;
import com.app.car.rental.backend.web.model.AvisModelSessionDto;
import com.app.car.rental.backend.web.model.PassengerDataDto;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Component
public class AvisApiReservationPostRequestMapper {

    private static final Logger LOGGER = Logger.getLogger(AvisApiReservationPostRequestMapper.class.getName());

    private AvisApiVehicleMapper avisApiVehicleMapper;
    private AvisApiPassengerMapper avisApiPassengerMapper;

    public AvisApiReservationPostRequestMapper(AvisApiVehicleMapper avisApiVehicleMapper,
                                               AvisApiPassengerMapper avisApiPassengerMapper) {
        this.avisApiVehicleMapper = avisApiVehicleMapper;
        this.avisApiPassengerMapper = avisApiPassengerMapper;
    }

    public AvisApiReservationPostRequest from(AvisModelSessionDto dto) {
        LOGGER.info("from(" + dto + ")");
        AvisApiReservationPostRequest reservationPostRequest = new AvisApiReservationPostRequest();

        Vehicle chosenAvisApiVehicle = dto.getChosenVehicle();
        String vehicleClassCode = AvisApiVehicleUtil.extractVehicleClassCode(chosenAvisApiVehicle);

        PassengerDataDto passengerDataDto = dto.getPassengerDataDto();

//        reservationPostRequest.set -> dto.get
        AvisApiLocation avisApiPickUpLocation = dto.getAvisApiPickUpLocation();
        String pickUpLocationCode = extractLocationCode(avisApiPickUpLocation);
        AvisApiLocation avisApiDropOffLocation = dto.getAvisApiDropOffLocation();
        String dropOffLocationCode = extractLocationCode(avisApiDropOffLocation);

        String pickUpDate = dto.getPickUpDate();
        String dropOffDate = dto.getDropOffDate();

//        Transaction transaction = new Transaction();
//        transaction.setTransactionId("24234234");
//        reservationPostRequest.setTransaction(transaction);

        // RESERVATION
        Reservation reservation = new Reservation();
        reservation.setEmailNotification(true);
        reservation.setPickupDate(RequestDateUtil.addTimeToDate(pickUpDate));
        reservation.setDropoffDate(RequestDateUtil.addTimeToDate(dropOffDate));
        reservation.setPickupLocation(pickUpLocationCode);
        reservation.setDropoffLocation(dropOffLocationCode);
        reservation.setVehicleClassCode(vehicleClassCode);
        reservationPostRequest.setReservation(reservation);

        // PRODUCT
        // FIXME: implement Product Mapper! Added only to showcase saved Reservations!
        Product product = new Product();
        product.setBrand("Avis");
        reservationPostRequest.setProduct(product);

        // RATE
//        AvisApiRate dtoAvisApiRate = dto.getAvisApiRate();
//        Rate rate = avisApiRateMapper.toReservationRate(dtoAvisApiRate);
        // FIXME: verify the below mapping!
        Rate rate = avisApiVehicleMapper.extractReservationRate(chosenAvisApiVehicle);

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
        Passenger passenger = avisApiPassengerMapper.toReservationPassenger(passengerDataDto);
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

        LOGGER.info("from(...) = " + reservationPostRequest);
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
