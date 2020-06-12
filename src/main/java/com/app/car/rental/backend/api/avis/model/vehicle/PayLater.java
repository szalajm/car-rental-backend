
package com.app.car.rental.backend.api.avis.model.vehicle;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "vehicle_total",
    "reservation_total"
})
public class PayLater {

    @JsonProperty("vehicle_total")
    private Double vehicleTotal;
    @JsonProperty("reservation_total")
    private Double reservationTotal;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("vehicle_total")
    public Double getVehicleTotal() {
        return vehicleTotal;
    }

    @JsonProperty("vehicle_total")
    public void setVehicleTotal(Double vehicleTotal) {
        this.vehicleTotal = vehicleTotal;
    }

    @JsonProperty("reservation_total")
    public Double getReservationTotal() {
        return reservationTotal;
    }

    @JsonProperty("reservation_total")
    public void setReservationTotal(Double reservationTotal) {
        this.reservationTotal = reservationTotal;
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
