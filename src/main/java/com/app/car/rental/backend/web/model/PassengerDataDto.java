package com.app.car.rental.backend.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

import static com.app.car.rental.backend.web.controller.ControllerConstants.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDataDto {
    // Address
    @NotBlank(message = PASSENGER_ADDRESS_VALIDATION_MESSAGE)
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    @NotBlank(message = PASSENGER_CITY_VALIDATION_MESSAGE)
    private String city;
    private String addressCountryCode;
    @NotBlank(message = PASSENGER_POSTALCODE_VALIDATION_MESSAGE)
    private String postalCode;

    // Contact
    @NotBlank(message = PASSENGER_NAME_VALIDATION_MESSAGE)
    private String firstName;
    @NotBlank(message = PASSENGER_LASTNAME_VALIDATION_MESSAGE)
    private String lastName;
    private String title;
    private String dateOfBirth;
    @NotBlank(message = PASSENGER_EMAIL_VALIDATION_MESSAGE)
    private String email;
    @NotBlank(message = PASSENGER_TELEPHONE_VALIDATION_MESSAGE)
    private String telephone;

    // Driver
    private String licenseNumber;
    private String driverCountryCode;
    private String stateCode;
}
