package com.app.car.rental.backend.web.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

import static com.app.car.rental.backend.web.controller.ControllerConstants.DROP_OFF_LOCATION_VALIDATION_MESSAGE;
import static com.app.car.rental.backend.web.controller.ControllerConstants.PICK_UP_LOCATION_VALIDATION_MESSAGE;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationSearchRequestDto {
    @NotBlank(message = PICK_UP_LOCATION_VALIDATION_MESSAGE)
    private String pickUpLocation;
    @NotBlank(message = DROP_OFF_LOCATION_VALIDATION_MESSAGE)
    private String dropOffLocation;

    //    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotBlank(message = PICK_UP_LOCATION_VALIDATION_MESSAGE)
    private String pickUpDate;
    //    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotBlank(message = PICK_UP_LOCATION_VALIDATION_MESSAGE)
    private String dropOffDate;

}
