package com.app.car.rental.backend.web.model;

import com.app.car.rental.backend.api.avis.model.location.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@NoArgsConstructor
@AllArgsConstructor
//@Entity
public class AvisModelLocationDto {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
   //private Long id;

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

}
