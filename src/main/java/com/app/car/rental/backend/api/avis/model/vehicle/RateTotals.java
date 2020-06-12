
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
    "rate",
    "pay_later"
})
public class RateTotals {

    @JsonProperty("rate")
    private Rate rate;
    @JsonProperty("pay_later")
    private PayLater payLater;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("rate")
    public Rate getRate() {
        return rate;
    }

    @JsonProperty("rate")
    public void setRate(Rate rate) {
        this.rate = rate;
    }

    @JsonProperty("pay_later")
    public PayLater getPayLater() {
        return payLater;
    }

    @JsonProperty("pay_later")
    public void setPayLater(PayLater payLater) {
        this.payLater = payLater;
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
