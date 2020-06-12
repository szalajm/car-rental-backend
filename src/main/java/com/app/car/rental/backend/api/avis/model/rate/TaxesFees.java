
package com.app.car.rental.backend.api.avis.model.rate;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "taxes",
    "fees"
})
public class TaxesFees {

    @JsonProperty("taxes")
    private List<Tax> taxes = null;
    @JsonProperty("fees")
    private List<Fee> fees = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("taxes")
    public List<Tax> getTaxes() {
        return taxes;
    }

    @JsonProperty("taxes")
    public void setTaxes(List<Tax> taxes) {
        this.taxes = taxes;
    }

    @JsonProperty("fees")
    public List<Fee> getFees() {
        return fees;
    }

    @JsonProperty("fees")
    public void setFees(List<Fee> fees) {
        this.fees = fees;
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
