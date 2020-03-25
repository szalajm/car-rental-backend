package com.app.car.rental.backend.repository;


import com.app.car.rental.backend.domain.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LocationRepository extends CrudRepository<Location, Long> {
    @Override
    List<Location> findAll();

    @Override
    Location save(Location location);

    @Override
    Optional<Location> findById(Long id);

    @Override
    void deleteById(Long id);

    @Override
    long count();
}
