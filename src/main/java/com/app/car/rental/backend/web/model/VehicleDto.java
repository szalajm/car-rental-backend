package com.app.car.rental.backend.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDto {
    private Long id;

    private CategoryDto category;
//    private FeaturesDto features;
//    private CapacityDto capacity;
//    private Map<String, Object> additionalProperties = new HashMap<>();

}
