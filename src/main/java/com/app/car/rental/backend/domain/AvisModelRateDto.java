package com.app.car.rental.backend.domain;

import com.app.car.rental.backend.api.avis.model.rate.TaxesFees;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

//Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AvisModelRateDto {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;

    //@JsonProperty("currency")
    private String currency;
    //@JsonProperty("rate_code")
    private String rateCode;
    //@JsonProperty("days")
    private Integer days;
    //@JsonProperty("amount")
    private Double amount;
    //@JsonProperty("taxes_fees")
    private TaxesFees taxesFees;
    //@JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}
