
package com.app.car.rental.backend.api.avis.model.vehicle;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "currency",
    "rate_code",
    "coupon_applied",
    "under_age_fee_applied",
    "coupon_discount_amount"
})
public class Rate {

    @JsonProperty("currency")
    private String currency;
    @JsonProperty("rate_code")
    private String rateCode;
    @JsonProperty("coupon_applied")
    private Boolean couponApplied;
    @JsonProperty("under_age_fee_applied")
    private Boolean underAgeFeeApplied;
    @JsonProperty("coupon_discount_amount")
    private Double couponDiscountAmount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("rate_code")
    public String getRateCode() {
        return rateCode;
    }

    @JsonProperty("rate_code")
    public void setRateCode(String rateCode) {
        this.rateCode = rateCode;
    }

    @JsonProperty("coupon_applied")
    public Boolean getCouponApplied() {
        return couponApplied;
    }

    @JsonProperty("coupon_applied")
    public void setCouponApplied(Boolean couponApplied) {
        this.couponApplied = couponApplied;
    }

    @JsonProperty("under_age_fee_applied")
    public Boolean getUnderAgeFeeApplied() {
        return underAgeFeeApplied;
    }

    @JsonProperty("under_age_fee_applied")
    public void setUnderAgeFeeApplied(Boolean underAgeFeeApplied) {
        this.underAgeFeeApplied = underAgeFeeApplied;
    }

    @JsonProperty("coupon_discount_amount")
    public Double getCouponDiscountAmount() {
        return couponDiscountAmount;
    }

    @JsonProperty("coupon_discount_amount")
    public void setCouponDiscountAmount(Double couponDiscountAmount) {
        this.couponDiscountAmount = couponDiscountAmount;
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
