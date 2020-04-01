package com.app.car.rental.backend.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "rentId")
    private Long id;

    private String name;

//    @NotNull
//    @ManyToOne
//    @JoinColumn(name = "carId")
    //private Vehicle vehicle;

//    @NotNull
//    @ManyToOne
//    @JoinColumn(name = "userId")
    //private User user;

    //@NotNull
    private LocalDateTime pickupDate;

    //@NotNull
    private LocalDateTime returnDate;

    //public Long getPayment(LocalDateTime pickupDate, LocalDateTime returnDate) {
      //  return ChronoUnit.DAYS.between(returnDate, pickupDate) * vehicle.getBasicPrice();
    //}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Rent(String name, LocalDateTime pickupDate, LocalDateTime returnDate) {
        this.name = name;
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
    }
}