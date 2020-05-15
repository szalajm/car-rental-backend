package com.app.car.rental.backend.controller;

import com.app.car.rental.backend.mapper.LocationMapper;
import com.app.car.rental.backend.service.CarRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("v1/locations")
@RestController
@CrossOrigin(origins = "*")
public class LocationController {

    @Autowired
    CarRentalService carRentalService;

    @Autowired
    LocationMapper locationMapper;

//    @GetMapping(value = "/locations")
//    @ResponseBody
//    public List<LocationDto> list(){ return locationMapper.mapToListLocationDto(carRentalService.readAllLocations());}

    @GetMapping(value = "/list")
    public String listView(ModelMap modelMap){
        return "location-fragment";
    }

//    @GetMapping(value = "/locations/{locationId}")
//    @ResponseBody
//    public LocationDto read(@PathVariable long locationId) throws LocationNotFoundException {
//        return locationMapper.mapToLocationDto(carRentalService.readLocation(locationId).orElseThrow(LocationNotFoundException::new));
//    }
    @GetMapping(value = "/read")
    public String readView(ModelMap modelMap){ return "location-fragment"; }

//    @PostMapping(path = "/locations", consumes = "application/json", produces = "application/json")
//    @ResponseBody
//    public void create(LocationDto locationDto){
//        carRentalService.saveLocation(locationMapper.mapToLocation(locationDto));
//    }

    @GetMapping(value = "/create")
    public String createView(ModelMap modelMap) { return "location-fragment";}

//    @PutMapping(path = "/locations")
//    @ResponseBody
//    public LocationDto update(Long id, LocationDto locationDto){
//        return locationMapper.mapToLocationDto(carRentalService.saveLocation(locationMapper.mapToLocation(locationDto)));
//    }

    @GetMapping(value = "/update")
    public String updateView(ModelMap modelMap){ return "location-fragment"; }

//    @DeleteMapping(value ="/locations")
//    @ResponseBody
//    public void delete (@PathVariable long locationId) throws  LocationNotFoundException {
//        carRentalService.deleteLocation(locationId);
//    }

    @GetMapping(value =  "/delete")
    public String deleteView(ModelMap modelMap) { return "location-fragment"; }

}
