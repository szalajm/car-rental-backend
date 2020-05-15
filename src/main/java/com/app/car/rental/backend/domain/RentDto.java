package com.app.car.rental.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RentDto {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Vehicle vehicle;
    private User user;
    private LocalDateTime pickupDate;
    private LocalDateTime returnDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDateTime pickupDate) {
        this.pickupDate = pickupDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public RentDto(Vehicle vehicle, User user, LocalDateTime pickupDate, LocalDateTime returnDate) {
        this.vehicle = vehicle;
        this.user = user;
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
    }

    //    public Long getPayment(LocalDateTime pickupDate, LocalDateTime returnDate) {
//        return ChronoUnit.DAYS.between(returnDate, pickupDate) * vehicle.getBasicPrice();
//
//    }
}
