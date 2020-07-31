package com.app.car.rental.backend.web.controller;

import com.app.car.rental.backend.api.avis.model.location.AvisApiLocation;
import com.app.car.rental.backend.api.avis.model.reservation.post.request.AvisApiReservationPostRequest;
import com.app.car.rental.backend.api.avis.model.reservation.post.response.AvisApiReservationPostResponse;
import com.app.car.rental.backend.api.avis.model.vehicle.AvisApiVehicle;
import com.app.car.rental.backend.service.CarRentalService;
import com.app.car.rental.backend.service.avis.AvisReservationService;
import com.app.car.rental.backend.service.mapper.avis.AvisApiReservationPostRequestMapper;
import com.app.car.rental.backend.service.mapper.avis.AvisApiReservationPostResponseMapper;
import com.app.car.rental.backend.web.model.AvisModelSessionDto;
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

@Controller
@RequestMapping("/v1/rental")
@SessionAttributes(names = {ControllerConstants.AVIS_MODEL_DTO_ATTRIBUTE_SESSION})
public class CarRentalController {

    private static final Logger LOGGER = Logger.getLogger(CarRentalController.class.getName());

    private CarRentalService carRentalService;
    private AvisReservationService avisReservationService;
    private AvisApiReservationPostRequestMapper avisApiReservationPostRequestMapper;
    private AvisApiReservationPostResponseMapper avisApiReservationPostResponseMapper;

    public CarRentalController(CarRentalService carRentalService, AvisReservationService avisReservationService,
                               AvisApiReservationPostRequestMapper avisApiReservationPostRequestMapper,
                               AvisApiReservationPostResponseMapper avisApiReservationPostResponseMapper) {
        this.carRentalService = carRentalService;
        this.avisReservationService = avisReservationService;
        this.avisApiReservationPostRequestMapper = avisApiReservationPostRequestMapper;
        this.avisApiReservationPostResponseMapper = avisApiReservationPostResponseMapper;
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
        if(avisModelSessionDto != null) {
            avisModelSessionDto.setAvisApiVehicle(avisApiVehicle);
            modelMap.addAttribute(ControllerConstants.AVIS_MODEL_DTO_ATTRIBUTE_SESSION,avisModelSessionDto);
        }
        LOGGER.info("avisApiVehicle: " + avisApiVehicle);
        LOGGER.info("avisModelSessionDto: " + avisModelSessionDto);
        modelMap.addAttribute("vehicles", avisApiVehicle.getVehicles());
        modelMap.addAttribute("carReservation", new CarReservationRequestDto());
        return "car-choose";
    }

    @GetMapping("/cars/choose")
    @ResponseBody
    public AvisModelSessionDto carChoose(
            @ModelAttribute(name = "carReservation") CarReservationRequestDto carReservationRequestDto,
            @RequestParam(name = "categoryName") String categoryName,
            @RequestParam(name = "categoryMake") String categoryMake,
            @RequestParam(name = "vehicleClassCode") String vehicleClassCode,
            ModelMap modelMap) {
        LOGGER.info("carChoose(" + categoryName + ")");
        LOGGER.info("carChoose(" + categoryMake + ")");
        LOGGER.info("carChoose(" + vehicleClassCode + ")");
        LOGGER.info("carReservation(" + carReservationRequestDto + ")");
        AvisModelSessionDto avisModelSessionDto = (AvisModelSessionDto) modelMap.getAttribute(ControllerConstants.AVIS_MODEL_DTO_ATTRIBUTE_SESSION);
        if(avisModelSessionDto != null) {
            avisModelSessionDto.setCategoryName(categoryName);
            avisModelSessionDto.setCategoryMake(categoryMake);
            avisModelSessionDto.setVehicleClassCode(vehicleClassCode);
            modelMap.addAttribute(ControllerConstants.AVIS_MODEL_DTO_ATTRIBUTE_SESSION,avisModelSessionDto);
        }


        return new AvisModelSessionDto();
    }

    @PostMapping("/cars/reservation")
    public String carReservationView(
            @ModelAttribute(name = "carReservation") CarReservationRequestDto carReservationRequestDto,
//            @RequestBody CarReservationVehicleRequestDto carReservationRequestDto,
            ModelMap modelMap) {
        LOGGER.info("carReservationView");
        LOGGER.info("carReservationRequestDto: " + carReservationRequestDto);
        AvisModelSessionDto avisModelSessionDto = (AvisModelSessionDto) modelMap.getAttribute(ControllerConstants.AVIS_MODEL_DTO_ATTRIBUTE_SESSION);
        if(avisModelSessionDto != null) {
            //avisModelSessionDto.setAvisApiVehicle(avisApiVehicle);
            modelMap.addAttribute(ControllerConstants.AVIS_MODEL_DTO_ATTRIBUTE_SESSION,avisModelSessionDto);
            LOGGER.info("avisModelSessionDto: " + avisModelSessionDto);
            try {
                AvisApiReservationPostRequest apiReservation = avisApiReservationPostRequestMapper.from(avisModelSessionDto);
                AvisApiReservationPostResponse reservations = avisReservationService.reservations(apiReservation);

                ReservationDto reservationDto = avisApiReservationPostResponseMapper.from(reservations);
                // TODO: add and implement ReservationService!
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "car-reservation";
    }

}