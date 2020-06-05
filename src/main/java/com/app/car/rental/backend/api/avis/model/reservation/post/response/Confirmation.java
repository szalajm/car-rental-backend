
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
    "number",
    "pickup_date",
    "dropoff_date"
})
public class Confirmation {

    @JsonProperty("number")
    private String number;
    @JsonProperty("pickup_date")
    private String pickupDate;
    @JsonProperty("dropoff_date")
    private String dropoffDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("number")
    public String getNumber() {
        return number;
    }

    @JsonProperty("number")
    public void setNumber(String number) {
        this.number = number;
    }

    @JsonProperty("pickup_date")
    public String getPickupDate() {
        return pickupDate;
    }

    @JsonProperty("pickup_date")
    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    @JsonProperty("dropoff_date")
    public String getDropoffDate() {
        return dropoffDate;
    }

    @JsonProperty("dropoff_date")
    public void setDropoffDate(String dropoffDate) {
        this.dropoffDate = dropoffDate;
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
        return new ToStringBuilder(this).append("number", number).append("pickupDate", pickupDate).append("dropoffDate", dropoffDate).append("additionalProperties", additionalProperties).toString();
    }

}
