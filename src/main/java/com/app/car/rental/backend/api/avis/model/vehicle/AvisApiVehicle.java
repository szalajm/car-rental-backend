
package com.app.car.rental.backend.api.avis.model.vehicle;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "transaction",
    "product",
    "vehicles",
    "reservation"
})
public class AvisApiVehicle {

    @JsonProperty("status")
    private Status status;
    @JsonProperty("transaction")
    private Transaction transaction;
    @JsonProperty("product")
    private Product product;
    @JsonProperty("vehicles")
    private List<Vehicle> vehicles = null;
    @JsonProperty("reservation")
    private Reservation reservation;
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

    @JsonProperty("product")
    public Product getProduct() {
        return product;
    }

    @JsonProperty("product")
    public void setProduct(Product product) {
        this.product = product;
    }

    @JsonProperty("vehicles")
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    @JsonProperty("vehicles")
    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @JsonProperty("reservation")
    public Reservation getReservation() {
        return reservation;
    }

    @JsonProperty("reservation")
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
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
        return "AvisApiVehicle{" +
                "status=" + status +
                ", transaction=" + transaction +
                ", product=" + product +
                ", vehicles=" + vehicles +
                ", reservation=" + reservation +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
