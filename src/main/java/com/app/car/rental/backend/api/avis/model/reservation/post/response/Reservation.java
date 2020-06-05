
package com.app.car.rental.backend.api.avis.model.reservation.post.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "confirmation",
    "distance",
    "pickup_location",
    "dropoff_location",
    "extras",
    "rate_totals",
    "insurance",
    "vehicle",
    "terms"
})
public class Reservation {

    @JsonProperty("confirmation")
    private Confirmation confirmation;
    @JsonProperty("distance")
    private Distance distance;
    @JsonProperty("pickup_location")
    private PickupLocation pickupLocation;
    @JsonProperty("dropoff_location")
    private DropoffLocation dropoffLocation;
    @JsonProperty("extras")
    private List<Extra> extras = null;
    @JsonProperty("rate_totals")
    private RateTotals rateTotals;
    @JsonProperty("insurance")
    private List<Insurance> insurance = null;
    @JsonProperty("vehicle")
    private Vehicle vehicle;
    @JsonProperty("terms")
    private List<Term> terms = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("confirmation")
    public Confirmation getConfirmation() {
        return confirmation;
    }

    @JsonProperty("confirmation")
    public void setConfirmation(Confirmation confirmation) {
        this.confirmation = confirmation;
    }

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

    @JsonProperty("extras")
    public List<Extra> getExtras() {
        return extras;
    }

    @JsonProperty("extras")
    public void setExtras(List<Extra> extras) {
        this.extras = extras;
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

    @JsonProperty("vehicle")
    public Vehicle getVehicle() {
        return vehicle;
    }

    @JsonProperty("vehicle")
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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
        return new ToStringBuilder(this).append("confirmation", confirmation).append("distance", distance).append("pickupLocation", pickupLocation).append("dropoffLocation", dropoffLocation).append("extras", extras).append("rateTotals", rateTotals).append("insurance", insurance).append("vehicle", vehicle).append("terms", terms).append("additionalProperties", additionalProperties).toString();
    }

}
