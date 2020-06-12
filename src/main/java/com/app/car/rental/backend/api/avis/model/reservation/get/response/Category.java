
package com.app.car.rental.backend.api.avis.model.reservation.get.response;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "make",
    "model",
    "vehicle_class_code",
    "vehicle_class_name",
    "vehicle_transmission",
    "mpg",
    "image_url"
})
public class Category {

    @JsonProperty("name")
    private String name;
    @JsonProperty("make")
    private String make;
    @JsonProperty("model")
    private String model;
    @JsonProperty("vehicle_class_code")
    private String vehicleClassCode;
    @JsonProperty("vehicle_class_name")
    private String vehicleClassName;
    @JsonProperty("vehicle_transmission")
    private String vehicleTransmission;
    @JsonProperty("mpg")
    private String mpg;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("make")
    public String getMake() {
        return make;
    }

    @JsonProperty("make")
    public void setMake(String make) {
        this.make = make;
    }

    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    @JsonProperty("model")
    public void setModel(String model) {
        this.model = model;
    }

    @JsonProperty("vehicle_class_code")
    public String getVehicleClassCode() {
        return vehicleClassCode;
    }

    @JsonProperty("vehicle_class_code")
    public void setVehicleClassCode(String vehicleClassCode) {
        this.vehicleClassCode = vehicleClassCode;
    }

    @JsonProperty("vehicle_class_name")
    public String getVehicleClassName() {
        return vehicleClassName;
    }

    @JsonProperty("vehicle_class_name")
    public void setVehicleClassName(String vehicleClassName) {
        this.vehicleClassName = vehicleClassName;
    }

    @JsonProperty("vehicle_transmission")
    public String getVehicleTransmission() {
        return vehicleTransmission;
    }

    @JsonProperty("vehicle_transmission")
    public void setVehicleTransmission(String vehicleTransmission) {
        this.vehicleTransmission = vehicleTransmission;
    }

    @JsonProperty("mpg")
    public String getMpg() {
        return mpg;
    }

    @JsonProperty("mpg")
    public void setMpg(String mpg) {
        this.mpg = mpg;
    }

    @JsonProperty("image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("image_url")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
        return new ToStringBuilder(this).append("name", name).append("make", make).append("model", model).append("vehicleClassCode", vehicleClassCode).append("vehicleClassName", vehicleClassName).append("vehicleTransmission", vehicleTransmission).append("mpg", mpg).append("imageUrl", imageUrl).append("additionalProperties", additionalProperties).toString();
    }

}
