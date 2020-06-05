
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
    "email_notification",
    "pickup_date",
    "pickup_location",
    "dropoff_date",
    "dropoff_location",
    "vehicle_class_code"
})
public class Reservation {

    @JsonProperty("email_notification")
    private Boolean emailNotification;
    @JsonProperty("pickup_date")
    private String pickupDate;
    @JsonProperty("pickup_location")
    private String pickupLocation;
    @JsonProperty("dropoff_date")
    private String dropoffDate;
    @JsonProperty("dropoff_location")
    private String dropoffLocation;
    @JsonProperty("vehicle_class_code")
    private String vehicleClassCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("email_notification")
    public Boolean getEmailNotification() {
        return emailNotification;
    }

    @JsonProperty("email_notification")
    public void setEmailNotification(Boolean emailNotification) {
        this.emailNotification = emailNotification;
    }

    @JsonProperty("pickup_date")
    public String getPickupDate() {
        return pickupDate;
    }

    @JsonProperty("pickup_date")
    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    @JsonProperty("pickup_location")
    public String getPickupLocation() {
        return pickupLocation;
    }

    @JsonProperty("pickup_location")
    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    @JsonProperty("dropoff_date")
    public String getDropoffDate() {
        return dropoffDate;
    }

    @JsonProperty("dropoff_date")
    public void setDropoffDate(String dropoffDate) {
        this.dropoffDate = dropoffDate;
    }

    @JsonProperty("dropoff_location")
    public String getDropoffLocation() {
        return dropoffLocation;
    }

    @JsonProperty("dropoff_location")
    public void setDropoffLocation(String dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }

    @JsonProperty("vehicle_class_code")
    public String getVehicleClassCode() {
        return vehicleClassCode;
    }

    @JsonProperty("vehicle_class_code")
    public void setVehicleClassCode(String vehicleClassCode) {
        this.vehicleClassCode = vehicleClassCode;
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
        return new ToStringBuilder(this).append("emailNotification", emailNotification).append("pickupDate", pickupDate).append("pickupLocation", pickupLocation).append("dropoffDate", dropoffDate).append("dropoffLocation", dropoffLocation).append("vehicleClassCode", vehicleClassCode).append("additionalProperties", additionalProperties).toString();
    }

}
