
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
    "rate_code",
    "currency",
    "amount",
    "days",
    "loyalty",
    "membership",
    "taxes_fees",
    "coupon"
})
public class Rate {

    @JsonProperty("rate_code")
    private String rateCode;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("days")
    private Integer days;
    @JsonProperty("loyalty")
    private Loyalty loyalty;
    @JsonProperty("membership")
    private Membership membership;
    @JsonProperty("taxes_fees")
    private TaxesFees taxesFees;
    @JsonProperty("coupon")
    private Coupon coupon;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("rate_code")
    public String getRateCode() {
        return rateCode;
    }

    @JsonProperty("rate_code")
    public void setRateCode(String rateCode) {
        this.rateCode = rateCode;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("amount")
    public Double getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @JsonProperty("days")
    public Integer getDays() {
        return days;
    }

    @JsonProperty("days")
    public void setDays(Integer days) {
        this.days = days;
    }

    @JsonProperty("loyalty")
    public Loyalty getLoyalty() {
        return loyalty;
    }

    @JsonProperty("loyalty")
    public void setLoyalty(Loyalty loyalty) {
        this.loyalty = loyalty;
    }

    @JsonProperty("membership")
    public Membership getMembership() {
        return membership;
    }

    @JsonProperty("membership")
    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    @JsonProperty("taxes_fees")
    public TaxesFees getTaxesFees() {
        return taxesFees;
    }

    @JsonProperty("taxes_fees")
    public void setTaxesFees(TaxesFees taxesFees) {
        this.taxesFees = taxesFees;
    }

    @JsonProperty("coupon")
    public Coupon getCoupon() {
        return coupon;
    }

    @JsonProperty("coupon")
    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
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
        return new ToStringBuilder(this).append("rateCode", rateCode).append("currency", currency).append("amount", amount).append("days", days).append("loyalty", loyalty).append("membership", membership).append("taxesFees", taxesFees).append("coupon", coupon).append("additionalProperties", additionalProperties).toString();
    }

}
