
package com.app.car.rental.backend.api.avis.model.rate;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "distance",
    "pickup_location",
    "dropoff_location",
    "rate_totals",
    "insurance",
    "extras",
    "terms"
})
public class Reservation {

    @JsonProperty("distance")
    private Distance distance;
    @JsonProperty("pickup_location")
    private PickupLocation pickupLocation;
    @JsonProperty("dropoff_location")
    private DropoffLocation dropoffLocation;
    @JsonProperty("rate_totals")
    private RateTotals rateTotals;
    @JsonProperty("insurance")
    private List<Insurance> insurance = null;
    @JsonProperty("extras")
    private List<Extra> extras = null;
    @JsonProperty("terms")
    private List<Term> terms = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("distance")
    public Distance getDistance() {
        return distance;
    }

    @JsonProperty("distance")
    public void setDistance(Distance distance) {
        this.distance = distance;
    }

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

    @JsonProperty("rate_totals")
    public RateTotals getRateTotals() {
        return rateTotals;
    }

    @JsonProperty("rate_totals")
    public void setRateTotals(RateTotals rateTotals) {
        this.rateTotals = rateTotals;
    }

    @JsonProperty("insurance")
    public List<Insurance> getInsurance() {
        return insurance;
    }

    @JsonProperty("insurance")
    public void setInsurance(List<Insurance> insurance) {
        this.insurance = insurance;
    }

    @JsonProperty("extras")
    public List<Extra> getExtras() {
        return extras;
    }

    @JsonProperty("extras")
    public void setExtras(List<Extra> extras) {
        this.extras = extras;
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

    @Override
    public String toString() {
        return "Reservation{" +
                "distance=" + distance +
                ", pickupLocation=" + pickupLocation +
                ", dropoffLocation=" + dropoffLocation +
                ", rateTotals=" + rateTotals +
                ", insurance=" + insurance +
                ", extras=" + extras +
                ", terms=" + terms +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
