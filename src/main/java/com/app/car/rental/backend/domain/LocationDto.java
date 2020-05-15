package com.app.car.rental.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LocationDto {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

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

//    public LocationDto(Long id, String name) {
//        this.id= id;
//        this.name = name;
    //}
}
