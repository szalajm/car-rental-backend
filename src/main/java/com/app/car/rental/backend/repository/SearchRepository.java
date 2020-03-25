package com.app.car.rental.backend.repository;

import com.app.car.rental.backend.domain.Search;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SearchRepository extends CrudRepository<Search, Long> {
    @Override
    List<Search> findAll();

    @Override
    Search save(Search search);

    @Override
    Optional<Search> findById(Long id);

    @Override
    void deleteById(Long id);

    @Override
    long count();
}
