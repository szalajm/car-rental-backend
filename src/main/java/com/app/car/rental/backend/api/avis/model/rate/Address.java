
package com.app.car.rental.backend.api.avis.model.rate;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "address_line_1",
    "address_line_2",
    "city",
    "state_name",
    "postal_code",
    "country_code"
})
public class Address {

    @JsonProperty("address_line_1")
    private String addressLine1;
    @JsonProperty("address_line_2")
    private String addressLine2;
    @JsonProperty("city")
    private String city;
    @JsonProperty("state_name")
    private String stateName;
    @JsonProperty("postal_code")
    private String postalCode;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("address_line_1")
    public String getAddressLine1() {
        return addressLine1;
    }

    @JsonProperty("address_line_1")
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    @JsonProperty("address_line_2")
    public String getAddressLine2() {
        return addressLine2;
    }

    @JsonProperty("address_line_2")
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("state_name")
    public String getStateName() {
        return stateName;
    }

    @JsonProperty("state_name")
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @JsonProperty("postal_code")
    public String getPostalCode() {
        return postalCode;
    }

    @JsonProperty("postal_code")
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @JsonProperty("country_code")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("country_code")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
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
