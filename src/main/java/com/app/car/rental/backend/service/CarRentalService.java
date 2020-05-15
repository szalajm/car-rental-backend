package com.app.car.rental.backend.service;

//import com.app.car.rental.backend.api.avis.model.location.Location;

//import com.app.car.rental.backend.api.nbp.model.NbpApi;

import com.app.car.rental.backend.api.avis.model.location.AvisApiLocation;
import com.app.car.rental.backend.api.avis.model.location.Location;
import com.app.car.rental.backend.domain.*;
import com.app.car.rental.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarRentalService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    RateRepository rateRepository;

    @Autowired
    SearchRepository searchRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    NbpRepository nbpRepository;

    @Autowired
    private AvisLocationService avisLocationService;

    @Autowired
    private  AvisVehicleService avisVehicleService;


    public List<Location> locationSearch(String location){
        AvisApiLocation avisApiLocation = avisLocationService.locations(location);
        if(avisApiLocation!=null){
            List<Location> locations = avisApiLocation.getLocations();
            return locations;
        }
        return null;
    }

    public void carSearch(CarSearchRequestDto carSearchRequestDto){
        avisVehicleService.vehicles(carSearchRequestDto);
    }

    public List<Vehicle> readAllVehicles() {
        return vehicleRepository.findAll();
    }

    public VehicleRepository getVehicleRepository() {
        return vehicleRepository;
    }

    public void setVehicleRepository(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public LocationRepository getLocationRepository() {
        return locationRepository;
    }

    public void setLocationRepository(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public RateRepository getRateRepository() {
        return rateRepository;
    }

    public void setRateRepository(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    public SearchRepository getSearchRepository() {
        return searchRepository;
    }

    public void setSearchRepository(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public NbpRepository getNbpRepository() {
        return nbpRepository;
    }

    public void setNbpRepository(NbpRepository nbpRepository) {
        this.nbpRepository = nbpRepository;
    }

    public Optional<Vehicle> readVehicle(final Long id) {
        return vehicleRepository.findById(id);
    }

    public Vehicle saveVehicle(final Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(final Long id) {
        vehicleRepository.deleteById(id);
    }

    public List<LocationEntity> readAllLocations() {
        return locationRepository.findAll();
    }

    public Optional<LocationEntity> readLocation(final Long id) {
        return locationRepository.findById(id);
    }

    public LocationEntity saveLocation(final LocationEntity locationEntity) {
        return locationRepository.save(locationEntity);
    }

    public void deleteLocation(final Long id) {
        locationRepository.deleteById(id);
    }

    public List<Rate> readAllRates() { return rateRepository.findAll(); }

    public Optional<Rate> readRate(final Long id) { return rateRepository.findById(id); }

    public Rate saveRate(final Rate rate) { return rateRepository.save(rate); }

    public void deleteRate(final Long id) { rateRepository.deleteById(id); }

    public List<NbpApi> readAllNbps() { return nbpRepository.findAll(); }

    public Optional<NbpApi> readNbp(final Long id) { return nbpRepository.findById(id); }

    public NbpApi saveNbp(final NbpApi nbpApi) {
        return nbpRepository.save(nbpApi);
    }

    public void deleteNbp(final Long id) { nbpRepository.deleteById(id); }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(final Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(final User user) {
        return userRepository.save(user);
    }

    public void deleteUser(final Long id) {
        userRepository.deleteById(id);
    }

}
