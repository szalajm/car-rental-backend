
package com.app.car.rental.backend.api.avis.model.reservation.get.response;

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
    "quantity",
    "coupon_applied",
    "coupon_amount"
})
public class Coupon {

    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("coupon_applied")
    private Boolean couponApplied;
    @JsonProperty("coupon_amount")
    private Double couponAmount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("quantity")
    public Integer getQuantity() {
        return quantity;
    }

    @JsonProperty("quantity")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("coupon_applied")
    public Boolean getCouponApplied() {
        return couponApplied;
    }

    @JsonProperty("coupon_applied")
    public void setCouponApplied(Boolean couponApplied) {
        this.couponApplied = couponApplied;
    }

    @JsonProperty("coupon_amount")
    public Double getCouponAmount() {
        return couponAmount;
    }

    @JsonProperty("coupon_amount")
    public void setCouponAmount(Double couponAmount) {
        this.couponAmount = couponAmount;
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
        return new ToStringBuilder(this).append("quantity", quantity).append("couponApplied", couponApplied).append("couponAmount", couponAmount).append("additionalProperties", additionalProperties).toString();
    }

}
