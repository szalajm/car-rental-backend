package com.app.car.rental.backend.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDataDto {
    // Address
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String city;
    private String addressCountryCode;
    private String postalCode;

    // Contact
    private String firstName;
    private String lastName;
    private String title;
    private String dateOfBirth;
    private String email;
    private String telephone;

    // Driver
    private String licenseNumber;
    private String driverCountryCode;
    private String stateCode;
}
