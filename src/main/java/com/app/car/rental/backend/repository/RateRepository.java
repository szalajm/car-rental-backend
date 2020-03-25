package com.app.car.rental.backend.repository;

import com.app.car.rental.backend.domain.Rate;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RateRepository extends CrudRepository<Rate, Long> {
    @Override
    List<Rate> findAll();

    @Override
    Rate save(Rate rate);

    @Override
    Optional<Rate> findById(Long id);

    @Override
    void deleteById(Long id);

    @Override
    long count();
}
