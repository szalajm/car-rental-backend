package com.app.car.rental.backend.repository;

import com.app.car.rental.backend.domain.NbpApi;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface NbpRepository extends CrudRepository<NbpApi, Long> {

    @Override
    List<NbpApi> findAll();

    @Override
    NbpApi save(NbpApi nbpApi);

    @Override
    Optional<NbpApi> findById(Long id);

    @Override
    void deleteById(Long id);

    @Override
    long count();
}
