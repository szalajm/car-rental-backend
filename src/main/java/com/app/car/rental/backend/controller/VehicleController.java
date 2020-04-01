package com.app.car.rental.backend.controller;

import com.app.car.rental.backend.api.exception.VehicleNotFoundException;
import com.app.car.rental.backend.domain.VehicleDto;
import com.app.car.rental.backend.mapper.VehicleMapper;
import com.app.car.rental.backend.service.CarRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/v1/vehicle")
//@RestController
//@CrossOrigin(origins = "*")
@Controller
//fixme zmienić na VehicleController, to samo z VehicleDto i Exceptions
public class VehicleController {

    @Autowired
    CarRentalService carRentalService;

    @Autowired
    VehicleMapper vehicleMapper;

    @GetMapping(value = "/vehicle")
    @ResponseBody
    public List<VehicleDto> list(){ return vehicleMapper.mapToVehicleDto(carRentalService.readAllVehicles());}

    @GetMapping(value = "/view/vehicle")
    public String listView(ModelMap modelMap){
        return "vehicle-fragment";
    }

    @GetMapping(value = "/vehicle/{vehicleId}")
    @ResponseBody
    public VehicleDto read(@PathVariable long vehicleId) throws VehicleNotFoundException {
        return vehicleMapper.mapToVehicleDto(carRentalService.readVehicle(vehicleId).orElseThrow(VehicleNotFoundException::new));
    }

    @GetMapping(value = "/view/vehicle")
    public String listRead(ModelMap modelMap){ return "location-fragment"; }

    @PostMapping(path = "/cars", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public void create(VehicleDto vehicleDto){
         carRentalService.saveVehicle(vehicleMapper.mapToVehicle(vehicleDto));
    }

    @GetMapping(value = "/view/vehicle")
    public String createView(ModelMap modelMap){ return "location-fragment"; }

    @PutMapping(path = "/vehicle")
    @ResponseBody
    public VehicleDto update(Long id, VehicleDto vehicle){
        return vehicleMapper.mapToVehicleDto(carRentalService.saveVehicle(vehicleMapper.mapToVehicle(vehicle)));
    }

    @GetMapping(value = "/view/vehicle")
    public String updateView(ModelMap modelMap){ return "location-fragment"; }

    @DeleteMapping(value ="")
    @ResponseBody
    public void delete (@PathVariable long carId) throws  VehicleNotFoundException {
        carRentalService.deleteVehicle(carId);
    }

    @GetMapping(value = "/view/vehicle")
    public String deleteView(ModelMap modelMap){ return "location-fragment"; }

    ///CRUD - L
    //@GetMapping List <VehicleDto> list()
    //@PostMapping VehicleDto create(VehicleDto vehicle)
    //@GetMapping VehicleDto read(Long id)
    //@PutMapping VehicleDto update(Long ig, VehicleDto vehicle)
    //@DeleteMapping void delete(Long id)

}
