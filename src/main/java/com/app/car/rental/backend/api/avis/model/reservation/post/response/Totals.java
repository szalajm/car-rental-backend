
package com.app.car.rental.backend.api.avis.model.reservation.post.response;

import java.util.HashMap;
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
    "taxes_fees_total",
    "insurance_total",
    "extras_total",
    "discount_total",
    "vehicle_total",
    "reservation_total"
})
public class Totals {

    @JsonProperty("taxes_fees_total")
    private Double taxesFeesTotal;
    @JsonProperty("insurance_total")
    private Double insuranceTotal;
    @JsonProperty("extras_total")
    private Double extrasTotal;
    @JsonProperty("discount_total")
    private Double discountTotal;
    @JsonProperty("vehicle_total")
    private Double vehicleTotal;
    @JsonProperty("reservation_total")
    private Double reservationTotal;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    @JsonProperty("discount_total")
    public Double getDiscountTotal() {
        return discountTotal;
    }

    @JsonProperty("discount_total")
    public void setDiscountTotal(Double discountTotal) {
        this.discountTotal = discountTotal;
    }

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

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("taxesFeesTotal", taxesFeesTotal).append("insuranceTotal", insuranceTotal).append("extrasTotal", extrasTotal).append("discountTotal", discountTotal).append("vehicleTotal", vehicleTotal).append("reservationTotal", reservationTotal).append("additionalProperties", additionalProperties).toString();
    }

}
