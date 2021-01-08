package com.app.car.rental.backend.web.controller;

import com.app.car.rental.backend.api.avis.model.location.AvisApiLocation;
import com.app.car.rental.backend.api.avis.model.vehicle.AvisApiVehicle;
import com.app.car.rental.backend.api.exception.AvisApiException;
import com.app.car.rental.backend.api.exception.reservation.ReservationException;
import com.app.car.rental.backend.service.CarRentalService;
import com.app.car.rental.backend.service.ReservationManagerService;
import com.app.car.rental.backend.service.ReservationService;
import com.app.car.rental.backend.web.model.AvisModelSessionDto;
import com.app.car.rental.backend.web.model.PassengerDataDto;
import com.app.car.rental.backend.web.model.ReservationDto;
import com.app.car.rental.backend.web.model.request.CarReservationRequestDto;
import com.app.car.rental.backend.web.model.request.LocationSearchRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;

import static com.app.car.rental.backend.web.controller.ControllerConstants.CAR_CHOOSE_URI;
import static com.app.car.rental.backend.web.controller.ControllerConstants.CAR_CHOOSE_VIEW;
import static com.app.car.rental.backend.web.controller.ControllerConstants.CAR_RESERVATION_VIEW;
import static com.app.car.rental.backend.web.controller.ControllerConstants.LOCATIONS_CHOOSE_URI;
import static com.app.car.rental.backend.web.controller.ControllerConstants.LOCATION_SEARCH_ATTRIBUTE;
import static com.app.car.rental.backend.web.controller.ControllerConstants.LOCATION_SEARCH_URI;
import static com.app.car.rental.backend.web.controller.ControllerConstants.LOCATION_SEARCH_VIEW;
import static com.app.car.rental.backend.web.controller.ControllerConstants.PASSENGER_DATA_URI;
import static com.app.car.rental.backend.web.controller.ControllerConstants.PASSENGER_DATA_VIEW;
import static com.app.car.rental.backend.web.controller.ControllerConstants.RESERVATIONS_ATTRIBUTE;
import static com.app.car.rental.backend.web.controller.ControllerConstants.RESERVATIONS_URI;
import static com.app.car.rental.backend.web.controller.ControllerConstants.RESERVATIONS_VIEW;
import static com.app.car.rental.backend.web.controller.ControllerConstants.RESERVATION_CONFIRMATION_URI;
import static com.app.car.rental.backend.web.controller.ControllerConstants.RESERVATION_CONFIRMATION_VIEW;

@Controller
@RequestMapping("/v1/rental")
@SessionAttributes(names = {ControllerConstants.AVIS_MODEL_DTO_ATTRIBUTE_SESSION})
public class CarRentalController {

    private static final Logger LOGGER = Logger.getLogger(CarRentalController.class.getName());

    private CarRentalService carRentalService;
    private ReservationService reservationService;
    private ReservationManagerService reservationManagerService;

    public CarRentalController(CarRentalService carRentalService,
                               ReservationService reservationService,
                               ReservationManagerService reservationManagerService) {
        this.carRentalService = carRentalService;
        this.reservationService = reservationService;
        this.reservationManagerService = reservationManagerService;
    }

    @GetMapping(LOCATION_SEARCH_URI)
    public String locationSearchView(ModelMap modelMap) {
        modelMap.addAttribute(LOCATION_SEARCH_ATTRIBUTE, new LocationSearchRequestDto());
        modelMap.addAttribute(ControllerConstants.AVIS_MODEL_DTO_ATTRIBUTE_SESSION, new AvisModelSessionDto());
        return LOCATION_SEARCH_VIEW;
    }

