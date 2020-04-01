package com.app.car.rental.backend.domain;

import com.app.car.rental.backend.api.avis.model.location.Address;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.Map;

//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class AvisModelLocationDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@JsonProperty("brand")
    private String brand;
    //@JsonProperty("code")
    private String code;
    //@JsonProperty("name")
    private String name;
    //@JsonProperty("telephone")
    private String telephone;
    //@JsonProperty("hours")
    private String hours;
    //@JsonProperty("airport_location")
    private Boolean airportLocation;
    //@JsonProperty("address")
    private Address address;
    //@JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public Boolean getAirportLocation() {
        return airportLocation;
    }

    public void setAirportLocation(Boolean airportLocation) {
        this.airportLocation = airportLocation;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    public AvisModelLocationDto(String brand, String code, String name, String telephone, String hours, Boolean airportLocation, Address address, Map<String, Object> additionalProperties) {
        this.brand = brand;
        this.code = code;
        this.name = name;
        this.telephone = telephone;
        this.hours = hours;
        this.airportLocation = airportLocation;
        this.address = address;
        this.additionalProperties = additionalProperties;
    }
}
