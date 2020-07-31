package com.app.car.rental.backend.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String make;
    private String model;
    private String vehicleClassCode;
    private String vehicleClassName;
    private String imageUrl;
//    private Map<String, Object> additionalProperties = new HashMap<>();

    public CategoryEntity() {}

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", vehicleClassCode='" + vehicleClassCode + '\'' +
                ", vehicleClassName='" + vehicleClassName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
