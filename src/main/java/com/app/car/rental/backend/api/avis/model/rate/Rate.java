
package com.app.car.rental.backend.api.avis.model.rate;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "currency",
    "rate_code",
    "days",
    "amount",
    "taxes_fees"
})
public class Rate {

    @JsonProperty("currency")
    private String currency;
    @JsonProperty("rate_code")
    private String rateCode;
    @JsonProperty("days")
    private Integer days;
    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("taxes_fees")
    private TaxesFees taxesFees;
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

    @JsonProperty("days")
    public Integer getDays() {
        return days;
    }

    @JsonProperty("days")
    public void setDays(Integer days) {
        this.days = days;
    }

    @JsonProperty("amount")
    public Double getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @JsonProperty("taxes_fees")
    public TaxesFees getTaxesFees() {
        return taxesFees;
    }

    @JsonProperty("taxes_fees")
    public void setTaxesFees(TaxesFees taxesFees) {
        this.taxesFees = taxesFees;
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
        return "Rate{" + "currency='" + currency + '\'' +
                ", rateCode='" + rateCode + '\'' +
                ", days=" + days +
                ", amount=" + amount +
                ", taxesFees=" + taxesFees +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
