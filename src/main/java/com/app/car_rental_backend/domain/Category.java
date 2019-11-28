package com.app.car_rental_backend.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "categoryId")
    private Long id;

    @NotNull
    private String name;


    @OneToMany(
            targetEntity = Car.class,
            mappedBy = "category",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    private List<Car> cars = new ArrayList<>();

    }


