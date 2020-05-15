package com.app.car.rental.backend.domain;

import com.app.car.rental.backend.api.avis.model.vehicle.Capacity;
import com.app.car.rental.backend.api.avis.model.vehicle.Category;
import com.app.car.rental.backend.api.avis.model.vehicle.Features;
import com.app.car.rental.backend.api.avis.model.vehicle.RateTotals;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;


//@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AvisModelVehicleDto {

//    @Id
//    @GeneratedValue
    //private Long id;

    //JsonProperty("cat")
    private Category category;
    //@JsonProperty("features")
    private Features features;
    //@JsonProperty("capacity")
    private Capacity capacity;
    //@JsonProperty("rate_totals")
    private RateTotals rateTotals;
    //@JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


}
