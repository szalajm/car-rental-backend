package com.app.car.rental.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1/rental")
public class CarRentalController {

    @GetMapping
    public String rentalView(ModelMap modelMap){
        return "car-rental";
    }

}
