package com.app.car.rental.backend.controller;


import com.app.car.rental.backend.api.exception.NbpNotFoundException;
import com.app.car.rental.backend.api.exception.VehicleNotFoundException;
import com.app.car.rental.backend.domain.NbpApiDto;
import com.app.car.rental.backend.mapper.NbpMapper;
import com.app.car.rental.backend.service.CarRentalService;
import org.springframework.beans.factory.annotation.Autowired;
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

@RequestMapping("/v1/nbp")
@RestController
@CrossOrigin(origins = "*")
public class NbpController {
    @Autowired
    CarRentalService carRentalService;

    @Autowired
    NbpMapper nbpMapper;

    @GetMapping(value = "/nbp")
    @ResponseBody
    public List<NbpApiDto> list() {
        return nbpMapper.mapToListNbpApiDto(carRentalService.readAllNbps());
    }

    @GetMapping(value = "/nbp/nbpId}")
    @ResponseBody
    public NbpApiDto read(@PathVariable long nbpId) throws NbpNotFoundException {
        return nbpMapper.mapToNbpApiDto(carRentalService.readNbp(nbpId).orElseThrow(NbpNotFoundException::new));
    }

    @PostMapping(path = "/nbp", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public void create(NbpApiDto nbpApiDto) {
        carRentalService.saveNbp(nbpMapper.mapToNbpApi(nbpApiDto));
    }

    @PutMapping(path = "/nbp")
    @ResponseBody
    public NbpApiDto update(Long id, NbpApiDto nbpApiDto) {
        return nbpMapper.mapToNbpApiDto(carRentalService.saveNbp(nbpMapper.mapToNbpApi(nbpApiDto)));
    }

    @DeleteMapping(value = "")
    @ResponseBody
    public void delete(@PathVariable long nbpId) throws VehicleNotFoundException {
        carRentalService.deleteNbp(nbpId); }

}
