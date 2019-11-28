package com.app.car_rental_backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Search {

    @Id
    @GeneratedValue
    private long id;

    @ManyToMany
    @JoinColumn(name = "carId")
    private List<Car> selectedCars = new ArrayList<>();

    public void selectCriteria(){
        System.out.println("builder to be implemented");
    }
}
