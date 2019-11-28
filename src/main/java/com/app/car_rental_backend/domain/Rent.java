package com.app.car_rental_backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static java.util.concurrent.TimeUnit.DAYS;

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
    private Car car;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate returnDate;

    public Long getPayment(LocalDate startDate, LocalDate returnDate) {
        return ChronoUnit.DAYS.between(returnDate, startDate) * car.getBasicPrice();
    }
}