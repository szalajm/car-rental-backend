
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
    "code",
    "name",
    "telephone",
    "hours",
    "airport_location"
})
public class Location_ {

    @JsonProperty("code")
    private String code;
    @JsonProperty("name")
    private String name;
    @JsonProperty("telephone")
    private String telephone;
    @JsonProperty("hours")
    private String hours;
    @JsonProperty("airport_location")
    private Boolean airportLocation;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("telephone")
    public String getTelephone() {
        return telephone;
    }

    @JsonProperty("telephone")
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @JsonProperty("hours")
    public String getHours() {
        return hours;
    }

    @JsonProperty("hours")
    public void setHours(String hours) {
        this.hours = hours;
    }

    @JsonProperty("airport_location")
    public Boolean getAirportLocation() {
        return airportLocation;
    }

    @JsonProperty("airport_location")
    public void setAirportLocation(Boolean airportLocation) {
        this.airportLocation = airportLocation;
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
        return new ToStringBuilder(this).append("code", code).append("name", name).append("telephone", telephone).append("hours", hours).append("airportLocation", airportLocation).append("additionalProperties", additionalProperties).toString();
    }

}
