
package com.app.car.rental.backend.api.avis.model.vehicle;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bluetooth_equipped",
    "smoke_free",
    "air_conditioned",
    "connected_car"
})
public class Features {

    @JsonProperty("bluetooth_equipped")
    private Boolean bluetoothEquipped;
    @JsonProperty("smoke_free")
    private Boolean smokeFree;
    @JsonProperty("air_conditioned")
    private Boolean airConditioned;
    @JsonProperty("connected_car")
    private Boolean connectedCar;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("bluetooth_equipped")
    public Boolean getBluetoothEquipped() {
        return bluetoothEquipped;
    }

    @JsonProperty("bluetooth_equipped")
    public void setBluetoothEquipped(Boolean bluetoothEquipped) {
        this.bluetoothEquipped = bluetoothEquipped;
    }

    @JsonProperty("smoke_free")
    public Boolean getSmokeFree() {
        return smokeFree;
    }

    @JsonProperty("smoke_free")
    public void setSmokeFree(Boolean smokeFree) {
        this.smokeFree = smokeFree;
    }

    @JsonProperty("air_conditioned")
    public Boolean getAirConditioned() {
        return airConditioned;
    }

    @JsonProperty("air_conditioned")
    public void setAirConditioned(Boolean airConditioned) {
        this.airConditioned = airConditioned;
    }

    @JsonProperty("connected_car")
    public Boolean getConnectedCar() {
        return connectedCar;
    }

    @JsonProperty("connected_car")
    public void setConnectedCar(Boolean connectedCar) {
        this.connectedCar = connectedCar;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
