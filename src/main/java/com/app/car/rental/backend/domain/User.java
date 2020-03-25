package com.app.car.rental.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
//@Entity
public class User {

    private long id;
    private String name;

//    @Id
//    @GeneratedValue
//    @Column(name = "userId")
//    private Long id;
//
//    @NotNull
//    private String firstName;
//
//    @NotNull
//    private String lastName;
//
//    @NotNull
//    @Enumerated(EnumType.STRING)
//    private UserStatus userStatus;
//
//    @OneToMany
//    private List<Rent> rents;

}
