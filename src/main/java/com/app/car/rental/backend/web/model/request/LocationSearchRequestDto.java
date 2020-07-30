package com.app.car.rental.backend.web.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationSearchRequestDto {
    private String pickUpLocation;
    private String dropOffLocation;
    private String pickUpDate;
    private String dropOffDate;

    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate pickUpDate,
}
