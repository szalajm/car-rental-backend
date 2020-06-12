
package com.app.car.rental.backend.api.avis.model.vehicle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "pickup_location",
    "dropoff_location",
    "terms"
})
public class Reservation {

    @JsonProperty("pickup_location")
    private PickupLocation pickupLocation;
    @JsonProperty("dropoff_location")
    private DropoffLocation dropoffLocation;
    @JsonProperty("terms")
    private List<Term> terms = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("pickup_location")
    public PickupLocation getPickupLocation() {
        return pickupLocation;
    }

    @JsonProperty("pickup_location")
    public void setPickupLocation(PickupLocation pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    @JsonProperty("dropoff_location")
    public DropoffLocation getDropoffLocation() {
        return dropoffLocation;
    }

    @JsonProperty("dropoff_location")
    public void setDropoffLocation(DropoffLocation dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }

    @JsonProperty("terms")
    public List<Term> getTerms() {
        return terms;
    }

    @JsonProperty("terms")
    public void setTerms(List<Term> terms) {
        this.terms = terms;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
