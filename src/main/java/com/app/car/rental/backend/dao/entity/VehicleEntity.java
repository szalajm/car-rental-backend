package com.app.car.rental.backend.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "CATEGORY_ID", unique = true, nullable = false, updatable = false)
    private CategoryEntity category;

//    private FeaturesDto features;
//    private CapacityDto capacity;
//    private Map<String, Object> additionalProperties = new HashMap<>();


    public VehicleEntity() {}

    @Override
    public String toString() {
        return "VehicleEntity{" +
                "id=" + id +
                ", category=" + category +
                '}';
    }
}
