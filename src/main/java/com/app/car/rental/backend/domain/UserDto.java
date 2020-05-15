package com.app.car.rental.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;



    //    private String lastname;
//    private UserStatus userStatus;
//    private List<RentDto> rents;
}
