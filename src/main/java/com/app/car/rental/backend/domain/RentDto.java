package com.app.car.rental.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RentDto {
    private long id;
    private Vehicle vehicle;
    private User user;
    private LocalDateTime pickupDate;
    private LocalDateTime returnDate;

//    public Long getPayment(LocalDateTime pickupDate, LocalDateTime returnDate) {
//        return ChronoUnit.DAYS.between(returnDate, pickupDate) * vehicle.getBasicPrice();
//
//    }
}
