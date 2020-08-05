package com.app.car.rental.backend.dao.entity;

import javax.persistence.CascadeType;
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

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CATEGORY_ID", unique = true, nullable = false, updatable = false)
    private CategoryEntity category;

//    private FeaturesDto features;
//    private CapacityDto capacity;
//    private Map<String, Object> additionalProperties = new HashMap<>();


    public VehicleEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "VehicleEntity{" +
                "id=" + id +
                ", category=" + category +
                '}';
    }
}
