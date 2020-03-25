package com.app.car.rental.backend.repository;

import com.app.car.rental.backend.domain.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
    @Override
    List<Vehicle> findAll();

    @Override
    Vehicle save(Vehicle vehicle);

    @Override
    Optional<Vehicle> findById(Long id);

    @Override
    void deleteById(Long id);

    @Override
    long count();
}
