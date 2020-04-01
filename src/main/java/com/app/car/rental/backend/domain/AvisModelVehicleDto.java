package com.app.car.rental.backend.domain;

import com.app.car.rental.backend.api.avis.model.vehicle.Capacity;
import com.app.car.rental.backend.api.avis.model.vehicle.Category;
import com.app.car.rental.backend.api.avis.model.vehicle.Features;
import com.app.car.rental.backend.api.avis.model.vehicle.RateTotals;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.Map;


@Entity
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
public class AvisModelVehicleDto {

    @Id
    @GeneratedValue
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Features getFeatures() {
        return features;
    }

    public void setFeatures(Features features) {
        this.features = features;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    public RateTotals getRateTotals() {
        return rateTotals;
    }

    public void setRateTotals(RateTotals rateTotals) {
        this.rateTotals = rateTotals;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    public AvisModelVehicleDto(Category category, Features features, Capacity capacity, RateTotals rateTotals, Map<String, Object> additionalProperties) {
        this.category = category;
        this.features = features;
        this.capacity = capacity;
        this.rateTotals = rateTotals;
        this.additionalProperties = additionalProperties;
    }
}
