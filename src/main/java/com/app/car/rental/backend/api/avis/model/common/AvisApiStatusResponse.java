
package com.app.car.rental.backend.api.avis.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
    "status"
})
public class AvisApiStatusResponse {

    @JsonProperty("status")
    private AvisApiStatus status;

    @JsonProperty("status")
    public AvisApiStatus getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(AvisApiStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AvisApiStatusResponse{" +
                "status=" + status +
                '}';
    }
}
