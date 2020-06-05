package com.app.car.rental.backend.controller;

import com.app.car.rental.backend.api.avis.model.location.Location;
import com.app.car.rental.backend.api.avis.model.vehicle.AvisApiVehicle;
import com.app.car.rental.backend.domain.CarSearchRequestDto;
import com.app.car.rental.backend.service.CarRentalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/v1/rental")
public class CarRentalController {

    private static final Logger LOGGER = Logger.getLogger(CarRentalController.class.getName());

    private CarRentalService carRentalService;

    public CarRentalController(CarRentalService carRentalService) {
        this.carRentalService = carRentalService;
    }

    @GetMapping
    public String rentalView(ModelMap modelMap){
        return "car-rental";
    }

    @PostMapping("/car-search")
    public String carSearchView(
            @RequestParam String pickUpLocation,
            @RequestParam String dropOffLocation,
            ModelMap modelMap){
        LOGGER.info("pickUpLocation: " + pickUpLocation);
        LOGGER.info("dropOffLocation: " + dropOffLocation);
        List<Location> pickUpLocations = carRentalService.locationSearch(pickUpLocation);
        List<Location> dropOffLocations = carRentalService.locationSearch(dropOffLocation);
        modelMap.addAttribute("pickUpLocations",pickUpLocations);
        modelMap.addAttribute("dropOffLocations",dropOffLocations);
        modelMap.addAttribute("carSearch", new CarSearchRequestDto());
        return "car-search";
    }

    @PostMapping("/car-choose")
    public String carChooseView(
            //@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate pickUpDate,
            @ModelAttribute(name ="carSearch") CarSearchRequestDto carSearchRequestDto,
            ModelMap modelMap){
        LOGGER.info("carChooseView");
        LOGGER.info("carSearchRequestDto: " + carSearchRequestDto);
       AvisApiVehicle avisApiVehicle = carRentalService.carSearch(carSearchRequestDto);
       LOGGER.info("avisApiVehicle: " + avisApiVehicle);
       modelMap.addAttribute("vehicles", avisApiVehicle.getVehicles());
        return "car-choose";
    }




}
