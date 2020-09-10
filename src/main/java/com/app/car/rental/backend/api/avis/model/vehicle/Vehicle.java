
package com.app.car.rental.backend.api.avis.model.vehicle;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "category",
    "features",
    "capacity",
    "rate_totals"
})
public class Vehicle {
    @JsonIgnore
    private String id;

    @JsonProperty("category")
    private Category category;
    @JsonProperty("features")
    private Features features;
    @JsonProperty("capacity")
    private Capacity capacity;
    @JsonProperty("rate_totals")
    private RateTotals rateTotals;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("category")
    public Category getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(Category category) {
        this.category = category;
    }

    @JsonProperty("features")
    public Features getFeatures() {
        return features;
    }

    @JsonProperty("features")
    public void setFeatures(Features features) {
        this.features = features;
    }

    @JsonProperty("capacity")
    public Capacity getCapacity() {
        return capacity;
    }

    @JsonProperty("capacity")
    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    @JsonProperty("rate_totals")
    public RateTotals getRateTotals() {
        return rateTotals;
    }

    @JsonProperty("rate_totals")
    public void setRateTotals(RateTotals rateTotals) {
        this.rateTotals = rateTotals;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", category=" + category +
                ", features=" + features +
                ", capacity=" + capacity +
                ", rateTotals=" + rateTotals +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
