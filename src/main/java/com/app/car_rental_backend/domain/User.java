package com.app.car_rental_backend.domain;

import com.sun.javafx.beans.IDProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue
    @Column(name = "userId")
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @OneToMany
    private List<Rent> rents = new ArrayList<>();


}
