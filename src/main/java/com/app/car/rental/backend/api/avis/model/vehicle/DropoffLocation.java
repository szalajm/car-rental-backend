
package com.app.car.rental.backend.api.avis.model.vehicle;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "location",
    "address"
})
public class DropoffLocation {

    @JsonProperty("location")
    private Location_ location;
    @JsonProperty("address")
    private Address_ address;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("location")
    public Location_ getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location_ location) {
        this.location = location;
    }

    @JsonProperty("address")
    public Address_ getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(Address_ address) {
        this.address = address;
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
