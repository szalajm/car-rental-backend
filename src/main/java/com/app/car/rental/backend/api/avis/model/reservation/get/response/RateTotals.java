
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
    "rate",
    "totals"
})
public class RateTotals {

    @JsonProperty("rate")
    private Rate rate;
    @JsonProperty("totals")
    private Totals totals;
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

    @JsonProperty("totals")
    public Totals getTotals() {
        return totals;
    }

    @JsonProperty("totals")
    public void setTotals(Totals totals) {
        this.totals = totals;
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
        return new ToStringBuilder(this).append("rate", rate).append("totals", totals).append("additionalProperties", additionalProperties).toString();
    }

}
