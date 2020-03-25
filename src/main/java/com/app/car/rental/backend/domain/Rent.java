package com.app.car.rental.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rent {

    @Id
    @GeneratedValue
    @Column(name = "rentId")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "carId")
    private Vehicle vehicle;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @NotNull
    private LocalDateTime pickupDate;

    @NotNull
    private LocalDateTime returnDate;

    //public Long getPayment(LocalDateTime pickupDate, LocalDateTime returnDate) {
      //  return ChronoUnit.DAYS.between(returnDate, pickupDate) * vehicle.getBasicPrice();
    //}
}