
package com.app.car.rental.backend.api.avis.model.location;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "transaction",
    "locations"
})
public class AvisApiLocation {

    @JsonProperty("status")
    private Status status;
    @JsonProperty("transaction")
    private Transaction transaction;
    @JsonProperty("locations")
    private List<Location> locations = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonProperty("transaction")
    public Transaction getTransaction() {
        return transaction;
    }

    @JsonProperty("transaction")
    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @JsonProperty("locations")
    public List<Location> getLocations() {
        return locations;
    }

    @JsonProperty("locations")
    public void setLocations(List<Location> locations) {
        this.locations = locations;
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
        return "AvisApiLocation{" +
                "status=" + status +
                ", transaction=" + transaction +
                ", locations=" + locations +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
