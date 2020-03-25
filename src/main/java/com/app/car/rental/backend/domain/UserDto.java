package com.app.car.rental.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private long id;
    private String name;


//    private String lastname;
//    private UserStatus userStatus;
//    private List<RentDto> rents;
}
