
package com.app.car.rental.backend.api.avis.model.location;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "brand",
    "code",
    "name",
    "telephone",
    "hours",
    "airport_location",
    "address"
})

@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @JsonProperty("brand")
    private String brand;
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
    @JsonProperty("address")
    private Address address;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("brand")
    public String getBrand() {
        return brand;
    }

    @JsonProperty("brand")
    public void setBrand(String brand) {
        this.brand = brand;
    }

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

    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(Address address) {
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

    @Override
    public String toString() {
        return "Location{" +
                "brand='" + brand + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", hours='" + hours + '\'' +
                ", airportLocation=" + airportLocation +
                ", address=" + address +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
