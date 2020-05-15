package com.app.car.rental.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;


//@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NbpModelRateDto {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;

    //@JsonProperty("currency")
    private String currency;
    //@JsonProperty("code")
    private String code;
    //@JsonProperty("mid")
    private Double mid;
    //@JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


}
