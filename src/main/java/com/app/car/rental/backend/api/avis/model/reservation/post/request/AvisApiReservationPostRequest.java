
package com.app.car.rental.backend.api.avis.model.reservation.post.request;

import java.util.HashMap;
import java.util.List;
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
    "product",
    "transaction",
    "reservation",
    "rate_totals",
    "passenger",
    "insurance",
    "extras",
    "arrival_flight"
})
public class AvisApiReservationPostRequest {

    @JsonProperty("product")
    private Product product;
    @JsonProperty("transaction")
    private Transaction transaction;
    @JsonProperty("reservation")
    private Reservation reservation;
    @JsonProperty("rate_totals")
    private RateTotals rateTotals;
    @JsonProperty("passenger")
    private Passenger passenger;
    @JsonProperty("insurance")
    private List<Insurance> insurance = null;
    @JsonProperty("extras")
    private List<Extra> extras = null;
    @JsonProperty("arrival_flight")
    private ArrivalFlight arrivalFlight;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("product")
    public Product getProduct() {
        return product;
    }

    @JsonProperty("product")
    public void setProduct(Product product) {
        this.product = product;
    }

    @JsonProperty("transaction")
    public Transaction getTransaction() {
        return transaction;
    }

    @JsonProperty("transaction")
    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @JsonProperty("reservation")
    public Reservation getReservation() {
        return reservation;
    }

    @JsonProperty("reservation")
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @JsonProperty("rate_totals")
    public RateTotals getRateTotals() {
        return rateTotals;
    }

    @JsonProperty("rate_totals")
    public void setRateTotals(RateTotals rateTotals) {
        this.rateTotals = rateTotals;
    }

    @JsonProperty("passenger")
    public Passenger getPassenger() {
        return passenger;
    }

    @JsonProperty("passenger")
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    @JsonProperty("insurance")
    public List<Insurance> getInsurance() {
        return insurance;
    }

    @JsonProperty("insurance")
    public void setInsurance(List<Insurance> insurance) {
        this.insurance = insurance;
    }

    @JsonProperty("extras")
    public List<Extra> getExtras() {
        return extras;
    }

    @JsonProperty("extras")
    public void setExtras(List<Extra> extras) {
        this.extras = extras;
    }

    @JsonProperty("arrival_flight")
    public ArrivalFlight getArrivalFlight() {
        return arrivalFlight;
    }

    @JsonProperty("arrival_flight")
    public void setArrivalFlight(ArrivalFlight arrivalFlight) {
        this.arrivalFlight = arrivalFlight;
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
        return new ToStringBuilder(this).append("product", product).append("transaction", transaction).append("reservation", reservation).append("rateTotals", rateTotals).append("passenger", passenger).append("insurance", insurance).append("extras", extras).append("arrivalFlight", arrivalFlight).append("additionalProperties", additionalProperties).toString();
    }

}
