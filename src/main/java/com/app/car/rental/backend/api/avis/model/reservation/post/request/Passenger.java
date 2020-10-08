
package com.app.car.rental.backend.api.avis.model.reservation.post.request;

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
    "contact",
    "address",
    "driver"
})
public class Passenger {

    @JsonProperty("contact")
    private Contact contact;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("driver")
    private Driver driver;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("contact")
    public Contact getContact() {
        return contact;
    }

    @JsonProperty("contact")
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonProperty("driver")
    public Driver getDriver() {
        return driver;
    }

    @JsonProperty("driver")
    public void setDriver(Driver driver) {
        this.driver = driver;
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
        return "Passenger{" +
                "contact=" + contact +
                ", address=" + address +
                ", driver=" + driver +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
