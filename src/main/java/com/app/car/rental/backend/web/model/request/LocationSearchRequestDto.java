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

//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private String pickUpDate;
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private String dropOffDate;

}
