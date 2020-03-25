package com.app.car.rental.backend.mapper;

import com.app.car.rental.backend.domain.NbpApi;
import com.app.car.rental.backend.domain.NbpApiDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NbpMapper {

    public NbpApi mapToNbpApi (final NbpApiDto nbpApiDto){
        return new NbpApi(nbpApiDto.getId(), nbpApiDto.getName());
    }

    public NbpApiDto mapToNbpApiDto (final NbpApi nbpApi){
        return new NbpApiDto(nbpApi.getId(), nbpApi.getName());
    }

    public List<NbpApi> mapToListNbpApi (final List<NbpApiDto> nbpApiDtoList){
        return nbpApiDtoList.stream()
                .map(t -> new NbpApi(t.getId(), t.getName()))
                .collect(Collectors.toList());
    }

    public List<NbpApiDto> mapToListNbpApiDto (final List<NbpApi> nbpApiList){
        return nbpApiList.stream()
                .map(t -> new NbpApiDto(t.getId(), t.getName()))
                .collect(Collectors.toList());
    }


}
