package com.app.car.rental.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Search {

    private long id;
    private String name;

//    @NotNull
//    private LocalDateTime pickupDate;
//
//    @NotNull
//    private LocalDateTime returnDate;
//
//    @NotNull
//    private String location;
//
//    public void selectCriteria(){
//        System.out.println("builder to be implemented");
//    }
}
