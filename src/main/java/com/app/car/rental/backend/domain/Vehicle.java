package com.app.car.rental.backend.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@Entity
@EqualsAndHashCode
public class Vehicle {

    private long id;
    private String name;

    }

