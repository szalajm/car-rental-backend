
package com.app.car.rental.backend.api.avis.model.rate;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "vehicle_total",
    "taxes_fees_total",
    "insurance_total",
    "extras_total",
    "reservation_total"
})
public class Totals {

    @JsonProperty("vehicle_total")
    private Double vehicleTotal;
    @JsonProperty("taxes_fees_total")
    private Double taxesFeesTotal;
    @JsonProperty("insurance_total")
    private Double insuranceTotal;
    @JsonProperty("extras_total")
    private Double extrasTotal;
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

    @JsonProperty("taxes_fees_total")
    public Double getTaxesFeesTotal() {
        return taxesFeesTotal;
    }

    @JsonProperty("taxes_fees_total")
    public void setTaxesFeesTotal(Double taxesFeesTotal) {
        this.taxesFeesTotal = taxesFeesTotal;
    }

    @JsonProperty("insurance_total")
    public Double getInsuranceTotal() {
        return insuranceTotal;
    }

    @JsonProperty("insurance_total")
    public void setInsuranceTotal(Double insuranceTotal) {
        this.insuranceTotal = insuranceTotal;
    }

    @JsonProperty("extras_total")
    public Double getExtrasTotal() {
        return extrasTotal;
    }

    @JsonProperty("extras_total")
    public void setExtrasTotal(Double extrasTotal) {
        this.extrasTotal = extrasTotal;
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

    @Override
    public String toString() {
        return "Totals{" +
                "vehicleTotal=" + vehicleTotal +
                ", taxesFeesTotal=" + taxesFeesTotal +
                ", insuranceTotal=" + insuranceTotal +
                ", extrasTotal=" + extrasTotal +
                ", reservationTotal=" + reservationTotal +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
