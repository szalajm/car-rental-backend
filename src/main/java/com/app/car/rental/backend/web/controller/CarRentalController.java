package com.app.car.rental.backend.web.controller;

import com.app.car.rental.backend.api.avis.model.location.AvisApiLocation;
import com.app.car.rental.backend.api.avis.model.vehicle.AvisApiVehicle;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.logging.Logger;

import static com.app.car.rental.backend.web.controller.ControllerConstants.RESERVATIONS_ATTRIBUTE;

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

    @GetMapping("/locations/search")
    public String locationSearchView(ModelMap modelMap) {
        modelMap.addAttribute("locationSearch", new LocationSearchRequestDto());
        modelMap.addAttribute(ControllerConstants.AVIS_MODEL_DTO_ATTRIBUTE_SESSION, new AvisModelSessionDto());
        return "location-search";
    }

    @PostMapping("/locations/choose")
    public String locationChooseView(
//            @RequestParam String pickUpLocation,
//            @RequestParam String dropOffLocation,
            @ModelAttribute(name = "locationSearch") LocationSearchRequestDto locationSearchRequestDto,
            ModelMap modelMap) {
//        LOGGER.info("pickUpLocation: " + pickUpLocation);
//        LOGGER.info("dropOffLocation: " + dropOffLocation);
        LOGGER.info("locationSearch: " + locationSearchRequestDto);
        AvisApiLocation pickUpLocations = carRentalService.locationSearch(locationSearchRequestDto.getPickUpLocation());
        AvisApiLocation dropOffLocations = carRentalService.locationSearch(locationSearchRequestDto.getDropOffLocation());

       AvisModelSessionDto avisModelSessionDto = (AvisModelSessionDto) modelMap.getAttribute(ControllerConstants.AVIS_MODEL_DTO_ATTRIBUTE_SESSION);
       if(avisModelSessionDto != null) {
           avisModelSessionDto.setAvisApiDropOffLocation(dropOffLocations);
           avisModelSessionDto.setAvisApiPickUpLocation(pickUpLocations);
           modelMap.addAttribute(ControllerConstants.AVIS_MODEL_DTO_ATTRIBUTE_SESSION, avisModelSessionDto);
       }

        modelMap.addAttribute("pickUpLocations", pickUpLocations.getLocations());
        modelMap.addAttribute("dropOffLocations", dropOffLocations.getLocations());
        modelMap.addAttribute("carSearch", new LocationSearchRequestDto());
        return "location-choose";
    }

    @PostMapping("/cars/choose")
    public String carChooseView(
            //@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate pickUpDate,
            @ModelAttribute(name = "carSearch") LocationSearchRequestDto locationSearchRequestDto,
            ModelMap modelMap) {
        LOGGER.info("carChooseView");
        LOGGER.info("locationSearchRequestDto: " + locationSearchRequestDto);
        AvisApiVehicle avisApiVehicle = carRentalService.carSearch(locationSearchRequestDto);
        AvisModelSessionDto avisModelSessionDto = (AvisModelSessionDto) modelMap.getAttribute(ControllerConstants.AVIS_MODEL_DTO_ATTRIBUTE_SESSION);
        if (avisModelSessionDto != null) {
            avisModelSessionDto.setAvisApiVehicle(avisApiVehicle);
            modelMap.addAttribute(ControllerConstants.AVIS_MODEL_DTO_ATTRIBUTE_SESSION, avisModelSessionDto);
        }
        LOGGER.info("avisApiVehicle: " + avisApiVehicle);
        LOGGER.info("avisModelSessionDto: " + avisModelSessionDto);
        modelMap.addAttribute("vehicles", avisApiVehicle.getVehicles());
        modelMap.addAttribute("carReservation", new CarReservationRequestDto());

        modelMap.addAttribute("passengerData", new PassengerDataDto());

        return "car-choose";
    }

    @GetMapping("/cars/choose")
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

    @PostMapping("/cars/reservation")
    public String carReservationView(
            @ModelAttribute(name = "carReservation") CarReservationRequestDto carReservationRequestDto,
            ModelMap modelMap) {
        LOGGER.info("carReservationView");
        LOGGER.info("carReservationRequestDto: " + carReservationRequestDto);

        AvisModelSessionDto avisModelSessionDto = (AvisModelSessionDto) modelMap.getAttribute(ControllerConstants.AVIS_MODEL_DTO_ATTRIBUTE_SESSION);
        if(avisModelSessionDto != null) {
            modelMap.addAttribute(ControllerConstants.AVIS_MODEL_DTO_ATTRIBUTE_SESSION, avisModelSessionDto);
            LOGGER.info("avisModelSessionDto: " + avisModelSessionDto);

            try {
                ReservationDto reservationDto = reservationManagerService.reserve(carReservationRequestDto, avisModelSessionDto);
                reservationService.create(reservationDto);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "car-reservation";
    }

    @GetMapping("/passenger/data")
    public String passengerDataView(@ModelAttribute(name = "passengerData") PassengerDataDto passengerDataDto,
                                    ModelMap modelMap) {
        AvisModelSessionDto avisModelSessionDto = (AvisModelSessionDto) modelMap.getAttribute(ControllerConstants.AVIS_MODEL_DTO_ATTRIBUTE_SESSION);
        if (avisModelSessionDto != null) {
            avisModelSessionDto.setPassengerDataDto(passengerDataDto);
            modelMap.addAttribute(ControllerConstants.AVIS_MODEL_DTO_ATTRIBUTE_SESSION, avisModelSessionDto);

        }
        return "passenger-data";
    }

    @PostMapping("/confirmation")
    //@ModelAttribute("session_atribute")
    public String confirmationData(@ModelAttribute(name = "passengerData") PassengerDataDto mocker, ModelMap modelMap) {

        AvisModelSessionDto avisModelSessionDto = (AvisModelSessionDto) modelMap.getAttribute(ControllerConstants.AVIS_MODEL_DTO_ATTRIBUTE_SESSION);
        if (avisModelSessionDto != null) {
            modelMap.addAttribute(ControllerConstants.AVIS_MODEL_DTO_ATTRIBUTE_SESSION, avisModelSessionDto);
            modelMap.addAttribute("link", avisModelSessionDto);
        }
        modelMap.addAttribute("name", "name");

        return "reservation-confirmation";
    }

    @GetMapping("/reservations")
    public String carReservationsView(ModelMap modelMap) {
        LOGGER.info("Listing reservations...");

        modelMap.addAttribute(RESERVATIONS_ATTRIBUTE, reservationService.list());

        return "reservations";
    }
}
