
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
    "unlimited_distance",
    "distance_unit"
})
public class Distance {

    @JsonProperty("unlimited_distance")
    private Boolean unlimitedDistance;
    @JsonProperty("distance_unit")
    private String distanceUnit;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("unlimited_distance")
    public Boolean getUnlimitedDistance() {
        return unlimitedDistance;
    }

    @JsonProperty("unlimited_distance")
    public void setUnlimitedDistance(Boolean unlimitedDistance) {
        this.unlimitedDistance = unlimitedDistance;
    }

    @JsonProperty("distance_unit")
    public String getDistanceUnit() {
        return distanceUnit;
    }

    @JsonProperty("distance_unit")
    public void setDistanceUnit(String distanceUnit) {
        this.distanceUnit = distanceUnit;
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
        return new ToStringBuilder(this).append("unlimitedDistance", unlimitedDistance).append("distanceUnit", distanceUnit).append("additionalProperties", additionalProperties).toString();
    }

}
