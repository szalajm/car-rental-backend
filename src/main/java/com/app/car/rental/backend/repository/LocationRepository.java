package com.app.car.rental.backend.repository;


import com.app.car.rental.backend.domain.LocationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LocationRepository extends CrudRepository<LocationEntity, Long> {
    @Override
    List<LocationEntity> findAll();

    @Override
    LocationEntity save(LocationEntity locationEntity);

    @Override
    Optional<LocationEntity> findById(Long id);

    @Override
    void deleteById(Long id);

    @Override
    long count();
}