    @PostMapping(LOCATIONS_CHOOSE_URI)
    public String locationChooseView(
            @Valid @ModelAttribute(name = LOCATION_SEARCH_ATTRIBUTE) LocationSearchRequestDto locationSearchRequestDto,
            BindingResult bindingResult, ModelMap modelMap) {
        LOGGER.info("#### locationSearch: " + locationSearchRequestDto);

        if (bindingResult.hasErrors()) {
            LOGGER.info("validation errors for: " + locationSearchRequestDto);
            return LOCATION_SEARCH_VIEW;
        }

        AvisApiLocation pickUpLocations = carRentalService.locationSearch(locationSearchRequestDto.getPickUpLocation());
        AvisApiLocation dropOffLocations = carRentalService.locationSearch(locationSearchRequestDto.getDropOffLocation());

        AvisModelSessionDto avisModelSessionDto = (AvisModelSessionDto) modelMap.getAttribute(ControllerConstants.AVIS_MODEL_DTO_ATTRIBUTE_SESSION);
        if (avisModelSessionDto != null) {
            avisModelSessionDto.setAvisApiDropOffLocation(dropOffLocations);
            avisModelSessionDto.setAvisApiPickUpLocation(pickUpLocations);
            avisModelSessionDto.setPickUpDate(locationSearchRequestDto.getPickUpDate());
            avisModelSessionDto.setDropOffDate(locationSearchRequestDto.getDropOffDate());
            modelMap.addAttribute(ControllerConstants.AVIS_MODEL_DTO_ATTRIBUTE_SESSION, avisModelSessionDto);
        }

        modelMap.addAttribute("pickUpLocations", pickUpLocations.getLocations());
        modelMap.addAttribute("dropOffLocations", dropOffLocations.getLocations());
        modelMap.addAttribute("carSearch", new LocationSearchRequestDto());

        return "location-choose";
    }

    @PostMapping("/cars/choose")
    public String carChooseView(
            @ModelAttribute(name = "carSearch") LocationSearchRequestDto locationSearchRequestDto,
            ModelMap modelMap) throws IOException, AvisApiException {
        LOGGER.info("carChooseView");
        LOGGER.info("locationSearchRequestDto: " + locationSearchRequestDto);

        AvisModelSessionDto avisModelSessionDto = (AvisModelSessionDto) modelMap.getAttribute(ControllerConstants.AVIS_MODEL_DTO_ATTRIBUTE_SESSION);
        if (avisModelSessionDto != null) {
            // FIXME: PickUpDate and DropOffDate should be handled in a different way!
            locationSearchRequestDto.setPickUpDate(avisModelSessionDto.getPickUpDate());
            locationSearchRequestDto.setDropOffDate(avisModelSessionDto.getDropOffDate());

            AvisApiVehicle avisApiVehicle = carRentalService.carSearch(locationSearchRequestDto);

            avisModelSessionDto.setAvisApiVehicle(avisApiVehicle);
            modelMap.addAttribute(ControllerConstants.AVIS_MODEL_DTO_ATTRIBUTE_SESSION, avisModelSessionDto);

            LOGGER.info("avisApiVehicle: " + avisApiVehicle);
            LOGGER.info("avisModelSessionDto: " + avisModelSessionDto);
            modelMap.addAttribute("vehicles", avisApiVehicle.getVehicles());
        }

        modelMap.addAttribute("carReservation", new CarReservationRequestDto());
        modelMap.addAttribute("passengerData", new PassengerDataDto());

        return CAR_CHOOSE_VIEW;
    }

    @GetMapping(CAR_CHOOSE_URI)
    @ResponseBody
    //NOTE: uzywane w js przy klikniecie na samochod
    public AvisModelSessionDto carChoose(
            @ModelAttribute(name = "carReservation") CarReservationRequestDto carReservationRequestDto,
            @RequestParam(name = "vehicleId") String vehicleId,
            ModelMap modelMap) {
        LOGGER.info("carChoose(" + vehicleId + ")");
        LOGGER.info("carReservation(" + carReservationRequestDto + ")");
        AvisModelSessionDto avisModelSessionDto = (AvisModelSessionDto) modelMap.getAttribute(ControllerConstants.AVIS_MODEL_DTO_ATTRIBUTE_SESSION);
        if (avisModelSessionDto != null) {
            avisModelSessionDto.setChosenVehicleId(vehicleId);
            modelMap.addAttribute(ControllerConstants.AVIS_MODEL_DTO_ATTRIBUTE_SESSION, avisModelSessionDto);
        }

        // NOTE: needs to return sth
        return new AvisModelSessionDto();
    }

