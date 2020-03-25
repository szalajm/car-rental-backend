package com.app.car.rental.backend.mapper;

import com.app.car.rental.backend.api.nbp.model.NbpApi;
import com.app.car.rental.backend.domain.NbpModelApiDto;
import org.springframework.stereotype.Service;

@Service
public class NbpModelApiMapper {

    public NbpModelApiDto mapToNboModelApiDto(NbpApi nbpApi){
        return new NbpModelApiDto(nbpApi.getTable(), nbpApi.getNo(), nbpApi.getEffectiveDate(),
                nbpApi.getRates(),nbpApi.getAdditionalProperties());
    }
}
