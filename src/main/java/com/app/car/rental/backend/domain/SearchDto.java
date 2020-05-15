package com.app.car.rental.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SearchDto {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SearchDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    //private List<VehicleDto> selected;
    //private LocalDateTime pickupDate;
//    private LocalDateTime returnDate;
//    private String location;
//
//    public void selectCriteria(){
//        System.out.println("builder to be implemented");
//    }

}
