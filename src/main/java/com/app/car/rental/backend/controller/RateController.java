package com.app.car.rental.backend.controller;

import com.app.car.rental.backend.api.exception.RateNotFoundException;
import com.app.car.rental.backend.domain.RateDto;
import com.app.car.rental.backend.mapper.RateMapper;
import com.app.car.rental.backend.service.CarRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("v1/rates")
@RestController
@CrossOrigin(origins = "*")
public class RateController {

    @Autowired
    CarRentalService carRentalService;

    @Autowired
    RateMapper rateMapper;

    @GetMapping(value = "/rates")
    @ResponseBody
    public List<RateDto> list(){ return rateMapper.mapToListRateDto(carRentalService.readAllRates());}

    @GetMapping(value = "/view/rates")
    public String listView(ModelMap modelMap){
        return "vehicle-fragment";
    }

    @GetMapping(value = "/rates/{rateId}")
    @ResponseBody
    public RateDto read(@PathVariable long rateId) throws RateNotFoundException {
        return rateMapper.mapToRateDto(carRentalService.readRate(rateId).orElseThrow(RateNotFoundException::new));
    }

    @GetMapping(value = "/view/rates")
    public String readView(ModelMap modelMap){ return "location-fragment"; }

    @PostMapping(path = "/rates", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public void create(RateDto rateDto){
        carRentalService.saveRate(rateMapper.mapToRate(rateDto));
    }

    @GetMapping(value = "/view/rates")
    public String createView(ModelMap modelMap){ return "location-fragment"; }

    @PutMapping(path = "/rates")
    @ResponseBody
    public RateDto update(Long id, RateDto rateDto){
        return rateMapper.mapToRateDto(carRentalService.saveRate(rateMapper.mapToRate(rateDto)));
    }

    @GetMapping(value = "/view/rates")
    public String updateView(ModelMap modelMap){ return "location-fragment"; }

    @DeleteMapping(value ="")
    @ResponseBody
    public void delete (@PathVariable long rateId) throws  RateNotFoundException {
        carRentalService.deleteRate(rateId);
    }

    @GetMapping(value = "/view/rates")
    public String deleteView(ModelMap modelMap){ return "location-fragment"; }
}


