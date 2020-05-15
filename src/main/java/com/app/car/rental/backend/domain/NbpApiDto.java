package com.app.car.rental.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NbpApiDto {

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

//    public NbpApiDto(Long id, String name) {
//        this.id = id;
//        this.name = name;
//    }
}
