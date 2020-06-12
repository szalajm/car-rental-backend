
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
    "large_suitcase"
})
public class LuggageCapacity {

    @JsonProperty("large_suitcase")
    private String largeSuitcase;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("large_suitcase")
    public String getLargeSuitcase() {
        return largeSuitcase;
    }

    @JsonProperty("large_suitcase")
    public void setLargeSuitcase(String largeSuitcase) {
        this.largeSuitcase = largeSuitcase;
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
