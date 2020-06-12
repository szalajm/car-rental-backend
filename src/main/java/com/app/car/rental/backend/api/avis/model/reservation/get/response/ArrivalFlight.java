
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
    "airline_code",
    "airline_number"
})
public class ArrivalFlight {

    @JsonProperty("airline_code")
    private String airlineCode;
    @JsonProperty("airline_number")
    private String airlineNumber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("airline_code")
    public String getAirlineCode() {
        return airlineCode;
    }

    @JsonProperty("airline_code")
    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    @JsonProperty("airline_number")
    public String getAirlineNumber() {
        return airlineNumber;
    }

    @JsonProperty("airline_number")
    public void setAirlineNumber(String airlineNumber) {
        this.airlineNumber = airlineNumber;
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
        return new ToStringBuilder(this).append("airlineCode", airlineCode).append("airlineNumber", airlineNumber).append("additionalProperties", additionalProperties).toString();
    }

}
