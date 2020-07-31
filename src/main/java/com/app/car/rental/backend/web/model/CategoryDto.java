package com.app.car.rental.backend.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Long id;

    private String name;
    private String make;
    private String model;
    private String vehicleClassCode;
    private String vehicleClassName;
    private String imageUrl;
//    private Map<String, Object> additionalProperties = new HashMap<>();

}
