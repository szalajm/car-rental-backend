package com.app.car.rental.backend.domain;

import com.app.car.rental.backend.api.avis.model.rate.TaxesFees;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.Map;

@Entity
//@Getter
////@NoArgsConstructor
////@AllArgsConstructor
public class AvisModelRateDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRateCode() {
        return rateCode;
    }

    public void setRateCode(String rateCode) {
        this.rateCode = rateCode;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public TaxesFees getTaxesFees() {
        return taxesFees;
    }

    public void setTaxesFees(TaxesFees taxesFees) {
        this.taxesFees = taxesFees;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    public AvisModelRateDto(String currency, String rateCode, Integer days, Double amount, TaxesFees taxesFees, Map<String, Object> additionalProperties) {
        this.currency = currency;
        this.rateCode = rateCode;
        this.days = days;
        this.amount = amount;
        this.taxesFees = taxesFees;
        this.additionalProperties = additionalProperties;
    }
}