    @PostMapping(PASSENGER_DATA_URI)
//    public String locationChooseView(
//            @Valid @ModelAttribute(name = LOCATION_SEARCH_ATTRIBUTE) LocationSearchRequestDto locationSearchRequestDto,
//            BindingResult bindingResult, ModelMap modelMap) {
    public String passengerDataView(
            @ModelAttribute(name = "carReservation") CarReservationRequestDto carReservationRequestDto,
            @ModelAttribute(name = "passengerData") PassengerDataDto passengerDataDto,
            ModelMap modelMap) {
        LOGGER.info("passengerDataView: " + carReservationRequestDto);
        LOGGER.info("passengerData: " + passengerDataDto);


        AvisModelSessionDto avisModelSessionDto = (AvisModelSessionDto) modelMap.getAttribute(ControllerConstants.AVIS_MODEL_DTO_ATTRIBUTE_SESSION);
        if (avisModelSessionDto != null) {
            avisModelSessionDto.setPassengerDataDto(passengerDataDto);
            modelMap.addAttribute(ControllerConstants.AVIS_MODEL_DTO_ATTRIBUTE_SESSION, avisModelSessionDto);
        }

        return PASSENGER_DATA_VIEW;
    }

    @PostMapping("/cars/reservation")
    public String carReservationView(
            @ModelAttribute(name = "carReservation") CarReservationRequestDto carReservationRequestDto,
            @Valid @ModelAttribute(name = "passengerData") PassengerDataDto passengerDataDto,
            BindingResult bindingResult, ModelMap modelMap) throws Exception {

        LOGGER.info("carReservationView");
        LOGGER.info("carReservationRequestDto: " + carReservationRequestDto);
        LOGGER.info("passengerDataDto: " + passengerDataDto);
        if (bindingResult.hasErrors()) {
            return PASSENGER_DATA_VIEW;
        }

        AvisModelSessionDto avisModelSessionDto = (AvisModelSessionDto) modelMap.getAttribute(ControllerConstants.AVIS_MODEL_DTO_ATTRIBUTE_SESSION);
        if (avisModelSessionDto != null) {
            avisModelSessionDto.setPassengerDataDto(passengerDataDto);
            modelMap.addAttribute(ControllerConstants.AVIS_MODEL_DTO_ATTRIBUTE_SESSION, avisModelSessionDto);
            LOGGER.info("avisModelSessionDto: " + avisModelSessionDto);

            Optional<ReservationDto> reservationDtoOptional = reservationManagerService.reserve(carReservationRequestDto, avisModelSessionDto);
            ReservationDto reservationDto = reservationDtoOptional.orElseThrow(() -> new ReservationException("Unable to reserve car"));
            reservationService.create(reservationDto);
        }

        return CAR_RESERVATION_VIEW;
    }

    @PostMapping(RESERVATION_CONFIRMATION_URI)
    //@ModelAttribute("session_atribute")
    public String confirmationData(@ModelAttribute(name = "passengerData") PassengerDataDto mocker, ModelMap modelMap) {

        AvisModelSessionDto avisModelSessionDto = (AvisModelSessionDto) modelMap.getAttribute(ControllerConstants.AVIS_MODEL_DTO_ATTRIBUTE_SESSION);
        if (avisModelSessionDto != null) {
            modelMap.addAttribute(ControllerConstants.AVIS_MODEL_DTO_ATTRIBUTE_SESSION, avisModelSessionDto);
            modelMap.addAttribute("link", avisModelSessionDto);
        }
        modelMap.addAttribute("name", "name");

        return RESERVATION_CONFIRMATION_VIEW;
    }

    @GetMapping(RESERVATIONS_URI)
    public String carReservationsView(ModelMap modelMap) {
        LOGGER.info("Listing reservations...");

        modelMap.addAttribute(RESERVATIONS_ATTRIBUTE, reservationService.list());

        return RESERVATIONS_VIEW;
    }
}
