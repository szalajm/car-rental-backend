
package com.app.car.rental.backend.api.avis.model.reservation.post.request;

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
    "rate_code",
    "country_code",
    "discount",
    "loyalty",
    "membership"
})
public class Rate {

    @JsonProperty("rate_code")
    private String rateCode;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("discount")
    private Discount discount;
    @JsonProperty("loyalty")
    private Loyalty loyalty;
    @JsonProperty("membership")
    private Membership membership;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("rate_code")
    public String getRateCode() {
        return rateCode;
    }

    @JsonProperty("rate_code")
    public void setRateCode(String rateCode) {
        this.rateCode = rateCode;
    }

    @JsonProperty("country_code")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("country_code")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("discount")
    public Discount getDiscount() {
        return discount;
    }

    @JsonProperty("discount")
    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    @JsonProperty("loyalty")
    public Loyalty getLoyalty() {
        return loyalty;
    }

    @JsonProperty("loyalty")
    public void setLoyalty(Loyalty loyalty) {
        this.loyalty = loyalty;
    }

    @JsonProperty("membership")
    public Membership getMembership() {
        return membership;
    }

    @JsonProperty("membership")
    public void setMembership(Membership membership) {
        this.membership = membership;
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
        return new ToStringBuilder(this).append("rateCode", rateCode).append("countryCode", countryCode).append("discount", discount).append("loyalty", loyalty).append("membership", membership).append("additionalProperties", additionalProperties).toString();
    }

}
